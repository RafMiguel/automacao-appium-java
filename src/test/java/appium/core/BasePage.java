package appium.core;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    AndroidDriver<MobileElement> driver = DriverFactory.getDriver();

    /**
     * Método para clicar em um elemento.
     *
     * @param el Informe o elemento
     */
    public void clicar(By el, int timeout) {
        driver.findElement(el).click();
        timeout(timeout);
    }

    /**
     * Método para digitar um texto.
     *
     * @param el    Informe o elemento
     * @param texto Informe o texto
     *              a ser digitado
     */
    public void digitar(By el, String texto, int timeout) {
        driver.findElement(el).sendKeys(texto);
        timeout(timeout);
    }

    /**
     * Método para capturar um atributo.
     *
     * @param el       Informe o elemento
     * @param atributo Informe o nome do atributo
     * @return Quando o método for chamado,
     * será devolvido o valor do
     * atributo
     */
    public String pegarAtributo(By el, String atributo, int timeout) {
        timeout(timeout);
        return driver.findElement(el).getAttribute(atributo);
    }

    /**
     * Método para capturar um texto.
     *
     * @param el Informe o elemento
     * @return Quando o método for chamado,
     * será devolvido o texto
     * encontrado no elemento
     */
    public String obterTexto(By el, int timeout) {
        timeout(timeout);
        return driver.findElement(el).getText();

    }

    /**
     * Método para capturar uma lista.
     *
     * @param el Informe o elemento
     * @return Quando o método for chamado,
     * será devolvida a lista
     * encontrada no elemento
     */
    public List<MobileElement> obterLista(By el, int timeout) {
        timeout(timeout);
        return driver.findElements(el);
    }

    /**
     * Clica em um item específico de uma lista.
     *
     * @param el         = Informe o elemento
     * @param numeroItem Informe o número do índice do item que será clicado.
     *                   Índice começa do nº0. Ex:
     *                   Primeiro item da lista é o index 0
     *                   Segundo item da lista é o index 1
     */
    public void clicarLista(By el, int numeroItem, int timeout) {
        obterLista(el, timeout).get(numeroItem).click();

    }

    /**
     * Método para capturar e comparar se duas strings são iguais.
     *
     * @param el          Informe o elemento que
     *                    contém o texto
     * @param txtEsperado Informe o texto esperado
     */
    public void validarTexto(By el, String txtEsperado, int timeout) {
        String txtAtual = driver.findElement(el).getText();
        timeout(timeout);
        Assert.assertEquals(txtEsperado, txtAtual);
    }

    public boolean existeElementosPorTexto(String texto, int timeout) {
        List<MobileElement> elemento = driver.findElements(MobileBy.xpath("//*[@text='" + texto + "']")); //busca todos os elementos que contém a string passada
        timeout(timeout);
        return elemento.size() > 0; //Retornará o elemento acima se encontrar pelo menos um dele
    }

    public boolean naoExisteElementosPorTexto(String texto, int timeout) {
        List<MobileElement> elemento = driver.findElements(MobileBy.xpath("//*[@text='" + texto + "']")); //busca todos os elementos que contém a string passada
        timeout(timeout);
        return elemento.size() == 0; //Não deve retornar o elemento acima
    }

    public void timeout(int tempo){
        driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.SECONDS);
    }

    public void espereAteElementoAparecer(By el, int tempo){
        WebDriverWait wait = new WebDriverWait(driver, tempo);
        wait.until(ExpectedConditions.presenceOfElementLocated(el));
    }

    public void espereAteElementoSerClicavel(By el, int tempo){
        WebDriverWait wait = new WebDriverWait(driver, tempo);
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    public void esperarAteElementoDesaparecer(By el, int tempo){
        WebDriverWait wait = new WebDriverWait(driver, tempo);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(el));
    }

}
