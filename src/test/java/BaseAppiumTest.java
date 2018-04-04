import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseAppiumTest {

    public static AndroidDriver<AndroidElement> appiumCapabilities() throws MalformedURLException{

        File apkSource = new File("src");
        File apk = new File(apkSource, "Appium Api Demos_v0.4_apkpure.com.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_27");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(
                new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        return androidDriver;
    }
}
