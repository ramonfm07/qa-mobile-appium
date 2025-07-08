package data;

import com.github.javafaker.Faker;

public class ContactDataFactory {

    private static final Faker faker = new Faker();

    public static ContactData gerarContatoValido() {
        String nome = faker.name().firstName();
        String sobrenome = faker.name().lastName();
        String telefone = gerarTelefoneValido();
        String email = faker.internet().emailAddress();

        return new ContactData(nome, sobrenome, telefone, email);
    }

    public static ContactData gerarContatoSemNome() {
        String sobrenome = faker.name().lastName();
        String telefone = gerarTelefoneValido();
        String email = faker.internet().emailAddress();

        return new ContactData("", sobrenome, telefone, email);
    }

    public static ContactData gerarContatoComTelefoneCurto() {
        String nome = faker.name().firstName();
        String sobrenome = faker.name().lastName();
        String telefone = "123"; // telefone inválido
        String email = faker.internet().emailAddress();

        return new ContactData(nome, sobrenome, telefone, email);
    }

    private static String gerarTelefoneValido() {
        // Exemplo: 11 91234-5678
        String sufixo = String.valueOf(10000000 + faker.number().numberBetween(0, 89999999));
        return "119" + sufixo;
    }
}
