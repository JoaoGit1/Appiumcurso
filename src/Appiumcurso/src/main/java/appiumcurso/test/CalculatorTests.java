package appiumcurso.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CalculatorTests {


    @Test
    public void DeveSomarDoisValores() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "QACURSO");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");


        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("plus");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_preview");
        System.out.println(el6.getText());

        driver.quit();
    }
}




//@After
// public void tearDown() {
// driver.quit();
//}

