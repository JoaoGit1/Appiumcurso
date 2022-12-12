package appiumcurso;

import appiumcurso.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTeste extends BaseTest {
    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();

    @Test
    public void deveInteragirComAccordion(String nome) {
        // acessar menu
        menu.acessarAccordion(nome);
        // clicar opçao 1
        page.selecionarOp1(nome);

        // verificar texto opção 1
        
        Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
    }


}
