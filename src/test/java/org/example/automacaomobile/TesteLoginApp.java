package org.example.automacaomobile;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TesteLoginApp {

    private static ScreenLogin ScreenLogin;
    private static AppiumDriver<RemoteWebElement> driver;

    public static String local= "";
    public static String plataform = "";

    @BeforeClass
    public static void caps() throws MalformedURLException{

        local = System.getProperty("local").toLowerCase();


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", new File("apps/app-debug.apk"));
        capabilities.setCapability("deviceName", "Emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("unicodeKeyboard", "true");
        driver = new AndroidDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        ScreenLogin = new ScreenLogin(driver);

    }

    @Test
    public void testeLogin() {
        ScreenLogin.logar();
    }
}
