package appium.pages;

import appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

    /**
     * Fills the name field with the provided text.
     *
     * @param texto The text to be entered in the name field.
     */
    public void preencherCampoNome(String texto, int timeout) {
        digitar(MobileBy.AccessibilityId("nome"), texto, timeout);
    }

    /**
     * Retrieves the text entered in the name field.
     *
     * @return The text from the name field.
     */
    public String nomePreenchidoNoCampoNome(int timeout) {
        return obterTexto(MobileBy.AccessibilityId("nome"), timeout);
    }

    /**
     * Selects an item from the console dropdown.
     *
     * @param numeroItem The index of the item to be selected from the dropdown.
     */
    public void escolherConsole(int numeroItem, int timeout) {
        clicar(MobileBy.className("android.widget.Spinner"), 10);
        clicarLista(MobileBy.xpath("//android.widget.ListView/android.widget.CheckedTextView"), numeroItem, timeout);
    }

    /**
     * Retrieves the text of the selected item in the console dropdown.
     *
     * @return The text of the selected item in the console dropdown.
     */
    public String consoleEscolhido(int timeout) {
        return obterTexto(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView"), timeout);
    }

    /**
     * Clicks on the checkbox.
     */
    public void clicarCheckbox(int timeout) {
        clicar(MobileBy.className("android.widget.CheckBox"), timeout);
    }

    /**
     * Clicks on the switch.
     */
    public void clicarSwitch(int timeout) {
        clicar(MobileBy.className("android.widget.Switch"), timeout);
    }

    /**
     * Checks if the checkbox is checked.
     *
     * @return The checked attribute of the checkbox.
     */
    public String checkboxChecado(int timeout) {
        return pegarAtributo(MobileBy.className("android.widget.CheckBox"), "checked", timeout);
    }

    /**
     * Checks if the switch is enabled.
     *
     * @return The checked attribute of the switch.
     */
    public String switchHabilitado(int timeout) {
        return pegarAtributo(MobileBy.className("android.widget.Switch"), "checked", timeout);
    }

    /**
     * Clicks on the save button.
     */
    public void salvarEscolhas(int timeout) {
        clicar(MobileBy.AccessibilityId("save"), timeout);
    }

    /**
     * Retrieves the saved name.
     *
     * @return The saved name.
     */
    public String nomeSalvo(int timeout) {
        return obterTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Nome:')]"), timeout);
    }

    /**
     * Retrieves the saved console.
     *
     * @return The saved console.
     */
    public String consoleSalvo(int timeout) {
        return obterTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Console:')]"), timeout);
    }

    /**
     * Retrieves the saved switch state.
     *
     * @return The saved switch state.
     */
    public String switchSalvo(int timeout) {
        return obterTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Switch:')]"), timeout);
    }

    /**
     * Retrieves the saved checkbox state.
     *
     * @return The saved checkbox state.
     */
    public String checkboxSalvo(int timeout) {
        return obterTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Checkbox:')]"), timeout);
    }

}
