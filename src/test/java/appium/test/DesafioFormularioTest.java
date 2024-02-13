package appium.test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

@FixMethodOrder (MethodSorters.NAME_ASCENDING) //força execução em ordem dos testes
public class DesafioFormularioTest {

    static AndroidDriver driver;
    static String app = System.getProperty("user.dir") + ("\\src\\test\\resources\\app\\");


    @Before
    public void setApp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app", app + "CTAppium_2_0.apk");
        caps.setCapability("appPackage", "com.ctappium");
        caps.setCapability("appActivity", "com.ctappium.MainActivity");

        URL route = new URL("http://localhost:4723");
        driver = new AndroidDriver(route, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Formulário']").click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void acessarFormularioEPreencherNome() {
        MobileElement inputNome = (MobileElement) driver.findElement(MobileBy.AccessibilityId("nome"));
        inputNome.sendKeys("Edward Kenway");
        Assert.assertEquals("Edward Kenway", inputNome.getText());
    }

    @Test
    public void selecionarConsoleNoFormulario() {
        driver.findElementByClassName("android.widget.Spinner").click();
        List<MobileElement> consoles = driver.findElements(By.xpath("//android.widget.ListView/android.widget.CheckedTextView"));
        consoles.get(2).click();
        MobileElement consoleSelecionado = (MobileElement) driver.findElementByXPath("//android.widget.Spinner/android.widget.TextView");
        Assert.assertEquals("Nintendo Switch", consoleSelecionado.getText());
    }

    @Test
    public void checkboxESwitchNoFormulario() throws InterruptedException {
        MobileElement checkbox = (MobileElement) driver.findElementByClassName("android.widget.CheckBox");
        MobileElement switCH = (MobileElement) driver.findElementByClassName("android.widget.Switch");

        Assert.assertTrue(checkbox.getAttribute("checked").equals("false"));
        Assert.assertTrue(switCH.getAttribute("checked").equals("true"));

        checkbox.click();
        switCH.click();

        Assert.assertTrue(checkbox.getAttribute("checked").equals("true"));
        Assert.assertTrue(switCH.getAttribute("checked").equals("false"));

        driver.findElementByAccessibilityId("save").click();
        Thread.sleep(5000);
    }

    @Test
    public void validarValoresFormulario() throws InterruptedException {

        acessarFormularioEPreencherNome();
        selecionarConsoleNoFormulario();
        checkboxESwitchNoFormulario();
        String resumoNome = driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Nome:')]").getText();
        String resumoConsole = driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Console:')]").getText();
        String resumoSwitch = driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Switch:')]").getText();
        String resumoCheckbox = driver.findElementByXPath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]").getText(); //busca pelo texto que inicia com 'Checkbox:'

        Assert.assertEquals("Nome: Edward Kenway", resumoNome);
        Assert.assertEquals("Console: switch", resumoConsole);
        //Assert.assertEquals("Switch: Off", resumoSwitch);
        Assert.assertTrue(resumoSwitch.endsWith("Off")); //Valida se a string resumoSwitch termina com o valor Off
        Assert.assertEquals("Checkbox: Marcado", resumoCheckbox);
        /*List<MobileElement> resumoValores = driver.findElements(MobileBy.className("android.widget.TextView"));
        List<String> camposParaEncontrar = Arrays.asList("Nome:", "Console:", "Checkbox:", "Switch:");
        for (String campos : camposParaEncontrar) {
            boolean camposEncontrados = false;
            MobileElement elementosIsolados = null;

            for (MobileElement elemento : resumoValores) {
                String textoElemento = elemento.getText();
                if (textoElemento.contains(campos)) {
                    camposEncontrados = true;
                    elementosIsolados = elemento;
                    break;

                }

            }

            Assert.assertTrue("Campos não encontrados: " + campos, camposEncontrados);
            String camposResumo = elementosIsolados.getText();
            String[] resultadoEsperado = new String[4];

            resultadoEsperado[0] = "Nome: Edward Kenway";
            resultadoEsperado[1] = "Console: switch";
            resultadoEsperado[2] = "Switch: Off";
            resultadoEsperado[3] = "Checkbox: Marcado";
            Assert.assertEquals(resultadoEsperado[0], camposResumo);
            Assert.assertEquals(resultadoEsperado[1], camposResumo);
            Assert.assertEquals(resultadoEsperado[2], camposResumo);
            Assert.assertEquals(resultadoEsperado[3], camposResumo);


        }*/
    }

}
