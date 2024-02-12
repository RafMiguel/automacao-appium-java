package appium.core;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
public class Methods {
    AndroidDriver<MobileElement> driver = DriverFactory.getDriver();

    /**
     * Método para clicar em um elemento.
     *
     * @param el Informe o elemento
     *
     */
    public void clicar(By el) {
        driver.findElement(el).click();
    }

    /**
     * Método para digitar um texto.
     *
     * @param el Informe o elemento
     * @param texto Informe o texto
     *              a ser digitado
     */
    public void digitar(By el, String texto) {
        driver.findElement(el).sendKeys(texto);
    }

    /**
     *Método para capturar um atributo.
     *
     * @param el Informe o elemento
     * @param atributo Informe o nome do atributo
     * @return Quando o método for chamado,
     *          será devolvido o valor do
     *          atributo
     */
    public String pegarAtributo(By el, String atributo) {
        return driver.findElement(el).getAttribute(atributo);
    }

    /**
     *Método para capturar um texto.
     *
     * @param el Informe o elemento
     * @return Quando o método for chamado,
     *          será devolvido o texto
     *          encontrado no elemento
     */
    public String pegarTexto(By el) {
        return driver.findElement(el).getText();

    }

    /**
     *Método para capturar uma lista.
     *
     * @param el Informe o elemento
     * @return Quando o método for chamado,
     *          será devolvida a lista
     *          encontrada no elemento
     */
    public List<MobileElement> obterLista(By el) {
        List<MobileElement> lista = driver.findElements(el);
        return lista;
    }

    /**
     * Clica em um item específico de uma lista.
     *
     * @param el = Informe o elemento
     * @param numeroItem Informe o número do índice do item que será clicado.
     *                  Índice começa do nº0. Ex:
     *                   Primeiro item da lista é o index 0
     *                   Segundo item da lista é o index 1
     */
    public void clicarLista (By el, int numeroItem){

        obterLista(el).get(numeroItem).click();
    }

    /**
     *Método para capturar e comparar se duas strings são iguais.
     *
     * @param el Informe o elemento que
     *           contém o texto
     * @param txtEsperado Informe o texto esperado
     */
    public void validarTexto(By el, String txtEsperado){
        String txtAtual = driver.findElement(el).getText();
        Assert.assertEquals(txtEsperado, txtAtual);
    }

    /**
     * Pauses the execution of the current thread for a specified amount of time.
     *
     * @param tempo the length of time to sleep in milliseconds
     * @throws RuntimeException if the sleep is interrupted
     */
    public void aguardar(int tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
