package data;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public  Object[][] jsonDataReader() throws IOException, ParseException {
        String path = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.json";
        File srcFile = new File(path);
        JSONParser parser = new JSONParser();
        JSONArray jarray =(JSONArray)parser.parse(new FileReader(srcFile));
        Object [][]userData =new Object[jarray.size()][4];
        for(int i=0;i<jarray.size();i++){
            String firstName,lastName,email,password;
            JSONObject person= (JSONObject)jarray.get(i);
            firstName = (String)person.get("firstName");
            lastName = (String)person.get("lastName");
            email = (String)person.get("email");
            password = (String)person.get("password");
            userData[i][0]=firstName;
            userData[i][1]=lastName;
            userData[i][2]=email;
            userData[i][3]=password;
        }
        return userData;
    }
}
