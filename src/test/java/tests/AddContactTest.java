package tests;

import base.BaseTest;
import data.ContactData;
import data.ContactDataFactory;
import flows.ContactFlow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ContactPage;
import pages.ContactDetailsPage;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddContactTest extends BaseTest {

    @Test
    @DisplayName("Deve adicionar um novo contato com sucesso")
    public void deveAdicionarNovoContatoComSucesso() {
        ContactData contato = new ContactData(
                "Ramon", "QA", "11999999999", "ramon.qa@email.com"
        );

        ContactFlow flow = new ContactFlow(driver);
        flow.criarContato(contato);

        ContactDetailsPage details = new ContactDetailsPage(driver);
        assertTrue(details.isNomeVisivel(contato.getNomeCompleto()));
        assertTrue(details.isTelefoneVisivel(contato.getTelefone()));
        assertTrue(details.isEmailVisivel(contato.getEmail()));
    }

    // com gerador usando faker
    @Test
    @DisplayName("Deve adicionar um novo contato (faker) com sucesso")
    public void deveAdicionarNovoContatoFakerComSucesso() {
        ContactData contato = ContactDataFactory.gerarContatoValido();

        ContactFlow flow = new ContactFlow(driver);
        flow.criarContato(contato);

        ContactDetailsPage details = new ContactDetailsPage(driver);
        assertTrue(details.isNomeVisivel(contato.getNomeCompleto()));
        assertTrue(details.isTelefoneVisivel(contato.getTelefone()));
        assertTrue(details.isEmailVisivel(contato.getEmail()));
    }

    @Test
    @DisplayName("Deve adicionar múltiplos contatos com sucesso")
    public void deveAdicionarMultiplosContatosComSucesso() {
        List<ContactData> contatos = Arrays.asList(
                new ContactData("Ramon", "QA", "11999999999", "ramon.qa@email.com"),
                new ContactData("Lucas", "Dev", "11988887777", "lucas.dev@email.com"),
                new ContactData("Ana", "Teste", "11977776666", "ana.teste@email.com")
        );

        for (ContactData contato : contatos) {
            ContactFlow flow = new ContactFlow(driver);
            flow.criarContato(contato);

            ContactDetailsPage details = new ContactDetailsPage(driver);
            assertTrue(details.isNomeVisivel(contato.getNomeCompleto()));
            assertTrue(details.isTelefoneVisivel(contato.getTelefone()));
            assertTrue(details.isEmailVisivel(contato.getEmail()));

            driver.navigate().back();
        }
    }
}
