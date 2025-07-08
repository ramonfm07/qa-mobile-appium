package flows;

import data.ContactData;
import io.appium.java_client.AppiumDriver;
import pages.ContactPage;

public class ContactFlow {

    private final ContactPage contactPage;

    public ContactFlow(AppiumDriver driver) {
        this.contactPage = new ContactPage(driver);
    }
    //fluxo completo de adicionar um contato

    public void criarContato(ContactData contato) {
        contactPage.clicarEmAdicionarContato();
        contactPage.inserirNome(contato.getNome());
        contactPage.inserirSobrenome(contato.getSobrenome());
        contactPage.inserirTelefone(contato.getTelefone());
        contactPage.inserirEmail(contato.getEmail());
        contactPage.clicarEmSalvar();
    }
}
