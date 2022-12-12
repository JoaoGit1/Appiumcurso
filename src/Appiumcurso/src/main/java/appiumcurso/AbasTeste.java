package appiumcurso;

import appiumcurso.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTeste extends BaseTest { // extends para dar acesso a base teste
    public String nome;
    private final MenuPage menu = new MenuPage(); // instancia
    private final AbasPage page = new AbasPage();

    @Test
    public void deveInteragirComAbas() {
      // acessar menu abas
        menu.acessarAbas(nome);

        // verificar que esta na aba 1
        Assert.assertTrue(page.isAba1());

        //acessar aba 2
        page.selecionarAba2(nome);

        // verificar que esta na aba 2
        Assert.assertTrue(page.isAba2());
    }
}
