package tests;

import com.github.javafaker.Faker;
import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationWithDDTAndJavaFaker extends TestBase{

    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    Faker fakeData = new Faker();
    String firstName=fakeData.name().firstName();
    String lastName=fakeData.name().lastName();
    String email=fakeData.internet().emailAddress();
    String password=fakeData.number().digits(8).toString();

    @Test(priority =1,alwaysRun=true)
    public void userCanRegisterSuccessfully(){
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