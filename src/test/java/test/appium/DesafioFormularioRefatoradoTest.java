package test.appium;

import appium.core.DriverFactory;
import appium.core.Methods;
import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.FormularioPage;
import pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //força execução em ordem dos testes
public class DesafioFormularioRefatoradoTest {

    private final Methods dsl = new Methods();
    private final MenuPage menu = new MenuPage();
    private final FormularioPage form = new FormularioPage();

    @Before
    public void setApp() {
        //driver = DriverFactory.getDriver();
        menu.acessarFormulario();
    }

    @After
    public void tearDown() {
        DriverFactory.killDriver();
    }

    @Test
    public void CT01_acessarFormularioEPreencherNome() {
        form.preencherCampoNome("Edward Kenway");
        Assert.assertEquals("Edward Kenway", form.nomePreenchidoNoCampoNome());

    }

    @Test
    public void CT02_selecionarConsoleNoFormulario() {
        form.escolherConsole(2);
        Assert.assertEquals("Nintendo Switch", form.consoleEscolhido());
    }

    @Test
    public void CT03_checkboxESwitchNoFormulario() {

        Assert.assertEquals("false", form.checkboxChecado());
        Assert.assertEquals("true", form.switchHabilitado());

        form.clicarCheckbox();
        form.clicarSwitch();

        Assert.assertEquals("true", form.checkboxChecado());
        Assert.assertEquals("false", form.switchHabilitado());

        form.salvarEscolhas();
        dsl.aguardar(1000);
    }

    @Test
    public void CT04_validarValoresFormulario() {

        CT01_acessarFormularioEPreencherNome();
        CT02_selecionarConsoleNoFormulario();
        CT03_checkboxESwitchNoFormulario();

        Assert.assertEquals("Nome: Edward Kenway", form.nomeSalvo());
        Assert.assertEquals("Console: switch", form.consoleSalvo());
        Assert.assertTrue(form.switchSalvo().endsWith("Off")); //Valida se a string resumoSwitch termina com o valor Off
        Assert.assertEquals("Checkbox: Marcado", form.checkboxSalvo());
    }

}
