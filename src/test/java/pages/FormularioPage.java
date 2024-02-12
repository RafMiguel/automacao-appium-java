package pages;

import appium.core.Methods;
import io.appium.java_client.MobileBy;

public class FormularioPage {

    private final Methods dsl = new Methods();

    /**
     * Fills the name field with the provided text.
     *
     * @param texto The text to be entered in the name field.
     */
    public void preencherCampoNome(String texto) {
        dsl.digitar(MobileBy.AccessibilityId("nome"), texto);
    }

    /**
     * Retrieves the text entered in the name field.
     *
     * @return The text from the name field.
     */
    public String nomePreenchidoNoCampoNome() {
        return dsl.pegarTexto(MobileBy.AccessibilityId("nome"));
    }

    /**
     * Selects an item from the console dropdown.
     *
     * @param numeroItem The index of the item to be selected from the dropdown.
     */
    public void escolherConsole(int numeroItem) {
        dsl.clicar(MobileBy.className("android.widget.Spinner"));
        dsl.clicarLista(MobileBy.xpath("//android.widget.ListView/android.widget.CheckedTextView"), numeroItem);
    }

    /**
     * Retrieves the text of the selected item in the console dropdown.
     *
     * @return The text of the selected item in the console dropdown.
     */
    public String consoleEscolhido(){
        return dsl.pegarTexto(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    /**
     * Clicks on the checkbox.
     */
    public void clicarCheckbox(){
        dsl.clicar(MobileBy.className("android.widget.CheckBox"));
    }

    /**
     * Clicks on the switch.
     */
    public void clicarSwitch(){
        dsl.clicar(MobileBy.className("android.widget.Switch"));
    }

    /**
     * Checks if the checkbox is checked.
     *
     * @return The checked attribute of the checkbox.
     */
    public String checkboxChecado(){
        return dsl.pegarAtributo(MobileBy.className("android.widget.CheckBox"), "checked");
    }

    /**
     * Checks if the switch is enabled.
     *
     * @return The checked attribute of the switch.
     */
    public String switchHabilitado(){
        return dsl.pegarAtributo(MobileBy.className("android.widget.Switch"), "checked");
    }

    /**
     * Clicks on the save button.
     */
    public void salvarEscolhas(){
        dsl.clicar(MobileBy.AccessibilityId("save"));
    }

    /**
     * Retrieves the saved name.
     *
     * @return The saved name.
     */
    public String nomeSalvo(){
        return dsl.pegarTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Nome:')]"));
    }

    /**
     * Retrieves the saved console.
     *
     * @return The saved console.
     */
    public String consoleSalvo(){
        return dsl.pegarTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Console:')]"));
    }

    /**
     * Retrieves the saved switch state.
     *
     * @return The saved switch state.
     */
    public String switchSalvo(){
        return dsl.pegarTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Switch:')]"));
    }

    /**
     * Retrieves the saved checkbox state.
     *
     * @return The saved checkbox state.
     */
    public String checkboxSalvo(){
        return dsl.pegarTexto(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Checkbox:')]"));
    }


}
