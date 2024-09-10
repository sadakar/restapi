package jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class EmployeeJsonIgnoreTest {

    @Test
    public void serializationTest(){

        // Creating object
        EmployeeJsonIgnore employeeJsonIgnore = new EmployeeJsonIgnore();
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


}
