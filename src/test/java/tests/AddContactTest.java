package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.ContactPage;
import pages.ContactDetailsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddContactTest extends BaseTest {

    @Test
    public void deveAdicionarNovoContatoComSucesso() {

        // Dados do contato
        String nome = "Ramon";
        String sobrenome = "Machado";
        String nomeCompleto = nome + " " + sobrenome;
        String telefone = "11999999999";
        String email = "ramon@email.com";

        // Instancia e preenche o contato
        ContactPage contactPage = new ContactPage(driver);
        contactPage.clicarEmAdicionarContato();
        contactPage.inserirNome(nome);
        contactPage.inserirSobrenome(sobrenome);
        contactPage.inserirTelefone(telefone);
        contactPage.inserirEmail(email);
        contactPage.clicarEmSalvar();

        // Validação 1: via ContactPage
        contactPage.verificarSeContatoFoiSalvo(nomeCompleto);

        // Validação 2: via ContactDetailsPage (usando XPath dinâmico)
        ContactDetailsPage detailsPage = new ContactDetailsPage(driver);
        assertTrue(detailsPage.isNomeVisivel(nomeCompleto), "Nome não visível");
        assertTrue(detailsPage.isTelefoneVisivel(telefone), "Telefone não visível");
        assertTrue(detailsPage.isEmailVisivel(email), "Email não visível");
    }
}
