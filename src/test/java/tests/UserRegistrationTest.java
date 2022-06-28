package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public  class UserRegistrationTest extends TestBase{

    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    String firstName="wesam";
    String lastName="hamad";
    String email="test@test10.com";
    String password="12345678";

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