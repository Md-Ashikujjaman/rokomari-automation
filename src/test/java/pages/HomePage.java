package pages;

import org.openqa.selenium.By;

public class HomePage {

    public String url = "https://www.rokomari.com";
    public By menuBook = By.xpath("(//span[contains(text(),'বই')])[2]");
    public By LoginButton = By.xpath("(//a[contains(text(),'Sign In')])");
}
