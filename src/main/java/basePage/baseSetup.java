package basePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class baseSetup {
    public static AppiumDriver driver;
    public AppiumDriver driverSetup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","emulator-5554");
        cap.setCapability("platformName","Android");
       // cap.setCapability("app","C:\\Users\\E-LINE\\Downloads\\Heylol.apk");

        cap.setCapability("appPackage","com.heylol");
        cap.setCapability("appActivity","MainActivity");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("appWaitActivity","MainActivity");


        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AppiumDriver(url,cap);
        return driver;
    }
}
