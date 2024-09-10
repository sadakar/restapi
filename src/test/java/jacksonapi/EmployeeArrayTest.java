package jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeArrayTest {

    // Serialization -- Convert Class Object to JSON Array
    @Test
    public void createEmployeeArray(){
        EmployeeArray emp1 = new EmployeeArray();
        emp1.setFirstName("Sadakar");
        emp1.setLastName("Pochampalli");
        emp1.setAge(30);
        emp1.setSalary(75000);
        emp1.setDesignation("Manager");
        emp1.setContactNumber("998973240");
        emp1.setEmailId("abc@test.com");

        EmployeeArray emp2 = new EmployeeArray();
        emp2.setFirstName("Ram");
        emp2.setLastName("Bandari");
        emp2.setAge(32);
        emp2.setSalary(85000);
        emp2.setDesignation("Manager");
        emp2.setContactNumber("123456789");
        emp2.setEmailId("abc2@test.com");

        EmployeeArray emp3 = new EmployeeArray();
        emp3.setFirstName("Hasini");
        emp3.setLastName("Bommani");
        emp3.setAge(34);
        emp3.setSalary(95000);
        emp3.setDesignation("Sr Manager");
        emp3.setContactNumber("998973240");
        emp3.setEmailId("abc3@test.com");

        // Creating list of employees
        List<EmployeeArray> employeeList = new ArrayList<EmployeeArray>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        // Convert a Java class object to JSON array payload as String
        ObjectMapper mapper = new ObjectMapper();
        try{
            String allEmployeeJson = mapper.writeValueAsString(employeeList);
            System.out.println(allEmployeeJson);

            String allEmployeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);
            System.out.println(allEmployeePrettyJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    // Deserialization -- Convert JSON array to Class Object
    @Test
    public void getEmployeeArray(){

        ObjectMapper mapper = new ObjectMapper();

        // Converting Employee Json string to Employee class object
        List<EmployeeArray> allEmployeeDetails = null;
        try{
            allEmployeeDetails = mapper.readValue(new File("src//test//resources//testdata//jackson-api//employeearray.json"), new TypeReference<List<EmployeeArray>>() {
            });
        }catch (StreamReadException e){
            e.printStackTrace();
        }catch (DatabindException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        for(EmployeeArray empArray: allEmployeeDetails){
            System.out.println("**************************************");
            System.out.println("First Name:"+empArray.getFirstName());
            System.out.println("Last Name:"+empArray.getLastName());
            System.out.println("Age:"+empArray.getAge());
            System.out.println("Salary:"+empArray.getSalary());
            System.out.println("Designation:"+empArray.getDesignation());
            System.out.println("Contact:"+empArray.getDesignation());
            System.out.println("Email Id:"+ empArray.getEmailId());
        }
    }
}
