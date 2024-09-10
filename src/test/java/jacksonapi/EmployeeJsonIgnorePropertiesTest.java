package jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class EmployeeJsonIgnorePropertiesTest {

    @Test
    public void serializationTest(){

        // Creating object
        EmployeeJsonIgnoreProperties employeeJsonIgnore = new EmployeeJsonIgnoreProperties();
        employeeJsonIgnore.setFirstName("Sadakar");
        employeeJsonIgnore.setLastName("Pochampalli");
        employeeJsonIgnore.setAge(32);
        employeeJsonIgnore.setSalary(75000);
        employeeJsonIgnore.setDesignation("Manager");
        employeeJsonIgnore.setContactNumber("779399374937");
        employeeJsonIgnore.setEmailId("abc@test.com");
        employeeJsonIgnore.setMaritalStatus("married");
        employeeJsonIgnore.setGender("Male");

        // Converting java class object to JSON payload String
        ObjectMapper mapper = new ObjectMapper();
        try{
            String employeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeJsonIgnore);
            System.out.println(employeePrettyJson);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        System.out.println("****************************************");
    }

    @Test
    public void deserializationTest(){
        String employeeString = "{\r\n"
                +" \"firstName\" : \"Deserialization\",\r\n"
                +" \"lastName\" : \"Test\",\r\n"
                +" \"age\" : 30,\r\n"
                +" \"salary\" : 75000.0,\r\n"
                +" \"designation\" : \"Manager\",\r\n"
                +" \"contactNumber\" : \"9989721090\",\r\n"
                +" \"emailId\" : \"abc@test.com\",\r\n"
                +" \"gender\" : \"male\",\r\n"
                +" \"maritalStatus\" : \"married\",\r\n"
                + "}";

        // Converting a JSON payload to a Java object
        ObjectMapper mapper = new ObjectMapper();
        EmployeeJsonIgnoreProperties employeeJsonIgnoreProperties = null;
        try{
            employeeJsonIgnoreProperties = mapper.readValue(employeeString,EmployeeJsonIgnoreProperties.class);
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }

}
