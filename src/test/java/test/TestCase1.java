package test;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemPage;
import pages.LoginPage;

public class TestCase1 extends TestBase {
    private LoginPage loginPage;
    private HomePage homePage;
    private ItemPage itemPage;



    @Test
public void TC1(){
        loginPage= new LoginPage(driver);
        loginPage.Login("standard_user", "secret_sauce");
        checkUrl("https://www.saucedemo.com/v1/inventory.html");
        homePage =new HomePage(driver);
        homePage.addItemToCartByIndex(2);
        homePage.clickItemByIndex(0);
        itemPage = new ItemPage(driver);
        itemPage.addToCart();
        itemPage.backToHome();
        checkUrl("https://www.saucedemo.com/v1/inventory.html");
        homePage.navigateToMyCart();
        checkUrl("https://www.saucedemo.com/v1/cart.html");
        homePage.LogOut();
        checkUrl("https://www.saucedemo.com/v1/index.html");


    }
    @Test
    public void TC2(){
        loginPage= new LoginPage(driver);
        loginPage.Login("standard_user", "secret_sauce");
        homePage =new HomePage(driver);
        homePage.clickItemByIndex(2);
        itemPage = new ItemPage(driver);
        itemPage.addToCart();
       itemPage.navigateToCart();
    }
}
