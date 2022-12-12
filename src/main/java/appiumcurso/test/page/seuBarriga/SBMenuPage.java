package appiumcurso.test.page.seuBarriga;

import appiumcurso.page.BasePage;

public class SBMenuPage extends BasePage {
    public void acesssarContas(){
        clicarPorTexto("CONTAS");
    }

    public void acessarMovimentacoes(){
        clicarPorTexto("MOV...");
    }

    public void acessarResumo(){
        clicarPorTexto("RESUMO");
    }
    public void acessarHome(){
        clicarPorTexto("Home");
    }
}
