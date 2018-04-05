import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseAppiumTest {

    public static AndroidDriver<AndroidElement> appiumCapabilitiesForApplication() throws MalformedURLException{

        File apkSource = new File("src");
        File apk = new File(apkSource, "Apk Info_v1.1.3_apkpure.com.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(
                new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        return androidDriver;
    }

    public static AndroidDriver<AndroidElement> appiumCapabilitiesForApplicationPreInstalled() throws MalformedURLException{
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(
                new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        return androidDriver;
    }
}
