package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;


public class ChangeCurrencyTest extends TestBase{
    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    SearchPage searchPage;
    String productName="Apple MacBook Pro 13-inch";

    @Test(priority =1)
    public void userCanChangeCurrency(){
        homePage = new HomePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        homePage.changeCurrency();
    }
    @Test(priority=2)
    public void userCanSearchWithAutoSuggest(){
        searchPage= new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        Assert.assertTrue(productDetailsPage.productNameBreadcrumb.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(productDetailsPage.productPriceLbl.getText().contains("€"));
    }
}