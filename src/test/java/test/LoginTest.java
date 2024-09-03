package test;

import base.BasePage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {
    private LoginPage loginPage;
    private BasePage basePage;

    @Test(priority = 0)
    public void TestValidLogin() {
        loginPage = new LoginPage(driver);
        loginPage.Login("standard_user", "secret_sauce");

    }
    @Test(priority = 1)
    public void TestInvalidLogin(){
        loginPage = new LoginPage(driver);
      loginPage.InvalidLogin("standard_user", "secret_sauc");
    }


}
