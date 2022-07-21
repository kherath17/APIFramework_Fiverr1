import basePage.baseSetup;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pageFunctions.loginFunction;
import pageFunctions.menuFunction;
import pageFunctions.profileFunction;
import pageObjects.menuPage;

import java.net.MalformedURLException;

public class testClass {


    @BeforeClass
    public void driverSetup() throws MalformedURLException {
        baseSetup bs = new baseSetup();
        bs.driverSetup();
    }

    @Epic("Login")
    @Feature("Login Related Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing Login In to the Application")
    @Test(priority = 0)
    public void verifyLogin() throws InterruptedException {
        loginFunction lof = new loginFunction();
        Assert.assertEquals(lof.checkSuccessLogin(), "Martin Stark");
    }

    @Epic("Page Load")
    @Feature("Page Related Feature")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page is Loaded")
    @Test(priority = 1)
    public void verifyProfilePageLoad() throws InterruptedException {
        menuFunction mef = new menuFunction();
        Assert.assertTrue(mef.PageLoad_Profile().contains("UPLOADS"));
    }

    @Epic("Page Load")
    @Feature("Page Related Feature")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Explore Page is Loaded")
    @Test(priority = 2)
    public void verifyExplorePageLoad() throws InterruptedException {
        menuFunction mef = new menuFunction();
        Assert.assertEquals(mef.PageLoad_Explore(), "Search...");

    }

    @Epic("Page Load")
    @Feature("Page Related Feature")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Media Page is Loaded")
    @Test(priority = 3)
    public void verifyMediaPageLoad() throws InterruptedException {
        menuFunction mef = new menuFunction();
        Assert.assertEquals(mef.PageLoad_Media(), "HOT");
    }

    @Epic("Page Load")
    @Feature("Page Related Feature")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Public Page is Loaded")
    @Test(priority = 4)
    public void verifyPublicPageLoad() throws InterruptedException {
        menuFunction mef = new menuFunction();
        Assert.assertTrue(mef.PageLoad_Public().contains("martinstark"));
    }

    @Epic("Page Load")
    @Feature("Page Related Feature")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Private Page is Loaded")
    @Test(priority = 5)
    public void verifyPrivatePageLoad() throws InterruptedException {
        menuFunction mef = new menuFunction();
        Assert.assertTrue(mef.PageLoad_Private().contains("heylol_updates"));
    }


    @Epic("Profile Page Checks")
    @Feature("Profile Page Related Checks")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page My Level Option")
    @Test(priority = 6)
    public void verifyProMyLevel() throws InterruptedException {
        profileFunction pof = new profileFunction();
        Assert.assertTrue(pof.checkMyLevel().contains("Level"));
    }


    @Epic("Profile Page Checks")
    @Feature("Profile Page Related Checks")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page Edit Status Option")
    @Test(priority = 7)
    public void verifyProEditStatus() throws InterruptedException {
        profileFunction pof = new profileFunction();
        Assert.assertTrue(pof.checkProfileEdit().contains("Test"));
        pof.resetStatus();
    }


    @Epic("Profile Page Checks")
    @Feature("Profile Page Related Checks")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page Notification Option")
    @Test(priority = 8)
    public void verifyNotification() throws InterruptedException {
        profileFunction pof = new profileFunction();
        Assert.assertEquals(pof.checkNotifications(), "Notification Settings");
    }

    @Epic("Profile Page Checks")
    @Feature("Profile Page Related Checks")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page Pick Interest Option")
    @Test(priority = 9)
    public void verifyPickInterest() throws InterruptedException {
        profileFunction pof = new profileFunction();
        Assert.assertTrue(pof.checkInterests().contains("ANIMALS"));
        //pof.resetInterest(); //This function is included in Profile Function page inside checkBlockedUsr() to reset the value even when test case fails
    }


    //This test case is ignored due to page not been interactable
    @Epic("Profile Page Checks")
    @Feature("Profile Page Related Checks")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page Country Option")
    @Test(priority = 10)
    @Ignore
    public void verifyCountry() throws InterruptedException {
        profileFunction pof = new profileFunction();
        pof.checkCountry();
    }

    //This test case is ignored due to page not been interactable
    @Epic("Profile Page Checks")
    @Feature("Profile Page Related Checks")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page Language Option")
    @Test(priority = 11)
    @Ignore
    public void verifyLanguage() throws InterruptedException {
        profileFunction pof = new profileFunction();
        pof.checkChangeLanguage();

    }

    @Epic("Profile Page Checks")
    @Feature("Profile Page Related Checks")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page Blocked Users Option")
    @Test(priority = 12)
    public void verifyBlockedUsers() throws InterruptedException {
        profileFunction pof = new profileFunction();
        Assert.assertTrue(pof.checkBlockedUsr().contains("muyiwa"));
    }

    @Epic("Profile Page Checks")
    @Feature("Profile Page Related Checks")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page Legal Info Option")
    @Test(priority = 13)
    public void verifyLegalInfo() throws InterruptedException {
        profileFunction pof = new profileFunction();
        Assert.assertTrue(pof.checkLegalInfo().contains("TERMS OF USE"));
    }

    @Epic("Profile Page Checks")
    @Feature("Profile Page Related Checks")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page Dark Mode Option")
    @Test(priority = 14)
    public void verifyDarkMode() throws InterruptedException {
        profileFunction pof = new profileFunction();
        Assert.assertTrue(pof.darkModeActive().contains("Set Light Mode"));
    }

    @Epic("Profile Page Checks")
    @Feature("Profile Page Related Checks")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing Profile Page LogOut Option")
    @Test(priority = 15)
    public void verifyLogOut() throws InterruptedException {
        loginFunction lof = new loginFunction();
        menuPage mep = new menuPage();
        mep.navProfile();
        Assert.assertTrue(lof.checkLogOut().contains("Welcome to Heylol!"));
    }

    @Epic("Login")
    @Feature("Login Related Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing Login In to the Application with Invalid OTP")
    @Test(priority = 16)
    public void verifyFailedLogin() throws InterruptedException {
        loginFunction lof = new loginFunction();
        Assert.assertTrue(lof.checkFailedLogIn().contains("The sms code you"));
    }
}
