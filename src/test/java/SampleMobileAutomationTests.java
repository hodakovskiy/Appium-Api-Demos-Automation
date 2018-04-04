import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class SampleMobileAutomationTests extends BaseAppiumTest {

    private AndroidDriver<AndroidElement> androidDriver;

    @Before
    public void setUp() throws MalformedURLException {
        androidDriver = appiumCapabilities();
    }

    @Test
    public void clickLinkInWebView2() {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String viewsByXpath = "//android.widget.TextView[@text='Views']";
        String webView2ByXpath = "//android.widget.TextView[@text='WebView2']";
        String linkById = "i am a link";
        String textContentByXpath = "//android.view.View[@content-desc='I am some other page content']";

        androidDriver.findElementsByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));"
        );

        AndroidElement viewsButton = androidDriver.findElementByXPath(viewsByXpath);
        viewsButton.click();

        androidDriver.findElementsByAndroidUIAutomator("" +
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView2\"))"
        );

        AndroidElement webView2Button = androidDriver.findElementByXPath(webView2ByXpath);
        webView2Button.click();

        AndroidElement link = androidDriver.findElementById(linkById);
        link.click();

        AndroidElement text = androidDriver.findElementByXPath(textContentByXpath);
        assertNotNull(text);
    }

    @Test
    public void dragAndDrop() {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String viewsByXpath = "//android.widget.TextView[@text='Views']";
        String dragAndDropByXpath = "//android.widget.TextView[@text='Drag and Drop']";

        androidDriver.findElementsByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));"
        );

        AndroidElement viewsButton = androidDriver.findElementByXPath(viewsByXpath);
        viewsButton.click();

        AndroidElement dragAndDropButton = androidDriver.findElementByXPath(dragAndDropByXpath);
        dragAndDropButton.click();
    }

    @After
    public void tearDown(){
        androidDriver.quit();
    }
}
