package appium.pages;

import appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class AlertPage extends BasePage {

    public void clicar_alertaConfirm() {
        clicar(MobileBy.xpath("//*[@text='ALERTA CONFIRM']"),10);
    }

    public void clicar_Confirmar() {
        clicar(MobileBy.xpath("//*[@text='CONFIRMAR']"), 10);
    }

    public String visualizar_botaoNegar() {
        return obterTexto(MobileBy.xpath("//*[@text='NEGAR']"), 10);

    }

    public void clicar_Sair() {
        clicar(MobileBy.xpath("//*[@text='SAIR']"), 10);
    }

    public String obterTituloAlerta() {
        return obterTexto(MobileBy.id("android:id/alertTitle"), 10);
    }

    public String obterMensagemAlerta() {
        return obterTexto(MobileBy.id("android:id/message"), 10);
    }

    public Boolean isAlertaNaoExibido() {
        return naoExisteElementosPorTexto("Info", 10);
    }

}
