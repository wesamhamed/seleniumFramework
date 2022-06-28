package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    //Method to take screenshot when test case fail

    public static void captureScreenshot(WebDriver driver,String screenshotname){

        try{
            Path dest = Paths.get("./Screenshots",screenshotname+".png");
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        }catch (Exception ex){
            System.out.println("Exception while taking screenshot "+ex.getMessage());
        }

    }
}
