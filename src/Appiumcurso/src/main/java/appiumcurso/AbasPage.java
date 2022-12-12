package appiumcurso;

import appiumcurso.page.BasePage;

public class AbasPage extends BasePage {
    public boolean isAba1() {
       return existeElementoPorTexto("Este é o conteúdo da Aba 1");
    }

    public Boolean isAba2() {
      return  existeElementoPorTexto("Este é o conteúdo da Aba 2");
    }
    public void selecionarAba2(String nome){
        clicarPorTexto("ABA 2");
    }
}
