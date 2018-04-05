import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class CalculatorAppTest extends BaseAppiumTest {

    private AndroidDriver<AndroidElement> androidDriver;

    @Before
    public void setUp() throws MalformedURLException {
        androidDriver = appiumCapabilitiesForApplicationPreInstalled();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void calculatorTestExample(){
        String calcTwoButtonXpath = "//android.widget.Button[@text='2']";
        String plusSignButtonXpath = "//android.widget.Button[@text='+']";
        String equalSignButtonXpath = "//android.widget.Button[@text='=']";
        String resultXpath = "//android.widget.TextView[@text='4']";

        AndroidElement twoButton = androidDriver.findElementByXPath(calcTwoButtonXpath);
        AndroidElement plusButton = androidDriver.findElementByXPath(plusSignButtonXpath);
        AndroidElement equalButton = androidDriver.findElementByXPath(equalSignButtonXpath);

        twoButton.click();
        plusButton.click();
        twoButton.click();
        equalButton.click();
        AndroidElement result = androidDriver.findElementByXPath(resultXpath);
        assertEquals("4", result.getText());
    }

    @After
    public void tearDown(){
        androidDriver.quit();
    }
}
