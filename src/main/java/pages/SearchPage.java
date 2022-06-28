package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id="small-searchterms")
    WebElement searchTextBox;
    @FindBy(css="button.button-1.search-box-button")
    WebElement searchBtn;
    @FindBy(css="#ui-id-1 li")
    List<WebElement> productList;
    @FindBy(css="h2.product-title")
    public WebElement productTitle;

    public void productSearch(String productName){
        clearText(searchTextBox);
        setTextElementText(searchTextBox,productName);
        clickButton(searchBtn);
    }
    public void openProductDetailsPage(){
        clickButton(productTitle);
    }
    public void productSearchUsingAutoSuggest(String productName){
        clearText(searchTextBox);
        setTextElementText(searchTextBox,productName);
        productList.get(0).click();
    }
}