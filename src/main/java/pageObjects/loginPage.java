package pageObjects;

import basePage.baseSetup;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class loginPage extends menuPage{
    AppiumDriver driver = baseSetup.driver;


    public void checkRunDevice(){
        String device = driver.getCapabilities().getCapability("deviceName").toString();
        switch (device){
            case "emulator-5554":
                System.out.println("Tests are Starting on an Emulator!");
                break;
            default:
                System.out.println("Tests are Starting on a Real Device !");
        }
    }


    //Click SignUp
    public void clickSignUp(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //driver.findElement(By.xpath("//android.view.View[@content-desc='Profile']")).click();

        navProfile();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Show menu']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Sign Up']")).click();
    }

    //Enter Country Code and Phone Number
    public void enterContactInfo() throws InterruptedException {
        List<WebElement> ele= driver.findElements(AppiumBy.className("android.widget.EditText"));
        WebElement countryCode = ele.get(0);
        WebElement phoneNum = ele.get(1);

        Thread.sleep(1000);
        countryCode.click();
        Thread.sleep(1000);
        countryCode.clear();
        Thread.sleep(1000);
        countryCode.sendKeys("+49");

        phoneNum.click();
        phoneNum.sendKeys("9193443424");
        driver.findElement(AppiumBy.className("android.widget.ImageView")).click();
    }

    //Close Popup browser for I am not a Robot
    public void closeImNotRobot() {

        try{
            Thread.sleep(10000);
            driver.findElement(AppiumBy.className("android.widget.ImageButton")).click(); //Cache tend to store in this step retry if failed by deleting cache
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }

       // Thread.sleep(5000);
    }

    //Enter OTP by Action class
    public void enterOtp(String OTP) throws InterruptedException {

        Thread.sleep(10000);
        Actions at2 = new Actions(driver);
        at2.sendKeys(Keys.TAB);
        at2.sendKeys(Keys.TAB);
        at2.sendKeys(Keys.TAB);
        at2.sendKeys(OTP);
        at2.build().perform();
        driver.findElement(AppiumBy.className("android.widget.ImageView")).click();
    }

    //Verify if Logged in to User
    public String chkLoggedIn() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.View[@content-desc='Profile']")).click();
        Thread.sleep(7000);
        String userName = driver.findElement(AppiumBy.className("android.view.View")).getAttribute("content-desc");
        return userName;
    }

    //Logout From User
    public String chkLogOut() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Show menu']")).click();
        driver.findElement(AppiumBy.accessibilityId("Sign Out")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        List<WebElement> ele = driver.findElements(AppiumBy.className("android.view.View"));
        String logOutText = ele.get(3).getAttribute("content-desc");
        return logOutText;
    }

    //Verify Logging In Failed
    public String chkFailedLogIn() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(7000);
        List<WebElement> ele2 = driver.findElements(AppiumBy.className("android.view.View"));
        WebElement errorMsgEle = ele2.get(4);
        String errorMsg = errorMsgEle.getAttribute("content-desc");
        return errorMsg;
    }




}
