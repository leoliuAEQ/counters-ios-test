import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import static org.testng.Assert.assertTrue;

/**
 * Created by user on 2017-06-28.
 */
public class CountersTest {
    protected AppiumDriver<IOSElement> driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        String countersLocation = "/Users/leoliu/Projects/Builds/Counters.app";
        String appiumServer = "http://localhost:4723/wd/hub";

        DesiredCapabilities desiredCaps = new DesiredCapabilities();
        desiredCaps.setCapability("platformName", "ios");
        desiredCaps.setCapability("platformVersion", "10.3");
        desiredCaps.setCapability("appiumVersion", "1.6.5");
        desiredCaps.setCapability("deviceName", "iPhone 6");
        desiredCaps.setCapability("app", Paths.get(countersLocation).toAbsolutePath().toString());
        driver = new IOSDriver<IOSElement>(new URL(appiumServer), desiredCaps);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCounters() {
    		TouchAction ta = new TouchAction(driver);
    		MobileElement addButton = (MobileElement)driver.findElementByAccessibilityId("Add");
    		for(int i=0; i<100; i++) {
    			addButton.click();
    			assertTrue(driver.findElementByAccessibilityId(String.valueOf(i)).isDisplayed());
    			
//    			ta.tap(addButton).perform();
//    			ta.tap(addButton).perform();
//    			ta.waitAction(100);
//        		
//    			driver.findElementByAccessibilityId("Add").click();
//			
//    			driver.findElementByAccessibilityId("Done").click();
        		//assertTrue(driver.findElementByAccessibilityId(String.valueOf(i)).isDisplayed());
    		}
        //driver.findElementByAccessibilityId("Edit").click();
        //assertTrue(driver.findElementByAccessibilityId("Done").isDisplayed());
        
    }
}
