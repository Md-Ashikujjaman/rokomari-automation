package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {

    private static final Logger log = LoggerFactory.getLogger(TestLoginPage.class);
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();




    @Test
    public void TestUserCanLoginWithValidCredentials(){
        homePage.loadPage(homePage.url);
        homePage.waitForElementVisible(homePage.PopUpClose);
        homePage.clickElement(homePage.PopUpClose);
        homePage.clickElement(homePage.LoginButton);
        loginPage.writeOneElement(loginPage.inputUsername, loginPage.username);
        loginPage.clickElement(loginPage.nextLoginButton);
        loginPage.writeOneElement(loginPage.inputPassword, loginPage.password);
        loginPage.clickElement(loginPage.LoginButton);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.waitForElementVisible(homePage.rockSterPopup).isDisplayed());
        homePage.clickElement(homePage.rockSterPopupCloseButton);
        Assert.assertTrue(homePage.waitForElementVisible(homePage.user_icon).isDisplayed());
        Assert.assertTrue(homePage.waitForElementVisible(homePage.navigation_dropdownContainer).isDisplayed());
        Assert.assertTrue(homePage.waitForElementVisible(homePage.navigation_pointContainer).isDisplayed());
    }

    @Test
    public void TestUserCanNotLoginWithInValidCredentials(){
        homePage.loadPage(homePage.url);
        homePage.waitForElementVisible(homePage.PopUpClose);
        homePage.clickElement(homePage.PopUpClose);
        homePage.clickElement(homePage.LoginButton);
        loginPage.writeOneElement(loginPage.inputUsername, loginPage.username);
        loginPage.clickElement(loginPage.nextLoginButton);
        loginPage.writeOneElement(loginPage.inputPassword, "abc12345");
        loginPage.clickElement(loginPage.LoginButton);
        Assert.assertTrue(homePage.waitForElementVisible(loginPage.errorPassword).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorPassword), "Wrong password!");
    }

}
