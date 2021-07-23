package Data;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    public String email1,email2,email3,email4,email5;

    public void jsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/Data/Emails.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray emailsArray = (JSONArray) parser.parse(new FileReader(srcFile));

        for (Object Email :emailsArray)
        {
            JSONObject invalidEmails = (JSONObject) Email;
            email1 = (String) invalidEmails.get("email1");
            email2 = (String) invalidEmails.get("email2");
            email3 = (String) invalidEmails.get("email3");
            email4 = (String) invalidEmails.get("email4");
            email5 = (String) invalidEmails.get("email5");
        }
    }

}
