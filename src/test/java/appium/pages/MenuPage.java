package pages;

import appium.core.Methods;
import io.appium.java_client.MobileBy;

public class MenuPage {
    private final Methods dsl = new Methods();

    public void acessarFormulario(){
        dsl.clicar(MobileBy.xpath("//android.widget.TextView[@text='Formulário']"));
    }



}
