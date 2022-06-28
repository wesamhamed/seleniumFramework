package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase{

    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    String firstName = LoadProperties.userData.getProperty("firstname");
    String lastName = LoadProperties.userData.getProperty("lastname");
    String email = LoadProperties.userData.getProperty("email");
    String password = LoadProperties.userData.getProperty("password");


    @Test(priority =1,alwaysRun=true)
    public void userCanRegisterSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
    }
    @Test(dependsOnMethods={"userCanRegisterSuccessfully"})
    public void registeredUserCanLogout(){
        userRegistrationPage.userLogout();
    }
    @Test(dependsOnMethods={"registeredUserCanLogout"})
    public void registeredUserCanLogin(){
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(email,password);
        Assert.assertTrue(userRegistrationPage.logoutLink.isDisplayed());
    }

}