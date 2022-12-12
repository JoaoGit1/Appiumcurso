package appiumcurso;

import appiumcurso.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTest extends BaseTest {


    private MenuPage menu = new MenuPage();
    private SplashPage page = new SplashPage();

    @Test
    public void deveAguardarSplashSumir(String nome) {
        //acessar menu Splash
        menu.acessarSplash(nome);


        //verificar que o splash esta sendo exibido
        page.isTelaSplashVisivel();

        //aguardar sair do splash
        page.aguardarSplashSumir();

        //verificar que o formulario esta aparecendo
        Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
    }
}
