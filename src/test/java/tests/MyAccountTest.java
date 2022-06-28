package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

import java.time.Duration;

public class MyAccountTest extends TestBase{
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    MyAccountPage myAccountPage;
    LoginPage loginPage;
    String firstName="wesam";
    String lastName="hamad";
    String email="test@test8.com";
    String oldPassword="1234567";
    String newPassword="12345678";
    @Test(priority=1,alwaysRun=true)
    public void userCanRegisterSuccessfully(){
        homePage= new HomePage(driver);
        homePage.openRegistrationPage();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration(firstName,lastName,email,oldPassword);
        Assert.assertTrue(userRegistrationPage.successMessage.isDisplayed());
        Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
    }
    @Test(dependsOnMethods={"userCanRegisterSuccessfully"})
    public void registeredUserCanChangePassword(){
        myAccountPage = new MyAccountPage(driver);
        userRegistrationPage.openMyAccountPage();
        myAccountPage.openChangePasswordPage();
        myAccountPage.changePassword(oldPassword,newPassword);
        Assert.assertTrue(myAccountPage.notificationText.getText().contains("Password was changed"));
        myAccountPage.closeNotification();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.notificationClose));

    }
    @Test(dependsOnMethods={"registeredUserCanChangePassword"})
    public void registeredUserCanLogout(){
        userRegistrationPage.userLogout();

    }
    @Test(dependsOnMethods={"registeredUserCanLogout"})
    public void registeredUserCanLogin(){
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(email,newPassword);
        Assert.assertTrue(userRegistrationPage.logoutLink.isDisplayed());
    }
}