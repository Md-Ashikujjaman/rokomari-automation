package testcases;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
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




    @Test (priority = 2)
    @Description("Testing with valid credential")
    public void TestUserCanLoginWithValidCredentials(){
        homePage.loadPage(homePage.url);
        homePage.closePopupIsPresent(homePage.PopUpClose);
        homePage.clickElement(homePage.SignInButton);
        loginPage.addScreenShot("Input Username_Password");
        loginPage.writeOneElement(loginPage.inputUsername, loginPage.username);
        loginPage.clickElement(loginPage.nextLoginButton);
        loginPage.writeOneElement(loginPage.inputPassword, loginPage.password);
        loginPage.waitForScrollElement(loginPage.LoginButton);
        loginPage.addScreenShot("Correct Username_Password");
        loginPage.clickElement(loginPage.LoginButton);
        homePage.closePopupIsPresent(homePage.rockStarPopupCloseButton);
        Assert.assertTrue(homePage.waitForElementVisible(homePage.user_icon).isDisplayed());
        Assert.assertTrue(homePage.waitForElementVisible(homePage.navigation_dropdownContainer).isDisplayed());
        Assert.assertTrue(homePage.waitForElementVisible(homePage.navigation_pointContainer).isDisplayed());
        homePage.addScreenShot("HomePage After login");
    }

    @Test (priority = 1)
    @Description("Testing with invalid password")
    public void TestUserCanNotLoginWithInValidPassword(){
        homePage.loadPage(homePage.url);
        homePage.closePopupIsPresent(homePage.PopUpClose);
        homePage.clickElement(homePage.SignInButton);
        loginPage.addScreenShot("Input Username_Password");
        loginPage.writeOneElement(loginPage.inputUsername, loginPage.username);
        loginPage.clickElement(loginPage.nextLoginButton);
        loginPage.writeOneElement(loginPage.inputPassword, "abc12345");
        loginPage.addScreenShot("Input Wrong Password");
        loginPage.waitForScrollElement(loginPage.LoginButton);
        loginPage.clickElement(loginPage.LoginButton);
        Assert.assertTrue(homePage.waitForElementVisible(loginPage.errorMessage).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMessage), "Wrong password!");
        loginPage.addScreenShot("Wrong Password");
    }

    @Test (priority = 0)
    @Description("Testing with invalid username")
    public void TestUserCanNotLoginWithInValidUsernameOrOtp(){
        homePage.loadPage(homePage.url);
        homePage.closePopupIsPresent(homePage.PopUpClose);
        homePage.clickElement(homePage.SignInButton);
        loginPage.addScreenShot("Login Page");
        loginPage.writeOneElement(loginPage.inputUsername, "ashik@example.com");
        loginPage.clickElement(loginPage.nextLoginButton);
        loginPage.visibleState(loginPage.inputOtp);
        loginPage.visibleState(loginPage.resendOtp);
        loginPage.writeOneElement(loginPage.inputOtp, "249853");
        loginPage.addScreenShot("Input Username_Password");
        loginPage.waitForScrollElement(loginPage.otpLoginButton);
        loginPage.clickElement(loginPage.otpLoginButton);
        Assert.assertTrue(homePage.waitForElementVisible(loginPage.errorMessage).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMessage), "Invalid OTP!");
        loginPage.addScreenShot("Invalid OTP");
    }

    @Test (priority = 3)
    @Description("Testing book author selection from book hover menu")
    public void TestAuthorSelection() throws InterruptedException {
        //homePage.loadPage(homePage.url);
        homePage.clickElement(homePage.menuBook);
        Assert.assertTrue(bookPage.waitForElementVisible(bookPage.authorMenu).isDisplayed());
        bookPage.addScreenShot("HomePage Menu");
        bookPage.hoverElement(bookPage.authorMenu);
        bookPage.addScreenShot("Show Authors");
        bookPage.actionsClick(bookPage.authorHumayunAhmed);
        bookPage.waitForScrollElement(bookPage.byPublishers);
        Assert.assertTrue(bookPage.waitForElementVisible(bookPage.byPublishers).isDisplayed());
        bookPage.addScreenShot("Show Publishers");
        bookPage.actionsClick(bookPage.categoriesContemporaryNovel);
        bookPage.addScreenShot("Select Novel");
        bookPage.waitForScrollElement(bookPage.paginationElement);
        Assert.assertTrue(bookPage.waitForElementVisible(bookPage.paginationElement).isDisplayed());
        bookPage.addScreenShot("Show Pagination element");
        bookPage.clickElement(bookPage.paginationRight);
        bookPage.waitForScrollElement(bookPage.byPublishers);
        bookPage.hoverElement(bookPage.bookForBye);
        bookPage.addScreenShot("Hover book");
        bookPage.actionsClick(bookPage.addToCard);
        bookPage.addScreenShot("Book addToCard");
        Assert.assertNotEquals(bookPage.getElementText(bookPage.cardQuantity),"0");
        bookPage.clickElement(bookPage.cardMenu);
        Thread.sleep(2000);
    }

    @Test (priority = 4)
    @Description("Testing check out process")
    public void TestCheckOutProcess(){
        Assert.assertEquals(homePage.getPageTitle(),cardPage.pageTitle);
        cardPage.addScreenShot("Card page");
        cardPage.clickElement(cardPage.checkOut);

    }
    @Test (priority = 5)
    @Description("Testing order confirm process with fillup shipping address")
    public void TestOrderConfirmProcessWithAddress() throws InterruptedException {

        shippingPage.clickElement(shippingPage.radioButtonPickUpFromHome);
        shippingPage.getElement(shippingPage.inputName).clear();
        shippingPage.addScreenShot("Shipping page before input");
        shippingPage.inputInTextArea(shippingPage.inputName, "Ashik");
        shippingPage.inputInTextArea(shippingPage.inputPhone, "01800000000");
        shippingPage.inputInTextArea(shippingPage.inputAltPhone, "01800000000");
        shippingPage.dropDownSelect(shippingPage.dropDownInputCountry, "Bangladesh");
        shippingPage.dropDownSelect(shippingPage.dropDownInputCity, "ঢাকা");
        shippingPage.dropDownSelect(shippingPage.dropDownInputArea, "ফার্মগেট");
        shippingPage.inputInTextArea(shippingPage.inputAddress, "43 Indira Road");
        shippingPage.addScreenShot("Shipping page after input");
        shippingPage.waitForScrollElement(shippingPage.buttonOrderConfirm);
        shippingPage.clickElement(shippingPage.radioButtonCashOnDelivery);
        shippingPage.addScreenShot("select cash on delivery");
        //shippingPage.clickElement(shippingPage.checkBoxCondition);

        Thread.sleep(2000);
    }

    @Test (priority = 6)
    @Description("Testing sign out process")
    public void TestLogOut() throws InterruptedException {

        getDriver().navigate().back();
        homePage.hoverElement(homePage.dropDownUserMenu);
        homePage.addScreenShot("Shoe sign out option");
        homePage.actionsClick(homePage.userSignOutButton);
        homePage.addScreenShot("After sigh out");

        Thread.sleep(2000);
    }

}
