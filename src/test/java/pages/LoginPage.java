package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public String url = "https://www.rokomari.com/login";

    public String username = "satana5515@fenexy.com";
    public String password = "dhaka2025";
    public String email = "satana5515@fenexy.com";

    public By inputUsername = By.xpath("//input[@name='username']");
    public By inputPassword = By.xpath("//input[@name='j_password']");
    public By inputRememberme =By.xpath("//input[@id='rememberme']");
    public By LoginButton = By.xpath("//form[@id='login-form']//button[@type='submit'][normalize-space()='Login']");
    public By errorPassword = By.xpath("//div[@id='js--message']//p");
    public By user_icon = By.xpath("//img[@alt='user-image']");
    public By nextLoginButton = By.xpath("//button[@id='js--btn-next']");
}
