package appiumcurso.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appiumcurso.DriverFactory.getDriver;

public class MenuPage extends BasePage {

    public void acessarformulario(String nome) {
        clicarPorTexto("Formulário");
    }

    public void acessarSplash(String nome) {
        clicarPorTexto("Splash");
    }

    public void acessarAlertas(){
        clicarPorTexto("Alertas");
    }
public void acessarAbas(String nome){
        clicarPorTexto(("Abas"));
}
    public void acessarAccordion(String nome){
        clicarPorTexto(("Accordion"));
}
public void acessarCliques(){
      clicarPorTexto("Cliques");
}
public void acessarSwipe(){
        clicarPorTexto("Swipe");
}
public void clicarSwipeList(){
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    wait.until(ExpectedConditions.
           presenceOfElementLocated
                   (By.xpath("//*[@text='Formulário']")));
    scrollDown();
    clicarPorTexto("Swipe List ");
}

   public void clicarDragNDrop(){
       WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.
               presenceOfElementLocated
                        (By.xpath("//*[@text='Formulário']")));
       scrollDown();
        clicarPorTexto("Drag and drop ");
}
public void acessarSBHibrido(){
        clicarPorTexto("SeuBarriga Híbrido");
}
    public void acessarSBNativo(){
        clicarPorTexto("SeuBarriga Nativo");

}}

