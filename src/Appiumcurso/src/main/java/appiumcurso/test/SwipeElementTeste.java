package appiumcurso.test;

import appiumcurso.BaseTest;
import appiumcurso.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeElementTeste extends BaseTest {
    private MenuPage menu = new MenuPage();
    private SwipeListPage page = new SwipeListPage();

    @Test
    public void deveResolverDesafio() {
      //  //1 clicar swipe list
        menu.clicarSwipeList();

        //2 op1 para direita
        page.swipeElementRight("Opção 1");

        //3 op1 +
        page.clicarBotaoMais();

        //4 verificar op1 +
        Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));

        //5 op4 para direita
        page.swipeElementRight("Opção 4");

        //6 op4 -
        page.clicarPorTexto("(-)");

        //7 verificar op4 -
        Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));

        //8 op5 para esquerda
        page.swipeElementLeft("Opção 5 (-)");

        //9 verificar op5
        Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));


    }
}
