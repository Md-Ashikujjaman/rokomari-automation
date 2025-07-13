package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomepage extends DriverSetup {

    HomePage homePage=new HomePage();

    @Test
    public void TestHomePageTitle(){
        homePage.loadPage(homePage.url);
        Assert.assertEquals(homePage.getPageTitle(), homePage.title);
    }
    @Test
    public void testLoginButton(){
        homePage.loadPage(homePage.url);
        Assert.assertEquals(homePage.getElementText(homePage.SignInButton), "Sign In");
        Assert.assertTrue(homePage.getElement(homePage.SignInButton).isEnabled());
    }

}
