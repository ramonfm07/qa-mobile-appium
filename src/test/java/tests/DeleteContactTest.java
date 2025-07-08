package tests;

import base.BaseTest;
import data.ContactData;
import data.ContactDataFactory;
import flows.ContactFlow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ContactDetailsPage;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DeleteContactTest extends BaseTest {

    @Test
    @DisplayName("Deve excluir um contato com sucesso")
    public void deveExcluirContatoComSucesso() {
        // 1. Criar o contato
        ContactData contato = ContactDataFactory.gerarContatoValido();
        ContactFlow flow = new ContactFlow(driver);
        flow.criarContato(contato);

        // 2. Validar que o contato foi salvo
        ContactDetailsPage details = new ContactDetailsPage(driver);
        details.isNomeVisivel(contato.getNomeCompleto());

        // 3. Excluir o contato
        details.clicarEmMenu();
        details.clicarEmExcluir();
        details.confirmarExclusao();

        // 4. Verificar se o contato sumiu
        assertFalse(details.isTextoVisivel(contato.getNomeCompleto()));
    }
}
