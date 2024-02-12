package appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AndroidDriver<MobileElement> driver;
    static String app = System.getProperty("user.dir") + ("\\src\\test\\resources\\app\\");

    //Este método é público e estático, e é usado para obter a instância do driver. Ele verifica se o driver já existe (não é nulo).
    //Se não existir, chama o método createDriver() para criar uma nova instância e, em seguida, retorna o driver.

    /**
     * This method is used to get the instance of the AndroidDriver.
     * If the driver is null, it calls the createDriver() method to create a new instance.
     * @return AndroidDriver<MobileElement> - the instance of the AndroidDriver.
     */
    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app", app + "CTAppium_2_0.apk");
        caps.setCapability("appPackage", "com.ctappium");
        caps.setCapability("appActivity", "com.ctappium.MainActivity");


        URL route = null;
        try {
            route = new URL("http://localhost:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new AndroidDriver<MobileElement>(route, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //Este método é público e estático, usado para encerrar o driver quando chamado se ele estiver ativo.
    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}