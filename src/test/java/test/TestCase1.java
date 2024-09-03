package test;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TestCase1 extends TestBase {
    private LoginPage loginPage;
    private HomePage homePage;



    @Test
public void TC1(){
        loginPage= new LoginPage(driver);
        loginPage.Login("standard_user", "secret_sauce");
        homePage =new HomePage(driver);
        homePage.clickItemByIndex(0);
    }
}
