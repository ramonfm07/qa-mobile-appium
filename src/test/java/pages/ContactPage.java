package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utils.Utils;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPage {

    private AppiumDriver driver;
    private final Utils utils;

    public ContactPage(AppiumDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    private By nomeInput = AppiumBy.xpath("//android.widget.EditText[contains(@hint, 'First')]");
    private By sobrenomeInput = AppiumBy.xpath("//android.widget.EditText[contains(@hint, 'Last')]");
    private By telefoneInput = AppiumBy.xpath("//android.widget.EditText[contains(@hint, 'Phone')]");
    private By emailInput = AppiumBy.xpath("//android.widget.EditText[contains(@hint, 'Email')]");
    private By salvarButton = AppiumBy.id("com.google.android.contacts:id/toolbar_button");
    private By contatoNome = AppiumBy.id("com.google.android.contacts:id/large_title");
    private By botaoAdicionarContato = AppiumBy.id("com.google.android.contacts:id/floating_action_button");

    public void inserirNome(String nome) {
        utils.preencherCampo(nomeInput, nome);
    }

    public void inserirSobrenome(String sobrenome) {
        utils.preencherCampo(sobrenomeInput, sobrenome);
    }

    public void inserirTelefone(String telefone) {
        utils.preencherCampo(telefoneInput, telefone);
    }

    public void inserirEmail(String email) {
        utils.preencherCampo(emailInput, email);
    }

    public void clicarEmSalvar() {
        utils.clicar(salvarButton);
    }

    public String getNomeNaTela() {
        return utils.obterTexto(contatoNome);
    }

    public void verificarSeContatoFoiSalvo(String nomeEsperado) {
        String nomeExibido = getNomeNaTela();
        assertTrue(nomeExibido.contains(nomeEsperado), "Contato não foi salvo corretamente!");
    }

    public boolean isContatoVisivel(String nomeEsperado) {
        return getNomeNaTela().contains(nomeEsperado);
    }

    public void clicarEmAdicionarContato() {
        utils.clicar(botaoAdicionarContato);
    }

    public boolean isBotaoSalvarHabilitado() {
        return driver.findElement(salvarButton).isEnabled();
    }


}
