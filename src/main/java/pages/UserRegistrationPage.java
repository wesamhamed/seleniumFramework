package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserRegistrationPage extends PageBase{

    public  UserRegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderRadioBtn;

    @FindBy(id = "FirstName")
    WebElement firstNameTxtBox;

    @FindBy(id = "LastName")
    WebElement lastNameTxtBox;

    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxtBox;

    @FindBy(id = "register-button")
    WebElement registrationBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    @FindBy(linkText="Log out")
    public WebElement logoutLink;

    @FindBy(linkText="My account")
    public WebElement myAccountLink;

    public void userRegistration(String firstName, String lastName, String email, String password){
        clickButton(genderRadioBtn);
        clearText(firstNameTxtBox);
        setTextElementText(firstNameTxtBox,firstName);
        clearText(lastNameTxtBox);
        setTextElementText(lastNameTxtBox,lastName);
        clearText(emailTxtBox);
        setTextElementText(emailTxtBox,email);
        clearText(passwordTxtBox);
        setTextElementText(passwordTxtBox,password);
        clearText(confirmPasswordTxtBox);
        setTextElementText(confirmPasswordTxtBox,password);
        clickButton(registrationBtn);
    }
    public void userLogout(){
        clickButton(logoutLink);
    }

    public void openMyAccountPage(){
        clickButton(myAccountLink);
    }
}
