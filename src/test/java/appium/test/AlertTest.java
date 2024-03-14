package appium.test;

import appium.core.BaseTest;
import appium.pages.AlertPage;
import appium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AlertTest extends BaseTest {
    private final MenuPage menu = new MenuPage();
    private final AlertPage page = new AlertPage();

    @Test
    public void validarAlert() {
        menu.acessarAlert(10);
        page.clicar_alertaConfirm();

        Assert.assertEquals("Info", page.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
        Assert.assertEquals("NEGAR", page.visualizar_botaoNegar());
        page.clicar_Confirmar();

        Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
        page.clicar_Sair();
        timeout(2);
        Assert.assertTrue(page.isAlertaNaoExibido());

    }


}
