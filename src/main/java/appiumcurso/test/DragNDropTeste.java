package appiumcurso.test;

import appiumcurso.BaseTest;
import appiumcurso.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class DragNDropTeste extends BaseTest {

    MenuPage menu = new MenuPage();
    DragDropPage page = new DragDropPage();
    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo", "e arraste para", "qualquer local desejado."};

    private String[] estadoItermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo", "e arraste para", "Esta", "qualquer local desejado."};

    private String[] estadoFinal = new String[]{"Faça um clique longo", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

    @Test
    public void deveEfetuarDragNDrop() {
        // acessar menu
        menu.clicarDragNDrop();

        // verificar estado inicial
       try {
          wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertArrayEquals(estadoInicial, page.obterLista());

        // arrastar Esta para  e arraste para
        page.arrastar("Esta", "e arraste para ");

        // verificar estado intermediario
        Assert.assertArrayEquals(estadoItermediario, page.obterLista());

        // arrastar Faça um clique longo  para é uma lista
        page.arrastar("Faça um clique longo", "é uma lista");

        // verificar estado final
        Assert.assertArrayEquals(estadoFinal, page.obterLista());

    }
}
