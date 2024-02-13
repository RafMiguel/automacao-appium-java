package appium.pages;

import appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

    /**
     * Fills the name field with the provided text.
     *
     * @param texto The text to be entered in the name field.
     */
    public void preencherCampoNome(String texto) {
        digitar(MobileBy.AccessibilityId("nome"), texto);
    }

    /**
     * Retrieves the text entered in the name field.
     *
     * @return The text from the name field.
     */
    public String nomePreenchidoNoCampoNome() {
        return pegarTexto(MobileBy.AccessibilityId("nome"));
    }

    /**
     * Selects an item from the console dropdown.
     *
     * @param numeroItem The index of the item to be selected from the dropdown.
     */
    public void escolherConsole(int numeroItem) {
        clicar(MobileBy.className("android.widget.Spinner"));
        clicarLista(MobileBy.xpath("//android.widget.ListView/android.widget.CheckedTextView"), numeroItem);
    }

    /**
     * Retrieves the text of the selected item in the console dropdown.
     *
     * @return The text of the selected item in the console dropdown.
     */
    public String consoleEscolhido() {
        return pegarTexto(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    /**
     * Clicks on the checkbox.
     */
    public void clicarCheckbox() {
        clicar(MobileBy.className("android.widget.CheckBox"));
    }

    /**
     * Clicks on the switch.
     */
    public void clicarSwitch() {
        clicar(MobileBy.className("android.widget.Switch"));
    }

    /**
     * Checks if the checkbox is checked.
     *
     * @return The checked attribute of the checkbox.
     */
    public String checkboxChecado() {
        return pegarAtributo(MobileBy.className("android.widget.CheckBox"), "checked");
    }

    /**
     * Checks if the switch is enabled.
     *
     * @return The checked attribute of the switch.
     */
    public String switchHabilitado() {
        return pegarAtributo(MobileBy.className("android.widget.Switch"), "checked");
    }

    /**
     * Clicks on the save button.
     */
    public void salvarEscolhas() {
        clicar(MobileBy.AccessibilityId("save"));
    }

    /**
     * Retrieves the saved name.
     *
     * @return The saved name.
     */
    public String nomeSalvo() {
        return pegarTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Nome:')]"));
    }

    /**
     * Retrieves the saved console.
     *
     * @return The saved console.
     */
    public String consoleSalvo() {
        return pegarTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Console:')]"));
    }

    /**
     * Retrieves the saved switch state.
     *
     * @return The saved switch state.
     */
    public String switchSalvo() {
        return pegarTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Switch:')]"));
    }

    /**
     * Retrieves the saved checkbox state.
     *
     * @return The saved checkbox state.
     */
    public String checkboxSalvo() {
        return pegarTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Checkbox:')]"));
    }


}
