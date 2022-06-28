package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{
    public EmailPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id="FriendEmail")
    WebElement emailFriendTxtBox;
    @FindBy(id="PersonalMessage")
    WebElement personalMessageTxtBox;
    @FindBy(name="send-email")
    WebElement sendEmailBtn;
    @FindBy(css="div.result")
    public WebElement messageNotification;
    public void sendEmailToFriend(String friendEmail,String personalMessage){
        setTextElementText(emailFriendTxtBox,friendEmail);
        setTextElementText(personalMessageTxtBox,personalMessage);
        clickButton(sendEmailBtn);
    }
}
