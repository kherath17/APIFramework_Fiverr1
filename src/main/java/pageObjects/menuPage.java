package pageObjects;

import basePage.baseSetup;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class menuPage extends profilePage {
    AppiumDriver driver = baseSetup.driver;

    public void navProfile() {
        driver.findElement(By.xpath("//android.view.View[@content-desc='Profile']")).click();
    }

    public String chkProfileLoad() {
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.view.View"));
        WebElement profileUploadTxt = ele.get(9);
        String profileText = profileUploadTxt.getAttribute("content-desc");
        return profileText;
    }

    public void navExplore() throws InterruptedException {
        driver.findElement(By.xpath("//android.view.View[@content-desc='Explore']")).click();
    }

    public String chkExploreLoad() throws InterruptedException {
        Thread.sleep(5000);
        String exploreText = driver.findElement(AppiumBy.className("android.widget.EditText")).getAttribute("text");
        return exploreText;
    }

    public void navVideo() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.View[@content-desc='profile.online']/android.view.View/android.view.View/android.widget.ImageView")).click();
    }

    public String chkMediaLoad() throws InterruptedException {
        Thread.sleep(7000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.view.View"));
        WebElement MediaTxt = ele.get(1);
        String mediaText = MediaTxt.getAttribute("content-desc");
        return mediaText;
    }

    public void navPublic() throws InterruptedException {

        Thread.sleep(5000);
        /*
        List<WebElement> ele= driver.findElements(AppiumBy.className("android.view.View"));
        WebElement publicTxt = ele.get(25);
        publicTxt.click();
         */
        driver.findElement(By.xpath("//android.view.View[@bounds='[645,1660][856,1781]']")).click();
    }

    public String chkPublicLoad() throws InterruptedException {
        Thread.sleep(7000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.view.View"));
        WebElement publicTxt = ele.get(2);
        String publicText = publicTxt.getAttribute("content-desc");
        return publicText;
    }

    public void navPrivate() throws InterruptedException {
        Thread.sleep(5000);
        //driver.findElement(AppiumBy.className("9 Private")).click();
        driver.findElement(By.xpath("//android.view.View[@bounds='[856,1660][1067,1781]']")).click();
    }

    public String chkPrivateLoad() throws InterruptedException {
        Thread.sleep(7000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.view.View"));
        WebElement profileUploadTxt = ele.get(7);
        String profileText = profileUploadTxt.getAttribute("content-desc");
        return profileText;
    }

    public String getAddedInterestTxt() throws InterruptedException {
        Thread.sleep(7000);
        List<WebElement> ele = driver.findElements(AppiumBy.className("android.view.View"));
        Thread.sleep(15000);
        WebElement MediaTxt;
        String mediaText;


        try {
            MediaTxt = ele.get(14);
            Thread.sleep(15000);
            mediaText = MediaTxt.getAttribute("content-desc");

            if (MediaTxt.getAttribute("content-desc").contains("ANIMALS")) {

            } else {
                Thread.sleep(5000);
                MediaTxt = ele.get(15);
                mediaText = MediaTxt.getAttribute("content-desc");

            }


            System.out.println("Actual Text is " + mediaText);
            return mediaText;


        } catch (Exception e) {
            e.getCause();
            MediaTxt = ele.get(5);
            mediaText = MediaTxt.getAttribute("content-desc");
            System.out.println("Actual Text is " + mediaText);
            return mediaText;
        }

/*
        String mediaText = MediaTxt.getAttribute("content-desc");
        System.out.println("Actual Text is " + mediaText);
        return mediaText;

 */
    }


}
