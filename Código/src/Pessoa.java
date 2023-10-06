import java.sql.Date;

abstract class Pessoa {
    private String cpf;
    private String nome;
    private Date dataNasc;
    private String email;
    
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public Date getDataNasc() {
        return dataNasc;
    }
    public String getEmail() {
        return email;
    }
}
