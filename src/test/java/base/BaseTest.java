package base;

import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType; <--- contante somente io.appium 8.x
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected AndroidDriver driver;


    @BeforeEach
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(ConfigReader.get("platformName"));
        options.setDeviceName(ConfigReader.get("deviceName"));
        options.setAutomationName(ConfigReader.get("automationName"));
        options.setAppPackage(ConfigReader.get("appPackage"));
        options.setAppActivity(ConfigReader.get("appActivity"));
        options.setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        try {
            driver.terminateApp("com.google.android.contacts");
            Thread.sleep(1000); // tempo para encerrar
            driver.activateApp("com.google.android.contacts");
            Thread.sleep(1000); // tempo para carregar
        } catch (Exception e) {
            System.out.println("Erro ao reiniciar app: " + e.getMessage());
        }

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
                driver.quit();
            }
        }
    }
