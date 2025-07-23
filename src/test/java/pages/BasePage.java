package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSetup;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;

import static utilities.DriverSetup.getDriver;

public class BasePage extends DriverSetup {

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

    public void loadPage(String url){
        getDriver().get(url);
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public WebElement waitForElementVisible(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForScrollElement(By locator){
        WebElement scrollElement = getDriver().findElement(locator);
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(scrollElement).build().perform();
        return scrollElement;
    }

    public void closePopupIsPresent(By locator){
        try {
            List<WebElement> popupElement = getDriver().findElements(locator);
            if (!popupElement.isEmpty() && popupElement.get(0).isDisplayed()){
                popupElement.get(0).click();
                System.out.println("Popup found and closed.");
            }
            else {
                System.out.println("Popup not visible or not present.");
            }
        } catch (Exception e) {
            System.out.println("Popup not found or already closed.");
        }
    }

    public WebElement hoverElement(By locator){
        Actions actions = new Actions(getDriver());
        WebElement hoverElement = getDriver().findElement(locator);
        actions.moveToElement(hoverElement).build().perform();
        return hoverElement;
    }

    public WebElement actionsClick(By locator){
        Actions actions = new Actions(getDriver());
        WebElement actionsClick = getDriver().findElement(locator);
        actions.click(actionsClick).build().perform();
        return actionsClick;
    }

    public void dropDownSelect(By locator, String selectText){
        WebElement dropDown = getDriver().findElement(locator);
        Select select = new Select(dropDown);
        dropDown.click();
        select.selectByVisibleText(selectText);
    }


    public void inputInTextArea(By locator, String selectText){
        WebElement inputText = getDriver().findElement(locator);
        inputText.sendKeys(selectText);
    }

    public void addScreenShot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

}