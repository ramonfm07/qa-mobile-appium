package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class ContactDetailsPage {

    private AppiumDriver driver;
    private Utils utils;

    public ContactDetailsPage(AppiumDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    // Gera XPath dinamicamente com o texto esperado
    private By getTextoVisivel(String texto) {
        return AppiumBy.xpath(String.format("//android.widget.TextView[@text='%s']", texto));
    }

    public boolean isNomeVisivel(String nomeEsperado) {
        return utils.estaVisivel(getTextoVisivel(nomeEsperado));
    }

    public boolean isTelefoneVisivel(String telefoneEsperado) {
        return utils.estaVisivel(getTextoVisivel(telefoneEsperado));
    }

    public boolean isEmailVisivel(String emailEsperado) {
        return utils.estaVisivel(getTextoVisivel(emailEsperado));
    }
}
