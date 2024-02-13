package appium.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


    public class CalcTest {
        static AndroidDriver driver; //Driver de conexão

        @Test
    public void somarDoisNumeros() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        caps.setCapability("newCommandTimeout", 3600);

        URL route = new URL("http://localhost:4723");
        driver = new AndroidDriver(route, caps);

        MobileElement num3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
        num3.click();
        MobileElement btnPlus = (MobileElement) driver.findElementById("com.android.calculator2:id/op_add");
        btnPlus.click();
        MobileElement num2 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        num2.click();
        MobileElement btnEq = (MobileElement) driver.findElementById("com.android.calculator2:id/eq");
        btnEq.click();

        MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
        Assert.assertEquals("5",result.getText());

    }

        @After
        public void quitApp() {
            driver.quit();
        }

}
