package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public By myCartLocator = By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']");
    public  By logOutBtnLocator = By.xpath("//a[@id='logout_sidebar_link']");

    public BasePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        this.driver = driver;
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void setText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    protected List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void checkAddToCart(WebElement Btn, String text) {
        Assert.assertEquals(Btn.getText(), text);
    }

    protected void logOut(){
        By menuLocator = By.xpath("//div[@class='bm-burger-button']");
        WebElement menuBtn = findElement(menuLocator);
        click(menuBtn);
        WebElement logOutBtn = findElement(logOutBtnLocator);
        click(logOutBtn);


    }

}
