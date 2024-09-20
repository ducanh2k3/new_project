package test;

import base.TestBase;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ItemPage;
import pages.LoginPage;

public class TestCase1 extends TestBase {
    private LoginPage loginPage;
    private HomePage homePage;
    private ItemPage itemPage;
    private CartPage cartPage;


    @Test
    public void TC1() throws InterruptedException {

        loginPage = new LoginPage(driver);
        loginPage.Login("standard_user", "secret_sauce");
        checkUrl("https://www.saucedemo.com/v1/inventory.html");
        homePage = new HomePage(driver);
        homePage.addItemToCartByIndex(2);
        homePage.addItemToCartByIndex(3);
        homePage.clickItemByIndex(0);
        itemPage = new ItemPage(driver);
        itemPage.addToCart();
        itemPage.backToHome();
        checkUrl("https://www.saucedemo.com/v1/inventory.html");
        homePage.navigateToMyCart();
        checkUrl("https://www.saucedemo.com/v1/cart.html");
        cartPage = new CartPage(driver);
        cartPage.removeItemByIndex(3);
        wait5s();
        cartPage.navigateToCheckOut();
        checkUrl("https://www.saucedemo.com/v1/checkout-step-one.html");
        wait5s();
        homePage.LogOut();
        checkUrl("https://www.saucedemo.com/v1/index.html");

    }

    @Test
    public void TC2() {
        loginPage = new LoginPage(driver);
        loginPage.Login("standard_user", "secret_sauce");
        homePage = new HomePage(driver);
        homePage.clickItemByIndex(2);
        itemPage = new ItemPage(driver);
        itemPage.addToCart();
        itemPage.navigateToCart();
    }
}
