package appium.test;

import appium.core.BaseTest;
import appium.pages.FormularioPage;
import appium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //força execução em ordem alfabética
public class DesafioFormularioRefatoradoTest extends BaseTest {

   // private final Methods dsl = new Methods();
    private final MenuPage menu = new MenuPage();
    private final FormularioPage form = new FormularioPage();

    @Before
    public void setApp() {
        //driver = DriverFactory.getDriver();
        menu.acessarFormulario(15);
    }
    @Test
    public void CT01_acessarFormularioEPreencherNome() {
        form.preencherCampoNome("Edward Kenway", 10);
        Assert.assertEquals("Edward Kenway", form.nomePreenchidoNoCampoNome(10));

    }

    @Test
    public void CT02_selecionarConsoleNoFormulario() {
        form.escolherConsole(2, 10);
        Assert.assertEquals("Nintendo Switch", form.consoleEscolhido(10));
    }

    @Test
    public void CT03_checkboxESwitchNoFormulario() {

        Assert.assertEquals("false", form.checkboxChecado(5));
        Assert.assertEquals("true", form.switchHabilitado(5));

        form.clicarCheckbox(10);
        form.clicarSwitch(10);

        Assert.assertEquals("true", form.checkboxChecado(5));
        Assert.assertEquals("false", form.switchHabilitado(5));

        form.salvarEscolhas(10);
    }

    @Test
    public void CT04_validarValoresFormulario() {

        CT01_acessarFormularioEPreencherNome();
        CT02_selecionarConsoleNoFormulario();
        CT03_checkboxESwitchNoFormulario();

        Assert.assertEquals("Nome: Edward Kenway", form.nomeSalvo(5));
        Assert.assertEquals("Console: switch", form.consoleSalvo(5));
        Assert.assertTrue(form.switchSalvo(5).endsWith("Off")); //Valida se a string resumoSwitch termina com o valor Off
        Assert.assertEquals("Checkbox: Marcado", form.checkboxSalvo(5));
    }

}
