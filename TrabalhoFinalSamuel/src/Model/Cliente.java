
package Model;

public class Cliente {
    String cpf;
    String nome;
    String senha;
    String estado;
    String CEP;
    String email;

    public Cliente(String cpf, String nome, String senha, String estado, String CEP, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.estado = estado;
        this.CEP = CEP;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
