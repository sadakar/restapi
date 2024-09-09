import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetTests {

    JsonPayload jsonPayload = new JsonPayload();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test(priority = 0)
    public void createPetValidInput() {
        String payloadBody = jsonPayload.loadJsonFile("src/test/resources/testdata/createpet.json");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(payloadBody).
                when()
                .post("/v2/pet").
                then()
                .statusCode(200)
                .body("id", equalTo(12345))
                .body("name", equalTo("Buddy"))
                .body("status", equalTo("available"))
                .log()
                .all()
                .extract()
                .response();

        String expectedContentType = "application/json";
        String actualContentType = response.getContentType();
        Assert.assertEquals(actualContentType, expectedContentType);

        int expectedCategoryId = 1;
        int actualCategoryId = response.jsonPath().getInt("category.id");
        Assert.assertEquals(actualCategoryId, expectedCategoryId);

        String expectedCategoryName = "Dogs";
        String actualCategoryName = response.jsonPath().getString("category.name");
        Assert.assertEquals(actualCategoryName, expectedCategoryName);

        String expectedTagsId= "[1]";
        String actualTagsId=response.jsonPath().getString("tags.id");
        Assert.assertEquals(actualTagsId,expectedTagsId);

        String expectedTagsName="[friendly]";
        String actualTagsName= response.jsonPath().getString("tags.name");
        Assert.assertEquals(actualTagsName,expectedTagsName);

    }
    @Test(priority = 1)
    public void createPetInvalidInput() {

        String payloadBody = jsonPayload.loadJsonFile("src/test/resources/testdata/createpet-400invalidinput.json");

        Response response2 = given()
                .header("Content-Type", "application/json")
                .body(payloadBody).
                when()
                .post("/v2/pet").
                then()
                .statusCode(400)
                .body("code", equalTo(400))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("bad input"))
                .log()
                .all()
                .extract()
                .response();
    }
}
