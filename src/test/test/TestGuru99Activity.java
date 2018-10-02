package test;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.*;
import pages.Guru99Activity;
import pages.Guru99HomePage;
import pages.Guru99Login;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

public class TestGuru99Activity {

    WebDriver driver;
    Guru99Activity objGuruActivity;
    Guru99Login objLogin;
    Guru99HomePage objHomePage;


    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://test.faculty180.com/sysadmin/login.php?dbID=DemoUniv");
    }

    @Test
    public void test_GuruActivity() {
        // create login page object
        objLogin = new Guru99Login(driver);

        // enter credentials, click login
        objLogin.loginToGuru99("vinnyo", "180salesdemo");

        // create homepage object
        objHomePage = new Guru99HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("Vincent Onorato2112"));

        // create activity input page object
        objGuruActivity = new Guru99Activity(driver);
        driver.get("https://faculty180-test.interfolio.com/workload/ActivityInput.php?Form=ScholarlyActivity&Page=Scholarly+Contributions+%26amp%3B+Creative+Productions");
        Assert.assertTrue(objGuruActivity.activityPageTitle().contains("Activity Input"));
        objGuruActivity.selectType("Case Study");
        objGuruActivity.clickContinue();
        driver.close();
    }
}