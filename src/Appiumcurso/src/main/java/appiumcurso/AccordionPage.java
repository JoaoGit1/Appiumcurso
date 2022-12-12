package appiumcurso;

import appiumcurso.page.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void selecionarOp1(String nome){
        clicarPorTexto("Opção 1");
    }

    public String obterValorOp1(){ //metodo retornar vaalor
return obterTexto(By.xpath("//*[@text='Opção 1']/../..//following-síbling::android.View.ViewGroup//android.widget.TextView"));
    }
}
