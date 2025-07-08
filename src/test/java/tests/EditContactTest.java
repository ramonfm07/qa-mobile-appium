package tests;

import base.BaseTest;
import data.ContactData;
import data.ContactDataFactory;
import flows.ContactFlow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ContactDetailsPage;
import pages.ContactPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditContactTest extends BaseTest {

    @Test
    @DisplayName("Deve editar um contato com sucesso")
    public void deveEditarContatoComSucesso() {
        // 1. Criar contato inicial
        ContactData contatoOriginal = ContactDataFactory.gerarContatoValido();
        ContactFlow flow = new ContactFlow(driver);
        flow.criarContato(contatoOriginal);

        ContactDetailsPage detailsPage = new ContactDetailsPage(driver);
        assertTrue(detailsPage.isNomeVisivel(contatoOriginal.getNomeCompleto()));

        // 2. Clicar em Editar
        detailsPage.clicarEmEditarContato();

        // 3. Dados atualizados
        ContactData contatoEditado = new ContactData("NovoNome", "Editado", "11912345678", "editado@email.com");

        ContactPage contactPage = new ContactPage(driver);
        contactPage.inserirNome(contatoEditado.getNome());
        contactPage.inserirSobrenome(contatoEditado.getSobrenome());
        contactPage.inserirTelefone(contatoEditado.getTelefone());
        contactPage.inserirEmail(contatoEditado.getEmail());
        contactPage.clicarEmSalvar();

        // 4. Validar dados atualizados
        assertTrue(detailsPage.isNomeVisivel(contatoEditado.getNomeCompleto()));
        assertTrue(detailsPage.isTelefoneVisivel(contatoEditado.getTelefone()));
        assertTrue(detailsPage.isEmailVisivel(contatoEditado.getEmail()));
    }
}
