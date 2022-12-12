package appiumcurso.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static appiumcurso.DriverFactory.getDriver;

public class BasePage {

    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);

    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String texto) {
        clicar(By.xpath("//*[@text='" + texto + "']"));
        //getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
    }

    public void selecionarCombo(By by, String valor, String nome) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
        // getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='"+valor+"']")).click();
    }

    public boolean isCheckMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String texto) {
        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
        return elementos.size() > 0;
    }

    public String obterTituloAlerta() {
        return obterTexto(By.id("android:id/alertTitle"));

    }

    public String obterMensagemAlerta() {
        return obterTexto(By.id("android:id/message"));
    }

    public void tap(int x, int y) {
        AndroidTouchAction touch = new AndroidTouchAction(getDriver());
        touch.press(PointOption.point(x, y)).perform();

    }

    public void scrollDown() {
        scroll(0.1, 0.9);
    }

    public void scrollUp() {
        scroll(0.1, 0.9);
    }

    public void scroll(double v, double v1) {
    }

    public void swipeLeft() {
        scroll(0.1, 0.9);
    }

    public void swipeRight() {
        scroll(0.9, 0.1);
    }

    public void scroll(double inicio, double fim, int x) {
        Dimension size = getDriver().manage().window().getSize();

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        TouchAction dragNDrop = new TouchAction(getDriver())
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, end_y)).release();
        dragNDrop.perform();


        // atualizacao
        // new TouchAction<>(getDriver())
        //      .press(PointOption.point(new Point(x, start_y)))
        //     .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
        //    .moveTo(PointOption.point(new Point (x, end_y)))
        //    .release().perform();
        // atualizacao
    }

    public void swipe(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();
        int y = size.height / 2;
        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        TouchAction dragNDrop = new TouchAction(getDriver())
                .press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x, y)).release();
        dragNDrop.perform();

    }

    public void clicarSwipeList() {

        clicarPorTexto("Swipe List");

    }

    public void swipeElement(MobileElement element, double inicio, double fim) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);

        TouchAction dragNDrop = new TouchAction(getDriver())
                .press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x, y)).release();
        dragNDrop.perform();
    }

    public void clicarDragNDrop() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.
                presenceOfElementLocated
                        (By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Drag and drop ");

    }

    // atualizacao
    public void cliqueLongo(By by) {
        new TouchAction((PerformsTouchActions) getDriver().findElement(by)).perform();

    }

    // atualizado
    // public void cliqueLongo(By by) {
    //   new TouchAction<>(getDriver())
    //       .longPress(PointOption.point(getDriver().findElement(by).getCenter()))
    //      .perform();
}

