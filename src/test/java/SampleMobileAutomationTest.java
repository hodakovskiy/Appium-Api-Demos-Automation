import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SampleMobileAutomationTest extends BaseAppiumTest {

    private AndroidDriver<AndroidElement> androidDriver;

    @Before
    public void setUp() throws MalformedURLException {
        androidDriver = appiumCapabilities();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void clickLinkInWebView2Test() {

        String viewsByXpath = "//android.widget.TextView[@text='Views']";
        String webView2ByXpath = "//android.widget.TextView[@text='WebView2']";
        String linkById = "i am a link";
        String textContentByXpath = "//android.view.View[@content-desc='I am some other page content']";

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
    public void dragAndDropElementTest() {

        String viewsByXpath = "//android.widget.TextView[@text='Views']";
        String dragAndDropByXpath = "//android.widget.TextView[@text='Drag and Drop']";
        String dragDotDraggableById = "io.appium.android.apis:id/drag_dot_1";
        String dotToDropFirstById = "io.appium.android.apis:id/drag_dot_2";

        AndroidElement viewsButton = androidDriver.findElementByXPath(viewsByXpath);
        viewsButton.click();

        AndroidElement dragAndDropButton = androidDriver.findElementByXPath(dragAndDropByXpath);
        dragAndDropButton.click();

        AndroidElement dragDotDraggable = androidDriver.findElementById(dragDotDraggableById);
        AndroidElement dotToDropFirst = androidDriver.findElementById(dotToDropFirstById);


        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.
                longPress(dragDotDraggable).
                moveTo(dotToDropFirst).
                release().
                perform();
    }

    @Test
    public void dateWidgetsSwipeTest() throws Exception {
        String viewsByXpath = "//android.widget.TextView[@text='Views']";
        String dateWidgetsByXpath = "//android.widget.TextView[@text='Date Widgets']";
        String infiniteByXpath = "//android.widget.TextView[@text='2. Inline']";
        String hourLocatorClassName = "android.widget.RadialTimePickerView$RadialPickerTouchHelper";

        AndroidElement viewsButton = androidDriver.findElementByXPath(viewsByXpath);
        viewsButton.click();

        AndroidElement dateWidgetsButton = androidDriver.findElementByXPath(dateWidgetsByXpath);
        dateWidgetsButton.click();

        AndroidElement inlineButton = androidDriver.findElementByXPath(infiniteByXpath);
        inlineButton.click();

        List<AndroidElement> clockElements = androidDriver.findElementsByClassName(hourLocatorClassName);
        System.out.println(clockElements.size());

        TouchAction touchAction = new TouchAction(androidDriver);

        touchAction.
                tap(clockElements.get(2)).
                release().
                perform();

        for(int i=0; i< clockElements.size(); i++){
            if( i >= 3){
                touchAction.press(clockElements.get(i)).
                        moveTo(clockElements.get(i)).perform();
            }else if (i == 9){
                touchAction.
                        release().
                        perform();
            }
        }

        Thread.sleep(5000);
    }

    @After
    public void tearDown(){

        androidDriver.quit();

    }
}
