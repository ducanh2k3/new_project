package test;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends TestBase {
    private HomePage homePage;
    @Test
    public void TestClickItem(){
        homePage.clickItemByIndex(1);
    }
}
