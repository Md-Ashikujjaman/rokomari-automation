package pages;

import org.openqa.selenium.By;

public class CardPage extends BookPage{

    public String url = "https://www.rokomari.com/cart";
    public String pageTitle = "My Cart | Rokomari.com";
    public By checkOut = By.xpath("//a[@id='js-continue-to-shipping']");



}
