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
    public void aguardarSplashSumir() {

        //acessar menu splash
        menu.acessarSplash();
        //verificar que o splash está sendo exibido
        splash.telaSplashVisivel();
        //aguardar encerramento do splash
        splash.esperarSpashAcabar();
        //verificar a exibição do formulário
        Assert.assertEquals("Formulário", menu.pegarTexto(MobileBy.xpath("//*[@text='Formulário']")));

    }

}
