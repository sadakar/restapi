package jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapToJsonString {

    @Test
    public void serializationMapTest(){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> inputMap = new HashMap<String,Object>();

        inputMap.put("employeeId","1234");
        inputMap.put("name","Sadakar");
        inputMap.put("DOB","12-02-1985");
        inputMap.put("salary","75000.0");
        inputMap.put("location","Dublin");
        inputMap.put("contactNumber","998972222");
        inputMap.put("emailId","abc@test.com");
        inputMap.put("gender","female");

        List<String> skillSet = new ArrayList<String>();
        skillSet.add("Java");
        skillSet.add("Teradata");
        skillSet.add("Python");
        skillSet.add("Power BI");

        inputMap.put("skillset",skillSet);

        // Converting map to JSON payload as String
        try{
            String employeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(inputMap);
            System.out.println(employeePrettyJson);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        String userDir = System.getProperty("user.dir");

        //Writing JSON on a file
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(userDir+"//src//test//resources//testdata//jackson-api//jsonfrommap.json"),inputMap);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
