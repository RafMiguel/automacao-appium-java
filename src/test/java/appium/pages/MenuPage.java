package appium.pages;

import appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class MenuPage extends BasePage {

    public void acessarFormulario(){
        clicar(MobileBy.xpath("//android.widget.TextView[@text='Formulário']"));
    }



}
