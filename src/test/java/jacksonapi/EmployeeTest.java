package jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class EmployeeTest {

    /**
     *  Serializaton :  A process of converting an instance of a class(object of a class) into a Byte Stream.
     *  i.e., Converting Employee class object to JSON representation
     */
    @Test
    public void serializationTest() throws JsonProcessingException {

        // jacksonapi.Employee object and data
        Employee employee = new Employee();
        employee.setFirstName("Sadakar");
        employee.setLastName("Pochampalli");
        employee.setAge(30);
        employee.setSalary(75000);
        employee.setDesignation("Manager");

        // Converting a Java class object to a JSON payload as String
        ObjectMapper mapper = new ObjectMapper();
        String employeeJson = mapper.writeValueAsString(employee);
        System.out.println(employeeJson);

        String employeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        System.out.println(employeePrettyJson);
    }

    /**
     *  Deserialization: Reverse of serialization
     *  Read the serialized byte stream from the file and convert it class instance representation.
     *  i.e., Converting JSON Object to and class object
     */
    @Test
    public void deserializationTest() throws JsonProcessingException {
        Employee employee = new Employee();
        employee.setFirstName("Hasini");
        employee.setLastName("Boray");
        employee.setAge(29);
        employee.setSalary(75000);
        employee.setDesignation("Manager");

        ObjectMapper mapper = new ObjectMapper();
        String employeeJson = mapper.writeValueAsString(employee);

        Employee employee1 = mapper.readValue(employeeJson, Employee.class);
        System.out.println("First Name:"+employee1.getFirstName());
        System.out.println("Last Name:"+employee1.getLastName());
        System.out.println("Age:"+employee1.getAge());
        System.out.println("Salary:"+employee1.getSalary());
        System.out.println("Designation:"+employee1.getDesignation());
    }
}
