package commonutils;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.response.Response;

public class APISchemaGenerator {

    public static JsonSchema getSchema(Response response) throws Exception {
        String responseBody = response.getBody().asString();
        JsonNode responseJson = JsonLoader.fromString(responseBody);
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        return factory.getJsonSchema(responseJson);
    }
}
