package tests;

import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationWithDDTAndExcel extends TestBase{

    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;


    @DataProvider(name="ExcelData")
    public Object[][] userRegistrationData() throws IOException {
        //get data from excel reader class
        ExcelReader ER = new ExcelReader();
        return ER.getExcelData();
    }

    @Test(priority =1,alwaysRun=true,dataProvider = "ExcelData")
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