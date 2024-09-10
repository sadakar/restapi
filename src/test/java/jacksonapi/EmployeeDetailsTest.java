package jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EmployeeDetailsTest {

    // Serialize the request and send post request
    @Test
    public void createEmployee(){
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setName("Sadakar");
        employeeDetails.setSalary(75000);
        employeeDetails.setAge(30);

        // Convert Java object to a JSON string
        ObjectMapper mapper = new ObjectMapper();
        String employeeDetailsPrettyJson = null;
        try{
            employeeDetailsPrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeDetails);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        System.out.println("Request");
        System.out.println(employeeDetailsPrettyJson);
        System.out.println("=========================");
        System.out.println("Response");

        // Post request
        given().baseUri("https://dummy.restapiexample.com/api").contentType(ContentType.JSON).
                body(employeeDetailsPrettyJson).when().post("/v1/create")
                .then().assertThat().statusCode(200)
                .body("data.name",equalTo("Sadakar"))
                .body("message",equalTo("Successfully! Record has been added."))
                .log().body();
    }
}
