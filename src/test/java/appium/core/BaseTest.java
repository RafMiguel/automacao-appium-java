package appium.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * Esta classe base fornece métodos comuns que são executados durante os testes.
 */

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    /**
     * Este método é chamado após todos os testes terem sido executados.
     * Ele chama o método killDriver() da classe DriverFactory para encerrar o driver.
     */

    @AfterClass
    public static void encerrarDriver() {
        DriverFactory.killDriver();
    }

    /**
     * Este método é chamado após cada teste.
     * Ele chama o método getDriver() da classe DriverFactory para obter o driver e então resetar o aplicativo
     * em execução.
     */

    @After
    public void resetarApp(){
        screenshot();
        DriverFactory.getDriver().resetApp();

    }

    /**
     * Este método faz a thread atual dormir pelo número de milissegundos especificado.
     * @param tempo O número de milissegundos que a thread atual deve dormir.
     * @throws RuntimeException se a thread for interrompida enquanto está dormindo.
     */

    public void aguardar(int tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void screenshot(){
       File print = DriverFactory.getDriver().getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(print, new File("target/screenshots/"+testName.getMethodName()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
