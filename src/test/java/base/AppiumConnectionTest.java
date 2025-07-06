package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumConnectionTest {

    protected static AndroidDriver driver;

    public static void main(String[] args) {
        try {
          //  DesiredCapabilities caps = new DesiredCapabilities();
            UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformName("Android");
            options.setDeviceName("emulator-5554");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.google.android.contacts");
            options.setAppActivity("com.android.contacts.activities.PeopleActivity");
            options.setNoReset(true);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

            System.out.println("✅ Conexão com Appium criada com sucesso!");
            driver.quit();
        } catch (Exception e) {
            System.err.println("❌ Erro ao conectar com Appium:");
            e.printStackTrace();
        }
    }
}
