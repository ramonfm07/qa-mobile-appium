package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public Utils(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // tempo de espera padrão
    }

    // -------- WAITs --------

    public void esperarElementoVisivel(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void esperarElementoClicavel(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // -------- AÇÕES --------

    public void clicar(By locator) {
        esperarElementoClicavel(locator);
        driver.findElement(locator).click();
    }

    public void preencherCampo(By locator, String texto) {
        esperarElementoVisivel(locator);
        driver.findElement(locator).sendKeys(texto);
    }

    public boolean estaVisivel(By locator) {
        try {
            esperarElementoVisivel(locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // -------- VERIFICAÇÃO DINÂMICA POR TEXTO (útil para validação final) --------

    public boolean validarTextoVisivel(String textoEsperado) {
        String xpath = String.format("//android.widget.TextView[@text='%s']", textoEsperado);
        return estaVisivel(AppiumBy.xpath(xpath));
    }

    // -------- UTILITÁRIO EXTRA --------

    public WebElement obterElemento(By locator) {
        esperarElementoVisivel(locator);
        return driver.findElement(locator);
    }

}
