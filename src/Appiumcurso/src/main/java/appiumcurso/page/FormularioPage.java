package appiumcurso.page;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static appiumcurso.DriverFactory.getDriver;

public class FormularioPage extends BasePage {

    public void escreverNome(String nome) {
        escrever(MobileBy.AccessibilityId("nome"), nome);
    }

    public String obterNome() {
        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarCombo(String valor, String nome) {
        selecionarCombo(MobileBy.AccessibilityId("console"), valor, nome);
    }

    public String obterValorCombo() {
        return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck(String nome) {
        clicar(By.className("android.widget.CheckBox"));
    }

    public void clicarSwitch(String nome) {
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public Boolean isCheckMarcado() {
        return isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public Boolean isSwitchMarcado() {
        return isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void clicarSeekBar(double posicao) {
        int delta = 50;
        MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
        int y = seek.getLocation().y + (seek.getSize().height / 2);
        System.out.println(y);

        int xinicial = seek.getLocation().x + delta;
        int x = (int) (xinicial + ((seek.getSize().width - 2*delta) * posicao));
        System.out.println(x);
        tap(x, y);

    }

    public void salvar() {
        clicarPorTexto("SALVAR");
    }

    public void salvarDemorado(String nome) {
        clicarPorTexto("SALVAR DEMORADO");
    }

    public String obterNomeCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String obterConsoleCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));

    }

    public String obterCheckCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

    public String obterSwitchCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

}
