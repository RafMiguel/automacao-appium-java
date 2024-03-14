package appium.test;

import appium.core.BaseTest;
import appium.pages.MenuPage;
import appium.pages.SplashPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Test;

public class SplashTest extends BaseTest {

    private final MenuPage menu = new MenuPage();
    private final SplashPage splash = new SplashPage();

    @Test
    public void validarVisibilidade_Invisibilidade_doSplash() {

        //acessar menu splash
        menu.acessarSplash(10);
        //verificar que o splash está sendo exibido
        splash.telaSplashVisivel(5);
        //aguardar encerramento do splash
        splash.esperarSpashAcabar(10);
        //verificar a exibição do formulário
        Assert.assertEquals("Formulário", menu.obterTexto(MobileBy.xpath("//*[@text='Formulário']"), 10));

    }

}
