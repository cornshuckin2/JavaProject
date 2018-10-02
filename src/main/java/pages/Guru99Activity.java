package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99Activity {

    WebDriver driver;

    By selectType = By.name("Type");
    By clickContinueBtn = By.xpath("//*[@id=\"ActivityInput\"]/div[2]/button[1]");
    By activityPageTitle = By.xpath("//h1[text()='Activity Input']");

    public Guru99Activity(WebDriver driver) {
        this.driver = driver;
    }

    public void selectType(String strSelectType) {
        Select dropdown = new Select(driver.findElement(selectType));
        dropdown.selectByVisibleText(strSelectType);
    }

    public void clickContinue() {
        driver.findElement(clickContinueBtn).click();
    }

    public String activityPageTitle() {
        return driver.findElement(activityPageTitle).getText();
    }
}
