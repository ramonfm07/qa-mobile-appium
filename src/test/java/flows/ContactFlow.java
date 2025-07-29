package flows;

import data.ContactData;
import io.appium.java_client.AppiumDriver;
import pages.ContactPage;
import utils.Utils;

public class ContactFlow {

    private final ContactPage contactPage;
    private final Utils utils;

    public ContactFlow(AppiumDriver driver) {
        this.contactPage = new ContactPage(driver);
        this.utils = new Utils(driver);
    }
    //fluxo completo de adicionar um contato

    public void criarContato(ContactData contato) {
        contactPage.clicarEmAdicionarContato();
        contactPage.inserirNome(contato.getNome());
        contactPage.inserirSobrenome(contato.getSobrenome());
        contactPage.inserirTelefone(contato.getTelefone());
        utils.scrollParaBaixo();
        contactPage.inserirEmail(contato.getEmail());
        contactPage.clicarEmSalvar();
    }
}
