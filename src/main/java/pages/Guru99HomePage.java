package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class Guru99HomePage {

    WebDriver driver;

    By homePageUserName = By.xpath("//*[@id=\"fis-header\"]/div/div[4]/fis-header-account-switcher[1]/span/span/button/span/div/div[2]/span");

    public Guru99HomePage(WebDriver driver){

        this.driver = driver;

    }



    //Get the User name from Home Page

    public String getHomePageDashboardUserName(){

        return driver.findElement(homePageUserName).getText();

    }

}