package pages;

import org.openqa.selenium.By;

public class ShippingPage extends CardPage{

    public String url = "https://www.rokomari.com/shipping";

    public By inputName = By.xpath("//input[@id='name']");
    public By inputPhone = By.xpath("//input[@id='phone']");
    public By inputAltPhone = By.xpath("//input[@id='phone2']");
    public By dropDownInputCountry = By.xpath("//select[@id='js--country']");
    public By dropDownInputCity = By.xpath("//select[@id='js--city']");
    public By dropDownInputArea = By.xpath("//select[@id='js--area']");
    public By inputAddress = By.xpath("//textarea[@id='address']");
    public By radioButtonCashOnDelivery = By.xpath("//label[@for='COD']");
    public By checkBoxCondition = By.xpath("////label[@for='js--terms-checkbox']");
    public By inputPromoCode = By.xpath("//input[@id='js--coupon-field']");
    public By buttonOrderConfirm = By.xpath("//button[@id='js--confirm-order']");
    public By radioButtonPickUpFromHome = By.xpath("//label[@for='home']");
    public By radioButtonPickUpFromOffice = By.xpath("//label[@for='office']");

}
