package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;
    @FindBy(id="OldPassword")
    WebElement oldPasswordTxtBox;
    @FindBy(id="NewPassword")
    WebElement newPasswordTxtBox;
    @FindBy(id="ConfirmNewPassword")
    WebElement confirmPasswordTxtBox;
    @FindBy(css ="button.button-1.change-password-button" )
    WebElement changePasswordBtn;
    @FindBy(css="p.content")
    public WebElement notificationText;
    @FindBy(css="span.close")
    public WebElement notificationClose;

    public void openChangePasswordPage(){
        clickButton(changePasswordLink);
    }
    public void changePassword(String oldPassword, String newPassword){
        setTextElementText(oldPasswordTxtBox,oldPassword);
        setTextElementText(newPasswordTxtBox,newPassword);
        setTextElementText(confirmPasswordTxtBox,newPassword);
        clickButton(changePasswordBtn);
    }
    public void closeNotification(){
        clickButton(notificationClose);
    }
}