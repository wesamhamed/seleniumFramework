package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{
    public  ProductReviewPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id="AddProductReview_Title")
    WebElement reviewTitleTxtBox;
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewText;
    @FindBy(id="addproductrating_4")
    WebElement ratingRadioBtn;
    @FindBy(name="add-review")
    WebElement submitReviewBtn;
    @FindBy(css="div.result")
    public WebElement reviewNotification;

    public void addProductReview(String reviewTitle,String reviewMessage){
        clearText(reviewTitleTxtBox);
        setTextElementText(reviewTitleTxtBox,reviewTitle);
        clearText(reviewText);
        setTextElementText(reviewText,reviewMessage);
        clickButton(ratingRadioBtn);
        clickButton(submitReviewBtn);
    }
}