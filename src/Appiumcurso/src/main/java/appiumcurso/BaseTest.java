package appiumcurso;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;


public class BaseTest {

     @Rule
     public TestName testName = new TestName();
     @AfterClass
      public static void finalizaClasse() {
      DriverFactory.killDriver();
     }


    @After // org.junit
    public void tearsDown() {
        //    gerarScreenShot();
        DriverFactory.killDriver();
        // DriverFactory.getDriver().resetApp();
    }

    // public void gerarScreenShot() {
    //  try {
    //   File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
    //    FileUtils.copyFile(imagem, new File("target/screenshot/" + testName.getMethodName() + ".png"));//org.apachecommonsio
    //  } catch (IOException e) {
    //      e.printStackTrace();


// }

public void esperar(long tempo) {
    try {
      Thread.sleep(tempo);
  } catch (InterruptedException e) {
     throw new RuntimeException(e);
 }
}}
