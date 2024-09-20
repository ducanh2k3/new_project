package base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver(DriverFactory.BrowserType.CHROME);
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    protected void checkUrl(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    protected void wait5s() throws InterruptedException {
        Thread.sleep(5000);
    }

}
