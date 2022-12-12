package appiumcurso.test;

import appiumcurso.page.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import static appiumcurso.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void swipeElementLeft(String opcao) {
        swipeElement(getDriver()
                .findElement
                        (By.xpath("//*[text='" + opcao + "']/..")), 0.1, 0.9);
    }
    public void swipeElementRight(String opcao) {
        swipeElement(getDriver()
                .findElement
                        (By.xpath("//*[text='" + opcao + "']/..")), 0.9, 0.1);
    }
    public void clicarBotaoMais(){
        // atualizacao
     //  MobileElement botao = getDriver().findElement(By.xpath("//*[text=' (+)']/.."));
      // new TouchAction><(getDriver()).tap(TapOptions.tapOptions().withElement(
        //ElementOption.element(botao, -50,0))).perform();

        MobileElement botao = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));

        Point center1 = botao.getCenter();

        new TouchAction<>(getDriver()).tap(PointOption.point(center1.x - 50, center1.y)).perform();
    }
}
