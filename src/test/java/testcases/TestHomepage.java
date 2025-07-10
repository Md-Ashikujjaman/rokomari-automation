package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverSetup;

public class TestHomepage extends DriverSetup {

    @Test
    public void TestHomePageTitle(){
        getDriver().get("https://www.rokomari.com/");
        Assert.assertEquals(getDriver().getTitle(),"Rokomari.com - Online Book, Electronics & Super Shop in Bangladesh");
    }
}
