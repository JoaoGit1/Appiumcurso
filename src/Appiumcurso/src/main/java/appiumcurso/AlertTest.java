package appiumcurso;

import appiumcurso.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlertTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();

    @Before
    public void setup() {
        menu.acessarAlertas();
    }

    @Test
    public void deveConfirmarAlerta(String nome) {
        // acessar menu alerta
        menu.acessarAlertas();

        // clicar em alerta confirm
        page.clicarAlertaConfirm(nome);

        // verificar os textos
        Assert.assertEquals("Info", page.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());

        // confirmar alerta
        page.confirmar(nome);

        // verificar nova mensagem
        Assert.assertEquals("Confirmado", page.obterMensagemAlerta());

        //sair
        page.sair(nome);
    }

    @Test
    public void deveClicarForaAlerta() {

        // clicar alerta simples
        page.clicarAlertaSimples();

        // clicar fora da caixa
        esperar(1000);

        page.clicarForaDaCaixa();

        // verificar que a mensagem nao esta presente
        Assertions.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));

    }

    public void esperar(int i) {
    }


}
