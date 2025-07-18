package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public String url = "https://www.rokomari.com";
    public String title = "Rokomari.com - Online Book, Electronics & Super Shop in Bangladesh";
    public By menuBook = By.xpath("(//span[contains(text(),'বই')])[2]");
    public By SignInButton = By.xpath("(//a[contains(text(),'Sign In')])");
    public By user_icon = By.xpath("//img[@alt='user-image']");
    public By PopUpClose = By.xpath("//div[@class='modal_modal__RCZrz']//button");
    public By rockStarPopup = By.xpath("//div[@id=\"ts--desktop-rok-star\"]");
    public By rockStarPopupCloseButton = By.xpath("//button[@class='modal_modalCloseButton__y_s5N']");
    public By navigation_pointContainer = By.xpath("//div[@class='navigation_pointContainer__textContainer__tLSU8']");
    public By navigation_dropdownContainer = By.xpath("//div[@class='navigation_dropdownContainer__mQe5_']");

    public By dropDownUserMenu = By.xpath("//div[@class='dropdown user-menu']");
    public By userSignOutButton = By.xpath("//a[contains(@class, 'js--logout-button')]");


}
