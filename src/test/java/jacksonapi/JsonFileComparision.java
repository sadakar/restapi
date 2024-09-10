package jacksonapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class JsonFileComparision {

    @Test
    public void compareResponse() throws IOException {
        // Path to the JSON file
        File jsonFile = new File("src//test//resources//testdata//jackson-api//expectedUser.json");

        // Read JSON content from file
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonFromFile = objectMapper.readTree(jsonFile);

        // Make an API call
        Response response = RestAssured.given().when().get("https://reqres.in/api/users/3").then().extract().response();
        String expectedResponse = response.getBody().asString();
        System.out.println("Response is : "+expectedResponse);

        // Verify the status code
        response.then().statusCode(200);

        // Read JSON content from response
        JsonNode jsonFromResponse = objectMapper.readTree(expectedResponse);
        Assert.assertEquals(jsonFromResponse, jsonFromFile);

        // Compare JSON content
        if(jsonFromFile.equals(jsonFromResponse)){
            System.out.println("JSON from file matches JSON from response");
        } else {
            System.out.println("JSON content does not match");
        }
    }
}
