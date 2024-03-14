package appium.pages;

import appium.core.BasePage;
import appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SplashPage extends BasePage {

    /**
     * Este método verifica se a tela Splash está visível.
     * Ele faz isso procurando por elementos que contêm o texto "Splash!".
     *
     * @return boolean - retorna verdadeiro se elementos com o texto "Splash!" são encontrados, caso contrário, retorna falso.
     */
    public boolean telaSplashVisivel(int timeout) {
        return existeElementosPorTexto("Splash!", timeout);
    }

    /**
     * Este método espera até que a tela Splash desapareça.
     * Ele faz isso aguardando até que o elemento com o texto "Splash!" se torne invisível.
     */
    public void esperarSpashAcabar(int timeout) {

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait waitSpashEncerrar = new WebDriverWait(DriverFactory.getDriver(), 10);
        waitSpashEncerrar.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath("//*[@text='Splash!']")));
    }


}
