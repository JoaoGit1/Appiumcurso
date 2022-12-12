package appiumcurso;

import appiumcurso.page.MenuPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appiumcurso.DriverFactory.getDriver;

public class OpcaoEscondidaTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private int x;


    @Test
    public void deveEncontrarOpçãoEscondida() {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        System.out.println("Começando ");
        // scroll down

         menu.scroll(0.9, 0.1, x);
       // menu.scrollDown();

        // clicar menu

        menu.clicarPorTexto("Opção bem escondida ");

        // verificar mensagem
        Assert.assertEquals("Você achou esta opção", menu.obterMensagemAlerta());


        //sair
        menu.clicarPorTexto("OK");
    }
}
