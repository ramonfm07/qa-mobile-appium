package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

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

    // Espera o elemento desaparecer

    public void esperarDesaparecer(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
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

    // Obtém texto visível do elemento
    public String obterTexto(By locator) {
        esperarElementoVisivel(locator);
        return driver.findElement(locator).getText();
    }

    public boolean estaVisivel(By locator) {
        try {
            esperarElementoVisivel(locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Rola de cima para baixo

    public void scrollParaBaixo() {
        int largura = driver.manage().window().getSize().width;
        int altura = driver.manage().window().getSize().height;

        int meioX = largura / 2;
        int inicioY = (int) (altura * 0.8);
        int fimY = (int) (altura * 0.2);

        realizarScroll(meioX, inicioY, meioX, fimY);
    }

    // Rola de baixo para cima

    public void scrollParaCima() {
        int largura = driver.manage().window().getSize().width;
        int altura = driver.manage().window().getSize().height;

        int meioX = largura / 2;
        int inicioY = (int) (altura * 0.2);
        int fimY = (int) (altura * 0.8);

        realizarScroll(meioX, inicioY, meioX, fimY);
    }

    private void realizarScroll(int startX, int startY, int endX, int endY) {
        PointerInput dedo = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(dedo, 1);

        swipe.addAction(dedo.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(dedo.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(dedo.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(dedo.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

    // Rola até o texto visível na tela (Android)

    public void scrollParaTexto(String textoVisivel) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + textoVisivel + "\"))"
        ));
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

    public boolean existeTextoVisivel(String textoEsperado) {
        try {
            By locator = AppiumBy.xpath("//*[contains(@text, '" + textoEsperado + "')]");
            esperarElementoVisivel(locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
