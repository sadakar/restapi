package jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeNestedPOJOTest {

    // Serialization
    @Test
    public void createNestedPOJO() throws IOException {

        EmployeeNestedPOJO empNestedPojo = new EmployeeNestedPOJO();
        empNestedPojo.setCompanyName("Pochampalli IT Labs");
        empNestedPojo.setCompanyEmailId("pochampalli@email.com");
        empNestedPojo.setCompanyNumber("99897654321");
        empNestedPojo.setCompanyAddress("Hyderabad");

        List<String> supportedSalaryBanks = new ArrayList<>();
        supportedSalaryBanks.add("AIB");
        supportedSalaryBanks.add("BOI");
        supportedSalaryBanks.add("PSB");
        empNestedPojo.setSupportedSalaryBanks(supportedSalaryBanks);

        // First Employee
        EmployeePOJO emp1 = new EmployeePOJO();
        emp1.setFirstName("Sadakar");
        emp1.setLastName("Pochampalli");
        emp1.setAge(30);
        emp1.setSalary(75000);
        emp1.setDesignation("Software Engineer");
        emp1.setContactNumber("89898989898");
        emp1.setEmailId("sadakar@email.com");

        // Second Employee
        EmployeePOJO emp2 = new EmployeePOJO();
        emp2.setFirstName("Hasini");
        emp2.setLastName("Bommani");
        emp2.setAge(28);
        emp2.setSalary(65000);
        emp2.setDesignation("Software Engineer");
        emp2.setContactNumber("898955652");
        emp2.setEmailId("hasini@email.com");

        // Third Employee
        EmployeePOJO emp3 = new EmployeePOJO();
        emp3.setFirstName("Ram");
        emp3.setLastName("Bandari");
        emp3.setAge(35);
        emp3.setSalary(95000);
        emp3.setDesignation("Manager - Software Engineer");
        emp3.setContactNumber("12345678");
        emp3.setEmailId("ram@email.com");

        // Creating list of employees
        List<EmployeePOJO> employeePOJOList = new ArrayList<EmployeePOJO>();
        employeePOJOList.add(emp1);
        employeePOJOList.add(emp2);
        employeePOJOList.add(emp3);
        empNestedPojo.setEmployeePojo(employeePOJOList);

        // First Contractor
        ContractorPOJO con1 = new ContractorPOJO();
        con1.setFirstName("John");
        con1.setLastName("Mathew");
        con1.setContractFrom("Jan-2018");
        con1.setContractTo("Aug-2012");
        con1.setContactNumber("468364836483");

        // Second Contractor
        ContractorPOJO con2 = new ContractorPOJO();
        con2.setFirstName("Seema");
        con2.setLastName("Dhora");
        con2.setContractFrom("Jan-2018");
        con2.setContractTo("Aug-2012");
        con2.setContactNumber("54545454545");

        // Creating a list of Contractors
        List<ContractorPOJO> contractorPOJOList = new ArrayList<ContractorPOJO>();
        contractorPOJOList.add(con1);
        contractorPOJOList.add(con2);
        empNestedPojo.setContractorPojo(contractorPOJOList);

        // Company PF details
        CompanyPfPOJO pfPOJO = new CompanyPfPOJO();
        pfPOJO.setPfName("XYZ");
        pfPOJO.setPfYear(2020);
        pfPOJO.setNoOfEmployees(100);
        empNestedPojo.setCompanyPfPOJO(pfPOJO);


        ObjectMapper mapper = new ObjectMapper();
        String nestedJsonPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empNestedPojo);
        System.out.println(nestedJsonPayload);

        // Save json payload as a file in the project directory
        String userDirectory = System.getProperty("user.dir");
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(userDirectory+"\\src\\test\\resources\\testdata\\NestedEmployeePayload.json"),empNestedPojo);

    }
}
