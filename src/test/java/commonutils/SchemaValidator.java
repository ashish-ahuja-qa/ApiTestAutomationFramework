package commonutils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import io.restassured.response.Response;

import java.io.IOException;

public class SchemaValidator {

	public static boolean validateResponseAgainstSchema(Response response, JsonSchema jsonSchema) throws IOException, ProcessingException {
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode responseJson = objectMapper.readTree(response.getBody().asString());
	    return jsonSchema.validate(responseJson).isSuccess();
	}

}
