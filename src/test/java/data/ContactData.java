package data;

public class ContactData {
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;

    public ContactData(String nome, String sobrenome, String telefone, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }
}
