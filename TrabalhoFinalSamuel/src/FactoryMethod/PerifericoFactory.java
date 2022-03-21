
package FactoryMethod;

import java.util.Scanner;

public class PerifericoFactory implements ProdutoFactory{

    @Override
    public Produto criarProduto() {
        Scanner e = new Scanner(System.in);
        int option=0;
        do{
            System.out.println("Informe o tipo de periférico:");
            System.out.println("1-Mouse");
            System.out.println("2-Teclado");
            option = e.nextInt();
        }while(option<1||option>2);
        
        
        System.out.println("Informe o preço:");
        Double preco = e.nextDouble();
        System.out.println("Informe o nome");
        String nome = e.nextLine();
        nome = e.nextLine();
        System.out.println("Informe a marca");
        String marca = e.nextLine();
        System.out.println("Informe o peso(em Kg)");
        Double peso = e.nextDouble();
        
        if(option==1){
            return new Mouse(preco, nome, marca, "Periférico", peso);
        }else{
            return new Teclado(preco, nome, marca, "Periférico", peso);
        }
        
    }
    
}
