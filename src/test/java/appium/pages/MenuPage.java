package appium.pages;

import appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class MenuPage extends BasePage {

    public void acessarFormulario(int timeout) {
        clicar(MobileBy.xpath("//android.widget.TextView[@text='Formulário']"), timeout);
    }

    public void acessarSplash(int timeout) {
        clicar(MobileBy.xpath("//android.widget.TextView[@text='Splash']"), timeout);
    }

    public void acessarAlert(int timeout) {
        clicar(MobileBy.xpath("//android.widget.TextView[@text='Alertas']"), timeout);
    }


}
