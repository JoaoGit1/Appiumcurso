package appiumcurso.test;

import appiumcurso.BaseTest;
import appiumcurso.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTeste extends BaseTest {
    private MenuPage menu = new MenuPage();


    @Test
    public void deveRealizarSwipe() {

        // acessar menu
        menu.acessarSwipe();

        // verificar texto 'a esquerda'

        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

        // swipe para direita
        menu.swipe(0.9, 0.1);
        //menu.swipeRight();

        // verificar texto ' E vejo se '
        Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

        // clicar botão direito
        menu.clicarPorTexto("›");

        // verificar texto 'Chegar até o fim!'
        Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

        // swipe esquerdo
        menu.swipe(0.1, 0.9);
      //  menu.swipeLeft();

        // clicar botão esquerdo
        menu.clicarPorTexto("‹");

        // verificar texto 'a esquerda'

        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
    }
}
