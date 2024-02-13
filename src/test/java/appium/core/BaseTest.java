package appium.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

/**
 * Esta classe base fornece métodos comuns que são executados durante os testes.
 */

public class BaseTest {

    /**
     * Essa é uma Rule do JUnit, que retorna o nome do teste em execução.
     * Ela é útil quando você quer realizar alguma ação baseada no nome do teste.
     *
     * @Rule é uma modificação ou adição ao comportamento do teste. Nesse caso,
     * ela permite acessar o nome do atual teste em execução.
     */
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

    public void espereAteElementoAparecer(By el, int tempo){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), tempo);
        wait.until(ExpectedConditions.presenceOfElementLocated(el));
    }

    public void espereAteElementoSerClicavel(By el, int tempo){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    /**
     * Este método é usado para tirar uma captura de tela do estado atual do aplicativo em teste.
     * A captura de tela é salva como um arquivo .png no diretório "target/screenshots/".
     * O nome do print é o mesmo do método de teste em execução.
     * @throws RuntimeException se ocorrer um erro ao copiar o arquivo de captura de tela para o diretório de destino.
     */
    public void screenshot(){
       File print = DriverFactory.getDriver().getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(print, new File("target/screenshots/"+testName.getMethodName()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
