package test.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CTTest {
    static AndroidDriver driver; //Driver de conexão
    static String appRoot = System.getProperty("user.dir") + ("\\src\\test\\resources\\app\\");
    //user.dir = levará para o diretório raiz do projeto // + local complementar da pasta alvo
    static boolean isAppStarted;

    @Before
    public void abrirApp() throws MalformedURLException, InterruptedException {
        if (!isAppStarted) {
            System.out.println("Aplicativo não iniciado!!");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "emulator-5554");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("avd", "Nexus_6_API_25");
            caps.setCapability("app", appRoot + "CTAppium_2_0.apk");
            caps.setCapability("appPackage", "com.ctappium");
            caps.setCapability("appActivity", "com.ctappium.MainActivity");
            caps.setCapability("newCommandTimeout", 3600);

            URL route = new URL("http://localhost:4723");
            driver = new AndroidDriver(route, caps);
            isAppStarted = true;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {
            System.out.println("Aplicativo já iniciado!!");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @Test
    public void preencherNomeFormulario() throws MalformedURLException, InterruptedException {

        //XPATH MOBILE = //nome da class[@atributo="valor do atributo"]
        MobileElement formulario = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Formulário']");
        Assert.assertEquals("Formulário", formulario.getText());
        formulario.click();
        MobileElement inputNome = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@text='Nome']");
                inputNome.sendKeys("Ryu Hayabusa");
                Assert.assertEquals("Ryu Hayabusa", inputNome.getText());
    }

    @Test
    public void trazerTodosOsTextosDeUmaMesmaClasse() throws MalformedURLException, InterruptedException {

        //Obter uma lista com todos os textos de uma mesma classe
        List<MobileElement> opcoesMenu = driver.findElements(By.className("android.widget.TextView"));
        for (MobileElement opcoesEncontradas : opcoesMenu){
            System.out.println(opcoesEncontradas.getText());

            //Validar a quantidade de textos retornados na mesma classe
            int qtd_opcoes = opcoesMenu.size();
            Assert.assertEquals(11, qtd_opcoes);
        }
    }

    @Test
    public void escolherOpcaoDeConsoleNoFormulario(){
        driver.findElementByXPath("//android.widget.TextView[@text='Formulário']").click();
        driver.findElement(MobileBy.AccessibilityId("console")).click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='PS4']").click();

            String consoleEscolhido = driver.findElement(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
            Assert.assertEquals("PS4", consoleEscolhido);
    }

    @Test
    public void checkboxESwitchNoFormulario(){
        driver.findElementByXPath("//*[@text='Formulário']").click();
        MobileElement checkbox = (MobileElement) driver.findElementByClassName("android.widget.CheckBox");
        MobileElement switc = (MobileElement) driver.findElementByClassName("android.widget.Switch");
        Assert.assertTrue(checkbox.getAttribute("checkable").equals("true"));
        Assert.assertTrue(checkbox.getAttribute("checked").equals("false"));
        Assert.assertTrue(switc.getAttribute("checkable").equals("true"));
        Assert.assertTrue(switc.getAttribute("checked").equals("true"));

        checkbox.click();
        switc.click();

        Assert.assertTrue(checkbox.getAttribute("checked").equals("true"));
        Assert.assertTrue(switc.getAttribute("checked").equals("false"));

    }

    @After
    public void tearDown() {
        //driver.quit();
    }

}
