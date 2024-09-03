package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public enum BrowserType {
        CHROME, FIREFOX, EDGE
    }

    public static WebDriver getDriver(BrowserType browserType) {
        WebDriver driver;
        switch (browserType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                driver=new ChromeDriver();

        }
        driver.manage().window().maximize();
        return driver;
    }


}
