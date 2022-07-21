package pageObjects;

import basePage.baseSetup;
import io.appium.java_client.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class profilePage {
    AppiumDriver driver = baseSetup.driver;


    public void clkProMenu() {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Show menu']")).click();
    }

    public String chkMyLevel() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.widget.Button"));
        ele.get(0).click();

        Thread.sleep(10000);
        List<WebElement> ele2 = driver.findElements(AppiumBy.className("android.view.View"));
        String levelTxt = ele2.get(0).getAttribute("content-desc");
        System.out.println("Text is " + levelTxt);
        return levelTxt;
    }

    public void navBackFromMyLvl() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
    }

    public void navEditPro() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.widget.Button"));
        ele.get(1).click();

    }

    public void editStatusPro_1(String statusTxt) throws InterruptedException {
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.widget.EditText"));
        ele.get(3).click();
        ele.get(3).clear();
        ele.get(3).sendKeys(statusTxt);
        Thread.sleep(2000);

        Actions at = new Actions(driver);

        Thread.sleep(5000);
        for (int i = 0; i <= 11; i++) {

            at.sendKeys(Keys.TAB);

        }

        Thread.sleep(2000);
        at.sendKeys(Keys.ENTER);
        at.build().perform();
    }
    public String editStatusPro_2() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> statusElem = driver.findElements(AppiumBy.className("android.view.View"));
        String statusText = statusElem.get(8).getAttribute("content-desc");
        System.out.println(statusText);
        Thread.sleep(5000);
        //Setting below function to a new method so value will be resetted even when test case fails
/*        clkProMenu();
        navEditPro();
        editStatusPro_1("YOLO");
 */
        return statusText;
    }



    public String chkNotifications() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.widget.Button"));
        ele.get(2).click();

        Thread.sleep(5000);
        List<WebElement> ele2 = driver.findElements(AppiumBy.className("android.view.View"));
        String notificationTxt = ele2.get(0).getAttribute("content-desc");
        System.out.println("Text is " + notificationTxt);
        return notificationTxt;

    }


    public void chkPInterest() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.widget.Button"));
        ele.get(3).click();


        //Pick Interest as Animals
        Thread.sleep(5000);
        List<WebElement> ele2 = driver.findElements(AppiumBy.className("android.view.View"));
        WebElement ele3 = ele2.get(4);
        String text = ele2.get(4).getAttribute("content-desc");
        ele3.click();
        Thread.sleep(5000);
        System.out.println(text);

        driver.findElement(AppiumBy.accessibilityId("Select")).click();
    }

    public void chkCountry() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.widget.Button"));
        ele.get(4).click();

        Thread.sleep(5000);

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"profile.online\"]/android.view.View/android.view.View/android.view.View[3]")).click();

        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("Germany")).click();
/*
        //Country Drop Down
        List<WebElement> ele2 = driver.findElements(AppiumBy.className("android.view.View"));
        WebElement ele3 = ele2.get(1);
        ele3.click();

        //Selecting a Country
        List<WebElement> ele4 = driver.findElements(AppiumBy.className("android.widget.SeekBar"));
        WebElement ele5 = ele4.get(5);
        System.out.println(ele5.getAttribute("content-desc"));

 */

    }

    public String chkBlockedUsr() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.widget.Button"));
        ele.get(5).click();

        Thread.sleep(5000);
        List<WebElement> ele2 = driver.findElements(AppiumBy.className("android.view.View"));
        WebElement blockedTxt = ele2.get(2);
        String blockedText = blockedTxt.getAttribute("content-desc");
        return blockedText;
    }

    public String chkLglInfo() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.widget.Button"));
        ele.get(6).click();

        Thread.sleep(5000);
        List<WebElement> ele2 = driver.findElements(AppiumBy.className("android.widget.Button"));
        WebElement blockedTxt = ele2.get(1);
        String blockedText = blockedTxt.getAttribute("content-desc");
        System.out.println(blockedText);
        return blockedText;
    }

    public String chkDarkMode() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.widget.Button"));
        ele.get(7).click();

        Thread.sleep(5000);
        clkProMenu();
        Thread.sleep(5000);


        String darkModeActive = driver.findElement(AppiumBy.accessibilityId("Set Light Mode")).getAttribute("content-desc");

        System.out.println(darkModeActive);

        Thread.sleep(5000);



        driver.findElement(AppiumBy.accessibilityId("Set Light Mode")).click();
        return darkModeActive;
    }
    public void chkLanguage() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.widget.Button"));
        ele.get(4).click();

        Thread.sleep(5000);

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"profile.online\"]/android.view.View/android.view.View/android.view.View[2]")).click();

        Thread.sleep(5000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Hindi\").instance(0))")).click();


        driver.navigate().back();
        driver.findElement(AppiumBy.xpath("//android.view.View[@bounds='[409,588][671,714]']")).click();
    }

}
