package jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonToMap {

    // Deserialization
    @Test
    public void deserializationTest(){

        String employeeString = "{\r\n"
                +" \"firstName\":\"Desrialization\",\r\n"
                +" \"lastName\": \"Test\",\r\n"
                +" \"age\": 25,\r\n"
                +" \"salary\": 50000.0,\r\n"
                +" \"designation\": \"Manager\",\r\n"
                +" \"contactNumber\": \"7374387483\",\r\n"
                +" \"emailId\": \"abc@test.com\",\r\n"
                +" \"gender\": \"male\",\r\n"
                +" \"maritalStatus\": \"single\"\r\n"
                +"}";

        Map<String,String> resultMap = new HashMap<String,String>();
        ObjectMapper mapper = new ObjectMapper();

        // Converting JSON to Java Map
        try{
            resultMap =mapper.readValue(employeeString, new TypeReference<HashMap<String, String>>(){});
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        System.out.println("Output Map:"+resultMap);
    }

    @Test
    public void payloadFromFile(){
        String userDir = System.getProperty("user.dir");
        ObjectMapper mapper = new ObjectMapper();

        // Converting Employee JSON string to Employee class Object
        Map<String, Object> empMap;
        try{
            empMap = mapper.readValue(new File(userDir + "//src//test//resources//testdata//jackson-api//jsonfrommap.json"),
                    new TypeReference<Map<String, Object>>() {
                    });
            System.out.println("Gender:"+empMap.get("gender"));
            System.out.println("DOB:"+empMap.get("DOB"));
            System.out.println("Name:"+empMap.get("name"));
            System.out.println("ContractNumber:"+empMap.get("contactNumber"));
            System.out.println("SkillSet:"+empMap.get("skillset"));
        }catch (StreamReadException e){
            e.printStackTrace();
        }catch (DatabindException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
