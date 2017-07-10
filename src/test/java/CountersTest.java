import io.appium.java_client.AppiumDriver;
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
    protected AppiumDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCaps = new DesiredCapabilities();
        desiredCaps.setCapability("platformName", "ios");
        desiredCaps.setCapability("platformVersion", "10.3");
        desiredCaps.setCapability("appiumVersion", "1.6.5");
        desiredCaps.setCapability("deviceName", "iPhone 6");
        desiredCaps.setCapability("app", Paths.get("/Users/user/jenkins/builds/Debug-iphonesimulator/Counters.app").toAbsolutePath().toString());
        driver = new AppiumDriver(new URL("http://10.1.1.184:4444/wd/hub"), desiredCaps);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCounters() {
        driver.findElementByAccessibilityId("Edit").click();
        assertTrue(driver.findElementByAccessibilityId("Done").isDisplayed());
    }
}
