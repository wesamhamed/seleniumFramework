package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

import java.time.Duration;


public class AddProductToCompareTest extends TestBase{
    String firstProductName = "Apple MacBook Pro 13-inch";
    String secondProductName = "Asus N551JK-XO076H Laptop";
    // 1- Search for product name 1
    // 2- Search for product name 2
    // 3- Add to compare
    // 4- Clear list
    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    ComparePage comparePage;
    SearchPage searchPage;
    @Test(priority=1)
    public void userCanCompareProducts(){
        searchPage=new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        comparePage =new ComparePage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        Assert.assertTrue(productDetailsPage.productNameBreadcrumb.getText().contains(firstProductName));
        productDetailsPage.addProductToCompare();
        searchPage.productSearchUsingAutoSuggest("Asus");
        Assert.assertTrue(productDetailsPage.productNameBreadcrumb.getText().contains(secondProductName));
        productDetailsPage.addProductToCompare();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
        driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
        Assert.assertTrue(comparePage.firstProductName.getText().equals(secondProductName));
        Assert.assertTrue(comparePage.secondProductName.getText().equals(firstProductName));
        comparePage.compareProducts();
    }
    @Test(priority = 2)
    public void userCanClearCompareList(){
        comparePage.clearCompareList();
        Assert.assertTrue(comparePage.noDataLbl.getText().contains("You have no items to compare."));
    }

}