package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationWithDDTAndJson extends TestBase{

    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;

    @DataProvider(name="testData")
    public Object[][] userRegistrationData() throws IOException, ParseException {
        JsonDataReader JDR =new JsonDataReader();

        Object[][] userData= JDR.jsonDataReader();
        return userData;
    }


    @Test(priority =1,alwaysRun=true,dataProvider = "testData")
    public void userCanRegisterSuccessfully(String firstName,String lastName,String email,String password){
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