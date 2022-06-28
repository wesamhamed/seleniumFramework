package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;

    @Given("^the user in the home page$")
    public void the_user_in_the_home_page(){
        homePage=new HomePage(driver);
        homePage.openRegistrationPage();
    }
    @When("^I click on register link$")
    public void i_click_on_register_link(){
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }
   @And("I entered {string},{string},{string},{string}")
    public void i_entered(String firstname, String lastname, String email, String password){
        userRegistrationPage =new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration(firstname,lastname,email,password);
        Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
    }
    @Then("^The registration page displayed successfully$")
    public void the_registration_page_displayed_successfully(){
    userRegistrationPage.userLogout();
    }
}
