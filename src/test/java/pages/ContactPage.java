package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPage {

    private AppiumDriver driver;

    public ContactPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Locators (ajuste de acordo com seu app ou inspecionador do Appium)
    private By nomeInput = AppiumBy.xpath("//android.widget.EditText[contains(@text, 'First')]");
    private By sobrenomeInput = AppiumBy.xpath("//android.widget.EditText[contains(@text, 'Last')]");
    private By telefoneInput = AppiumBy.xpath("//android.widget.EditText[contains(@text, 'Phone')]");
    private By emailInput = AppiumBy.xpath("//android.widget.EditText[contains(@text, 'Email')]");
    private By salvarButton = AppiumBy.id("com.google.android.contacts:id/toolbar_button");
    private By contatoNome = AppiumBy.id("com.google.android.contacts:id/large_title");
    private By botaoAdicionarContato = AppiumBy.id("com.google.android.contacts:id/floating_action_button");


    // Ações
    public void inserirNome(String nome) {
        driver.findElement(nomeInput).sendKeys(nome);
    }

    public void inserirSobrenome(String sobrenome) {
        driver.findElement(sobrenomeInput).sendKeys(sobrenome);
    }

    public void inserirTelefone(String telefone) {
        driver.findElement(telefoneInput).sendKeys(telefone);
    }

    public void inserirEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clicarEmSalvar() {
        driver.findElement(salvarButton).click();
    }

    public String getNomeNaTela() {
        return driver.findElement(contatoNome).getText();
    }

    public void verificarSeContatoFoiSalvo(String nomeEsperado) {
        String nomeExibido = getNomeNaTela();
        assertTrue(nomeExibido.contains(nomeEsperado), "Contato não foi salvo corretamente!");
    }

    public void clicarEmAdicionarContato() {
        driver.findElement(botaoAdicionarContato).click();
    }
}
