package tests;

import base.BaseTest;
import data.ContactData;
import flows.ContactFlow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ContactDetailsPage;
import pages.ContactPage;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddContactNegativeTest extends BaseTest {

    @Test
    @DisplayName("Não deve permitir salvar contato sem preencher nenhum campo")
    public void naoDevePermitirSalvarContatoSemNome() {
        ContactPage contactPage = new ContactPage(driver);
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        Utils utils = new Utils(driver);

        contactPage.clicarEmAdicionarContato();
        contactPage.clicarEmSalvar();

        assertTrue(utils.existeTextoVisivel("Add info to save as a contact."));
    }

}
