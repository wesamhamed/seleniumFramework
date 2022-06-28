package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends TestBase{
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    String productName="Apple MacBook Pro 13-inch";
    EmailPage emailPage;
    String firstName="wesam";
    String lastName="hamad";
    String email="test@test4.com";
    String password="12345678";

    // 1- User registration
    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
        Assert.assertTrue(userRegistrationPage.successMessage.isDisplayed());
    }
    // 2- Search For Product
    @Test(priority = 2)
    public void userCanSearchWithAutoSuggest(){
        searchPage = new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.productNameBreadcrumb.getText().equalsIgnoreCase(productName));
    }
    // 3- Email To Friend
    @Test(priority = 3)
    public void registeredUserCanSendProductToFriend(){
        productDetailsPage.openSendEmail();
        emailPage = new EmailPage(driver);
        emailPage.sendEmailToFriend("aa@gmail.com","Hello my friend , check this product");
        Assert.assertTrue(emailPage.messageNotification.getText().contains("Your message has been sent."));
    }
    // 4- User Logout
    @Test(priority = 4)
    public void RegisteredUserCanLogout(){
        userRegistrationPage.userLogout();
    }
}