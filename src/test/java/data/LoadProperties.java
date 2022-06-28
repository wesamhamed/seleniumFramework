package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    //Load the properties file from the folder
    public static Properties userData= loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");

    public  static Properties loadProperties(String path){
        Properties properties = new Properties();
        //Stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            properties.load(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
