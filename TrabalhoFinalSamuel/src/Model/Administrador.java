
package Model;

public class Administrador {
    String codigo;
    String nome;
    String senha;
    String email;

    public Administrador(String codigo, String nome, String senha, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
