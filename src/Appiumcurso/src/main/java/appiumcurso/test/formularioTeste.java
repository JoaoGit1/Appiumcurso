package appiumcurso.test;

import appiumcurso.BaseTest;
import appiumcurso.page.FormularioPage;
import appiumcurso.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class formularioTeste extends BaseTest {
    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();
    public String nome;

    @Before

    public void inicializarAppium() {
        //SELECIONAR FORMULARIO

        menu.acessarformulario(nome);
        // dsl.clicarPorTexto("Formulário");
        // driver.findElement(By.xpath("//*[text='Formulário']")).click();
    }


    @Test


    public void DevePreencherCampoTexto() {
        // ESCREVER NOME

        page.escreverNome("joao");
        // dsl.escrever(MobileBy.AccessibilityId("nome"), "joao");
        // MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        //campoNome.sendKeys("joao");

        //CHECAR NOME ESCRITO
        assertEquals("joao", page.obterNome());
        // String text = campoNome.getText();
        //     Assert.assertEquals("joao", text);
        //  Assertions.assertEquals("joao", dsl.obterTexto(MobileBy.AccessibilityId("nome")));

    }

    @Test
    public void DeveInteragirCombo() {
        //SELECIONAR FORMULARIO
        //  driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
        //driver encontra elemento atraves do findElement e executa o click encadeado
        //                                              "class"           @atributo ='valor'

        // CLICAR NO COMBO
        // dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
        page.selecionarCombo("Nintendo Switch", nome);
        // driver.findElement(MobileBy.AccessibilityId("console")).click();

        //SELECIONAR OPÇÃO DESEJADA
        // driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
        // sempre que usar aspas dentro de aspas duplas usar aspas simples

        //VERIFICAR OPCAO SELECIONADA
        Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
        // String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        // String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
        //  assertEquals("Nintendo Switch", text);
        //    pegar elemento seguinte "abaixo usar /"

    }

//class[@att='value'] barra  colchetes arroba atributo igual aspas simples algum valor fecha barra  xpath
//@After
// public void tearDown() {
// driver.quit();
//}
    //  }
    //  }

    @Test
    public void DeveInteragirSwitchCheckBox() {

        //VERIFICAR STATUS DOS ELEMENTOS
        Assertions.assertFalse(page.isCheckMarcado());
        Assertions.assertTrue(page.isSwitchMarcado());
        // Assertions.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        //  Assertions.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
        //  Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox"))); igual do professor
        //  Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));igual do professor

        //assertEquals("false", check.getAttribute("checked"));
        //  assertEquals("true", switc.getAttribute("checked"));
        //CLICAR NOS ELEMENTOS
        page.clicarCheck(nome);
        page.clicarSwitch(nome);
        // dsl.clicar(By.className("android.widget.CheckBox"));
        //  dsl.clicar(MobileBy.AccessibilityId("switch"));
        // MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
        //  MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
        //  check.click();
        //  switc.click();
        //VERIFICAR STATUS ALTERADOS
        Assert.assertTrue(page.isCheckMarcado());
        Assert.assertFalse(page.isSwitchMarcado());

        //  Assertions.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        //  Assertions.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
        //   Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox"))); igual do professor
        //  Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch"))); igual do professor
        // Assertions.assertNotEquals("false", check.getAttribute("checked"));
        //  Assertions.assertNotEquals("true", switc.getAttribute("checked"));
    }

    @Test
    public void DeveRealizarCadastro() {

        //PREENCHER CAMPOS
        page.escreverNome("joao");
        page.clicarCheck(nome);
        page.clicarSwitch(nome);
        page.selecionarCombo("Nintendo Switch", nome);
        // dsl.escrever(By.className("android.widget.EditText"), "joao");
        // dsl.clicar(By.className("android.widget.CheckBox"));
        // dsl.clicar(By.className("android.widget.Switch"));
        // dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");
        //  driver.findElement(By.className("android.widget.EditText")).sendKeys("joao");
        // driver.findElement(By.className("android.widget.CheckBox")).click();
        // driver.findElement(By.className("android.widget.Switch")).click();
        // driver.findElement(By.className("android.widget.Spinner")).click();
        // driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //SALVAR
        page.salvar();
        // dsl.clicarPorTexto("SALVAR");

        //driver.findElement(By.xpath("//*[text='SALVAR']")).click();

        //VERIFICAÇOES
        Assert.assertEquals("Nome: joao", page.obterNomeCadastrado());
        Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
        Assert.assertTrue(page.obterCheckCadastrado().endsWith("Off"));
        Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));

        //  assertEquals("Nome: joao", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: joao']")));
        //  assertEquals("Console: switch", dsl.obterTexto(By.xpath("android.widget.TextView[starts-with(@text, 'Console:')]")));
        //   Assertions.assertTrue(dsl.obterTexto(By.xpath("android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Marcado"));
        //   Assertions.assertTrue(dsl.obterTexto(By.xpath("android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));

// igual do professor
        // Assert.assertEquals("Nome: joao", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: joao']")));
        //  Assert.assertEquals("Console: switch", dsl.obterTexto(By.xpath("android.widget.TextView[starts-with(@text, 'Console:')]")));
        //  Assert.assertTrue(dsl.obterTexto(By.xpath("android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Marcado"));
        //   Assert.assertTrue(dsl.obterTexto(By.xpath("android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));
// igual do professor


        // MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: joao']"));
        // assertEquals("Nome: joao", nome.getText());
        // Assertions.assertEquals("Nome: joao", nome.getText());

        // MobileElement combo = driver.findElement(By.xpath("android.widget.TextView[starts-with(@text, 'Console:')]"));
        // Assertions.assertEquals("Console: switch", combo.getText());

        //  MobileElement swit = driver.findElement(By.xpath("android.widget.TextView[starts-with(@text, 'Switch:')]"));
        // assertTrue(swit.getText().endsWith("Off"));

        //   MobileElement check = driver.findElement(By.xpath("android.widget.TextView[starts-with(@text, 'CheckBox:')]"));
        //  assertTrue(check.getText().endsWith("Marcado"));

    }

    @Test
    public void DeveRealizarCadastroDemorado() {
        page.escreverNome("joao");

        //   DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        page.salvarDemorado(nome);
        //esperar(3000);
        //  WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
//  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]")));

        //  Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));
        //AssertEquals("Nome: Wagner", page.obterNomeCadastrado());
    }

    @Test
    public void devAlternateData() {
        page.clicarPorTexto("01/01/2000");
        page.clicarPorTexto("20");
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));

    }

    @Test
    public void deveAlternarHora() {
        page.clicarPorTexto("06:00");
        page.clicar(MobileBy.AccessibilityId("10"));
        page.clicar(MobileBy.AccessibilityId("40"));
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("10:40"));
    }

    @Test
    public void deveInteragirComSeekBar() {
        // clicar no seekbar
        page.clicarSeekBar(0.05);

        //salvar
        page.salvar();
        // obter o valor
    }
}






