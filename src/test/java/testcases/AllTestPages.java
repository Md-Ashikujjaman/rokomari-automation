package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetup;

public class AllTestPages extends DriverSetup {

    private static final Logger log = LoggerFactory.getLogger(AllTestPages.class);
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    BookPage bookPage = new BookPage();
    CardPage cardPage = new CardPage();
    ShippingPage shippingPage = new ShippingPage();




    @Test (priority = 1)
    public void TestUserCanLoginWithValidCredentials(){
        homePage.loadPage(homePage.url);
        homePage.closePopupIsPresent(homePage.PopUpClose);
        homePage.clickElement(homePage.SignInButton);
        loginPage.writeOneElement(loginPage.inputUsername, loginPage.username);
        loginPage.clickElement(loginPage.nextLoginButton);
        loginPage.writeOneElement(loginPage.inputPassword, loginPage.password);
        loginPage.waitForScrollElement(loginPage.LoginButton);
        loginPage.clickElement(loginPage.LoginButton);
        homePage.closePopupIsPresent(homePage.rockStarPopupCloseButton);
        Assert.assertTrue(homePage.waitForElementVisible(homePage.user_icon).isDisplayed());
        Assert.assertTrue(homePage.waitForElementVisible(homePage.navigation_dropdownContainer).isDisplayed());
        Assert.assertTrue(homePage.waitForElementVisible(homePage.navigation_pointContainer).isDisplayed());
    }

    @Test (priority = 0)
    public void TestUserCanNotLoginWithInValidCredentials(){
        homePage.loadPage(homePage.url);
        homePage.closePopupIsPresent(homePage.PopUpClose);
        homePage.clickElement(homePage.SignInButton);
        loginPage.writeOneElement(loginPage.inputUsername, loginPage.username);
        loginPage.clickElement(loginPage.nextLoginButton);
        loginPage.writeOneElement(loginPage.inputPassword, "abc12345");
        loginPage.waitForScrollElement(loginPage.LoginButton);
        loginPage.clickElement(loginPage.LoginButton);
        Assert.assertTrue(homePage.waitForElementVisible(loginPage.errorPassword).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorPassword), "Wrong password!");
    }

    @Test (priority = 2)
    public void TestAuthorSelection() throws InterruptedException {
        //homePage.loadPage(homePage.url);
        homePage.clickElement(homePage.menuBook);
        bookPage.hoverElement(bookPage.authorMenu);
        bookPage.actionsClick(bookPage.authorHumayunAhmed);
        bookPage.waitForScrollElement(bookPage.byPublishers);
        bookPage.actionsClick(bookPage.categoriesContemporaryNovel);
        bookPage.waitForScrollElement(bookPage.paginationElement);
        bookPage.clickElement(bookPage.paginationRight);
        bookPage.waitForScrollElement(bookPage.byPublishers);
        bookPage.hoverElement(bookPage.bookForBye);
        bookPage.actionsClick(bookPage.addToCard);
        Assert.assertNotEquals(bookPage.getElementText(bookPage.cardQuantity),"0");
        bookPage.clickElement(bookPage.cardMenu);
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void TestCheckOutProcess(){
        Assert.assertEquals(homePage.getPageTitle(),cardPage.pageTitle);
        cardPage.clickElement(cardPage.checkOut);

    }
    @Test (priority = 4)
    public void TestOrderConfirmProcessWithAddress() throws InterruptedException {

        shippingPage.clickElement(shippingPage.radioButtonPickUpFromHome);
        shippingPage.getElement(shippingPage.inputName).clear();
        shippingPage.inputInTextArea(shippingPage.inputName, "Ashik");
        shippingPage.inputInTextArea(shippingPage.inputPhone, "01800000000");
        shippingPage.inputInTextArea(shippingPage.inputAltPhone, "01800000000");
        shippingPage.dropDownSelect(shippingPage.dropDownInputCountry, "Bangladesh");
        shippingPage.dropDownSelect(shippingPage.dropDownInputCity, "ঢাকা");
        shippingPage.dropDownSelect(shippingPage.dropDownInputArea, "ফার্মগেট");
        shippingPage.inputInTextArea(shippingPage.inputAddress, "43 Indira Road");
        shippingPage.waitForScrollElement(shippingPage.buttonOrderConfirm);
        shippingPage.clickElement(shippingPage.radioButtonCashOnDelivery);
        //shippingPage.clickElement(shippingPage.checkBoxCondition);

        Thread.sleep(7000);
    }

    @Test (priority = 5)
    public void TestLogOut() throws InterruptedException {

        getDriver().navigate().back();
        homePage.hoverElement(homePage.dropDownUserMenu);
        homePage.actionsClick(homePage.userSignOutButton);

        Thread.sleep(7000);
    }

}
