package stepdefinitions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;

import commonutils.APISchemaGenerator;
import commonutils.SchemaValidator;
import config.TestConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CurrencyConversionStepDefs {
	private static final Logger logger = LogManager.getLogger(CurrencyConversionStepDefs.class);

	private Response response;

	@Given("I have a valid API end-point for currency {string}")
	public void i_have_a_valid_api_endpoint(String currency) {
		String endPoint = TestConfig.getBaseUrl() + "/" + currency;
		RestAssured.baseURI = endPoint;
	}

	@When("I make a GET request to the API")
	public void i_make_a_get_request_to_the_api() {
		response = RestAssured.get();
		logger.info(response.body().prettyPrint());
	}

	@Then("the API call is successful and returns success")
	public void the_api_call_is_successful_and_returns_success() {
		response.then().statusCode(200).body("result", equalTo("success"));
	}

	@Then("the response contains a valid price")
	public void the_response_contains_a_valid_price() {
		response.then().body("rates", Matchers.notNullValue());
	}

	@Then("the response contains {int} currency pairs")
	public void the_response_contains_currency_pairs(int count) {
		Map<String, ?> rates = response.then().extract().path("rates");
		assertThat(rates.keySet(), hasSize(count));
	}

	@Then("the API response should matches the JSON schema")
	public void verifyJsonResponse() {
		try {

			assertTrue(SchemaValidator.validateResponseAgainstSchema(response, APISchemaGenerator.getSchema(response)));
		} catch (IOException | ProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("the status code is within the range")
	public void the_status_code_is_within_the_range() {
		response.then().statusCode(Matchers.allOf(Matchers.greaterThanOrEqualTo(200), Matchers.lessThan(300)));
	}

	@Then("the response contains a valid price range for AED")
	public void the_response_contains_a_valid_price_range_for_AED() {
		float usdToAEDRate = response.then().extract().path("rates.AED");
		assertTrue(usdToAEDRate >= 3.6 && usdToAEDRate <= 3.7);

	}
}