package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationWithDDTAndCSV extends TestBase{

    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    String firstName="wesam";
    String lastName="hamad";
    String email="test@test10.com";
    String password="12345678";
    CSVReader reader;

    @Test(priority =1,alwaysRun=true)
    public void userCanRegisterSuccessfully() throws IOException, CsvValidationException {
        //get path of CSV file
        String path = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData1.CSV";;
        reader = new CSVReader(new FileReader(path));
        String [] csvCell;
        //while loop will be executed till the lastvalue in csv file.
        while ((csvCell = reader.readNext())!=null){
            String firstName = csvCell[0];
            String lastName = csvCell[1];
            String email = csvCell[2];
            String password = csvCell[3];
            homePage = new HomePage(driver);
            homePage.openRegistrationPage();
            userRegistrationPage = new UserRegistrationPage(driver);
            userRegistrationPage.userRegistration(firstName,lastName,email,password);
            Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
            userRegistrationPage.userLogout();
            homePage.openLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.userLogin(email,password);
            Assert.assertTrue(userRegistrationPage.logoutLink.isDisplayed());
        }

    }

}