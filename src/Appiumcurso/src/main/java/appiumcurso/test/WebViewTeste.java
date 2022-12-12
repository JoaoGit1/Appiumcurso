package appiumcurso.test;

import appiumcurso.BaseTest;
import appiumcurso.page.MenuPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTeste extends BaseTest {
    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();


    @Test
    public void deveFazerLogin() {
        // acessar o menu

        menu.acessarSBHibrido();
        esperar(3000);
        page.entrarContextoWeb();

        //preencher email
        page.setEmail("qateste@gmail.com");

        //senha
        page.setSenha("qateste1234");

        //entrar
        page.entrar();

        //verificar
        Assert.assertEquals("Bem vindo, QATESTE!", page.getMensagem());
    }

    @After
    public void tearDown() {
        page.sairContextoWeb();
    }
}
