package appiumcurso;

import appiumcurso.page.BasePage;

public class AlertaPage extends BasePage {
    public void clicarAlertaConfirm(String nome) {
        clicarPorTexto("ALERTA CONFIRM");
    }
public void clicarAlertaSimples(){
        clicarPorTexto("ALERTA SIMPLES");
}


    public void confirmar(String nome){
        clicarPorTexto("CONFIRMAR");
    }
    public void sair(String nome){
        clicarPorTexto("SAIR");

    }
    public void clicarForaDaCaixa(){

    }
}
