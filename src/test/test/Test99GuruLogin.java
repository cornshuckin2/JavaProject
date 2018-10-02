package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pages.Guru99HomePage;

import pages.Guru99Login;

public class Test99GuruLogin {

    WebDriver driver;

    Guru99Login objLogin;

    Guru99HomePage objHomePage;



    @BeforeTest

    public void setup(){

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://test.faculty180.com/sysadmin/login.php?dbID=DemoUniv");

    }

    /**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test (priority=0)

    public void test_Home_Page_Appear_Correct(){

        //Create Login Page object

        objLogin = new Guru99Login(driver);

        //Verify login page title

        String loginPageTitle = objLogin.getLoginTitle();

        System.out.println(loginPageTitle);

        Assert.assertTrue(loginPageTitle.contains("Faculty180 Login"));

        //login to application

        objLogin.loginToGuru99("vinnyo", "180salesdemo");

        // go the next page

        objHomePage = new Guru99HomePage(driver);

        //Verify home page

        System.out.println(objHomePage.getHomePageDashboardUserName());

        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("Vincent Onorato2112"));

        driver.close();
    }
}