package appiumcurso.test;


import appiumcurso.page.BasePage;
import org.openqa.selenium.By;

import static appiumcurso.DriverFactory.getDriver;

public class CliquesPage extends BasePage {


public void cliqueLongo(){
   cliqueLongo(By.xpath("//*[@text='Clique Longo']"));

}
    public String obterTextoCampo() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
