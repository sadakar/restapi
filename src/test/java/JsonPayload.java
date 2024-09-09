import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonPayload {

    public String loadJsonFile(String jsonFilepath) {
        String requestBody = null;
        try {
            // Load JSON payload from file
            requestBody = new String(Files.readAllBytes(Paths.get(jsonFilepath)));
        } catch (IOException e) {
            // Handle exception if file is not found or can't be read
            e.printStackTrace();
        }
        return requestBody;
    }
}
