package appiumcurso.test;

import appiumcurso.page.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

import static appiumcurso.DriverFactory.getDriver;

public class WebViewPage extends BasePage {
    public void entrarContextoWeb(){
      Set<String> contextHandles =  getDriver().getContextHandles();
    //   for(String valor: contextHandles) {
    //       System.out.println(valor);
    //   }
       getDriver().context((String) contextHandles.toArray()[1]);
    }
    public void setEmail(String valor){
        getDriver().findElement(By.id("email"));
    }

    public void setSenha(String valor){
        getDriver().findElement(By.id("senha"));

    }
    public void entrar(){
        clicar(By.xpath("//button[@type='submit']"));
    }
    public String getMensagem(){
        return obterTexto(By.xpath("//div[@class='alert-siccess']"));
    }
    public void sairContextoWeb(){
 getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
    }
}
