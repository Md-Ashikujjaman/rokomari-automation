package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.DriverSetup.getDriver;

public class BasePage {

    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickElement(By locator){
        getElement(locator).click();
    }

    public void writeOneElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public boolean visibleState(By locator){
        return getElement(locator).isDisplayed();
    }
}
