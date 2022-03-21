/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author smfin
 */
public class PlacaMae implements Produto{
    double preco;
    String nome;
    String marca;
    String departamento;
    double peso_kg;

    public PlacaMae(double preco, String nome, String marca, String departamento, double peso_kg) {
        this.preco = preco;
        this.nome = nome;
        this.marca = marca;
        this.departamento = departamento;
        this.peso_kg = peso_kg;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getPeso_kg() {
        return peso_kg;
    }

    public void setPeso_kg(double peso_kg) {
        this.peso_kg = peso_kg;
    }
    
    @Override
    public void exibirInfo() {
        System.out.println("\nPlaca de vídeo "+nome +" criado com sucesso");
    }
    
    @Override
    public void exibirProduto() {
        System.out.println("\n"+marca+" - "+nome+ "- R$ "+preco);
    }
    
}
