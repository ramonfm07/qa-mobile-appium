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

    private final By botaoEditar = AppiumBy.id("com.google.android.contacts:id/menu_insert_or_edit");
    private final By botaoMenu = AppiumBy.accessibilityId("More options");
    private final By opcaoExcluir = AppiumBy.xpath("//android.widget.TextView[@text='Delete']");
    private final By botaoConfirmarExcluir = AppiumBy.id("android:id/button1");

    private WebElement getElementoComTexto(String textoEsperado) {
        String xpath = "//*[contains(@text,'" + textoEsperado + "')]";
        return driver.findElement(AppiumBy.xpath(xpath));
    }

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

    public void clicarEmEditarContato() {
        utils.clicar(botaoEditar);
    }

    public void clicarEmMenu() {
        utils.clicar(botaoMenu);
    }

    public void clicarEmExcluir() {
        utils.clicar(opcaoExcluir);
    }

    public void confirmarExclusao() {
        utils.clicar(botaoConfirmarExcluir);
    }

    public boolean isTextoVisivel(String textoEsperado) {
        By locator = AppiumBy.xpath("//*[contains(@text,'" + textoEsperado + "')]");
        return utils.estaVisivel(locator);
    }

}
