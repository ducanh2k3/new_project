package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginBtnLocator = By.id("login-button");
    By errorTextLocator = By.xpath("//h3[@data-test='error']");
    WebElement usernameField = findElement(usernameLocator);
    WebElement passwordField = findElement(passwordLocator);
    WebElement loginButton = findElement(loginBtnLocator);

    public void Login(String username, String password) {
        setText(usernameField, username);
        setText(passwordField, password);
        click(loginButton);

    }

    public void InvalidLogin(String username, String password) {
        setText(usernameField, username);
        setText(passwordField, password);
        click(loginButton);

        WebElement errorText = findElement(errorTextLocator);
        Assert.assertEquals(errorText.getText(), "Epic sadface: Username and password do not match any user in this service");
    }

}
