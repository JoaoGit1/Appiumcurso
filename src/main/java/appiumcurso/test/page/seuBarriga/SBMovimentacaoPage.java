package appiumcurso.test.page.seuBarriga;

import appiumcurso.page.BasePage;
import org.openqa.selenium.By;

public class SBMovimentacaoPage extends BasePage {
    public void salvar() {
        clicarPorTexto("SALVAR");
    }

    public void setDescricao(String desc) {
        escrever(By.className("android.widget.EditText"),desc);
    }

    public void setInteressado(String interessado) {
        escrever(By.xpath("//android.widget.EditText[2]"), interessado);
    }

    public void setValor(String valor) {
        escrever(By.xpath("//android.widget.EditText[3]"), valor);
    }

    public void setConta(String Conta) {
        escrever(By.xpath("//android.widget.EditText[2]"), Conta);
    }
}
