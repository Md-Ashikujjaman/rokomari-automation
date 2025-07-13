package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.BookPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {

    private static final Logger log = LoggerFactory.getLogger(TestLoginPage.class);
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    BookPage bookPage = new BookPage();




    @Test (priority = 1)
    public void TestUserCanLoginWithValidCredentials(){
        homePage.loadPage(homePage.url);
        homePage.closePopupIsPresent(homePage.PopUpClose);
        homePage.clickElement(homePage.SigninButton);
        loginPage.writeOneElement(loginPage.inputUsername, loginPage.username);
        loginPage.clickElement(loginPage.nextLoginButton);
        loginPage.writeOneElement(loginPage.inputPassword, loginPage.password);
        loginPage.waitForScrollElement(loginPage.LoginButton);
        loginPage.clickElement(loginPage.LoginButton);
        homePage.closePopupIsPresent(homePage.rockSterPopupCloseButton);
        Assert.assertTrue(homePage.waitForElementVisible(homePage.user_icon).isDisplayed());
        Assert.assertTrue(homePage.waitForElementVisible(homePage.navigation_dropdownContainer).isDisplayed());
        Assert.assertTrue(homePage.waitForElementVisible(homePage.navigation_pointContainer).isDisplayed());
    }

    @Test (priority = 0)
    public void TestUserCanNotLoginWithInValidCredentials(){
        homePage.loadPage(homePage.url);
        homePage.closePopupIsPresent(homePage.PopUpClose);
        homePage.clickElement(homePage.SigninButton);
        loginPage.writeOneElement(loginPage.inputUsername, loginPage.username);
        loginPage.clickElement(loginPage.nextLoginButton);
        loginPage.writeOneElement(loginPage.inputPassword, "abc12345");
        loginPage.waitForScrollElement(loginPage.LoginButton);
        loginPage.clickElement(loginPage.LoginButton);
        Assert.assertTrue(homePage.waitForElementVisible(loginPage.errorPassword).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorPassword), "Wrong password!");
    }

    @Test (priority = 2)
    public void TestAuthorSelection(){
        homePage.loadPage(homePage.url);
        homePage.clickElement(homePage.menuBook);
        bookPage.hoverElement(bookPage.authorMenu);
        bookPage.actionsClick(bookPage.authorHumayunAhmed);
        bookPage.waitForScrollElement(bookPage.byPublishers);
        bookPage.actionsClick(bookPage.categoriesContemporaryNovel);


    }

}
