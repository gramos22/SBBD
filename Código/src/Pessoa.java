import java.time.LocalDate;

abstract class Pessoa {
    private String cpf;
    private String nome;
    private LocalDate dataNasc;
    private String email;
    
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public LocalDate getDataNasc() {
        return dataNasc;
    }
    public String getEmail() {
        return email;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
