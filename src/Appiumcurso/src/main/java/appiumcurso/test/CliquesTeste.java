package appiumcurso.test;

import appiumcurso.BaseTest;
import appiumcurso.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class CliquesTeste extends BaseTest {
    private MenuPage menu = new MenuPage();
    private CliquesPage page = new CliquesPage();

    @Before
    public void setup() {
        menu.acessarCliques();
    }

    @Test
    public void deveRealizarCliqueLongo() {


        //clique longo
        page.cliqueLongo();


        // verificar texto
        Assert.assertEquals("Clique Longo", page.obterTextoCampo());
    }

    @Test
    public void deveRealizarCliqueDuplo() {
        page.clicarPorTexto("Clique duplo");
        page.clicarPorTexto("Clique duplo");

        Assert.assertEquals("Duplo Clique", page.obterTextoCampo());

    }
}
