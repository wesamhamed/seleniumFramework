package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparePage extends PageBase{
    public ComparePage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "a.clear-list")
    WebElement clearListBtn;
    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
    public WebElement firstProductName;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement secondProductName;
    @FindBy(css = "div.no-data")
    public WebElement noDataLbl;
    @FindBy(css="table.compare-products-table")
    WebElement compareTable;
    @FindBy(tagName = "tr")
    List<WebElement> allRows;
    @FindBy(tagName = "td")
    List<WebElement> allCells;
    public void clearCompareList(){
        clickButton(clearListBtn);
    }
    public void compareProducts(){
        System.out.println(allRows.size());
        for(WebElement row : allRows){
            System.out.println(row.getText()+"\t");
            for(WebElement col : allCells){
                System.out.println(col.getText()+"\t");
            }
        }
    }

}