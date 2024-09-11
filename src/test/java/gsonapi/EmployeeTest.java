package gsonapi;

import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class EmployeeTest {

    // Serialization -- Convert Java object to Json payload
    @Test
    public void gsonSerializatonTest() {
        // Create object for POJO class
        Employee employee = new Employee();
        employee.setFristName("Sadakar");
        employee.setLastName("Pochampalli");
        employee.setAge(32);
        employee.setSalary(75000);
        employee.setDesignation("Manager");
        employee.setContactNumber("9989722222");
        employee.setEmailId("abc@testc.com");

        Gson gson = new Gson();
        String employeeJsonPayload = gson.toJson(employee);
        System.out.println("Json:" + employeeJsonPayload);

        Gson builder = new GsonBuilder().setPrettyPrinting().create();
        String employeePrettyJsonPayload = builder.toJson(employee);
        System.out.println("Pretty Json:" + employeePrettyJsonPayload);
    }

    // De-serialization -- Convert Json response as Java class object
    @Test
    public void getDetailFromJson() {

        // De-serializing from Json String

        String jsonString = "{\r\n"
                + " \"firstName\" : \"Deserialization\",\r\n"
                + " \"lastName\" : \"Test\",\r\n"
                + " \"age\" : 30,\r\n"
                + " \"salary\" : 75000.0,\r\n"
                + " \"designation\" : \"Manager\",\r\n"
                + " \"contactNumber\" : \"9989721090\",\r\n"
                + " \"emailId\" : \"abc@test.com\",\r\n"
                + " \"gender\" : \"male\",\r\n"
                + " \"maritalStatus\" : \"married\" \r\n"
                + "}";
        Gson gson = new Gson();
        // Pass JSON string and the POJO class
        Employee employee = gson.fromJson(jsonString,Employee.class);

        // Now use getter methods to retrieve values
        System.out.println("Details of employee is as below:");
        System.out.println("First Name:"+employee.getFristName());
        System.out.println("Last Name:"+employee.getLastName());
        System.out.println("Age:"+employee.getAge());
        System.out.println("Salary:"+employee.getSalary());
        System.out.println("Designation:"+employee.getDesignation());
        System.out.println("Contact Number:"+employee.getContactNumber());
        System.out.println("Email:"+employee.getEmailId());
        System.out.println("****************************************************");
    }

    @Test
    public  void getDetailFromJsonAsFile() throws FileNotFoundException {
        Gson gson = new Gson();

        // De-serializing from a json file
        String userDir = System.getProperty("user.dir");
        File inputJsonFile = new File(userDir+"//src//test//resources//testdata//gson-api/employee.json");
        FileReader fileReader = new FileReader(inputJsonFile);
        Employee employee1 = gson.fromJson(fileReader,Employee.class);

        // Now use getter methods to retrieve values
        System.out.println("Details of employee is as below:");
        System.out.println("First Name:"+employee1.getFristName());
        System.out.println("Last Name:"+employee1.getLastName());
        System.out.println("Age:"+employee1.getAge());
        System.out.println("Salary:"+employee1.getSalary());
        System.out.println("Designation:"+employee1.getDesignation());
        System.out.println("Contact Number:"+employee1.getContactNumber());
        System.out.println("Email:"+employee1.getEmailId());
        System.out.println("****************************************************");
    }
}
