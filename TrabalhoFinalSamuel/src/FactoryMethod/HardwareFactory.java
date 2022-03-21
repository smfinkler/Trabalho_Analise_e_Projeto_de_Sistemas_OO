
package FactoryMethod;

import java.util.Scanner;

public class HardwareFactory implements ProdutoFactory{

    @Override
    public Produto criarProduto() {
        Scanner e = new Scanner(System.in);
        int option=0;
        do{
            System.out.println("Informe o tipo de Hardware:");
            
            System.out.println("1-Processador");
            System.out.println("2-Placa de Vídeo");
            System.out.println("3-Placa Mãe");
            option = e.nextInt();
        }while(option<1||option>3);
        
        System.out.println("Informe o preço:");
        Double preco = e.nextDouble();
        System.out.println("Informe o nome");
        String nome = e.nextLine();
        nome = e.nextLine();
        System.out.println("Informe a marca");
        String marca = e.nextLine();
        System.out.println("Informe o peso(em Kg)");
        Double peso = e.nextDouble();
        
        switch (option) {
            case 1:
                return new Processador(preco, nome, marca, "Hardware", peso);
            case 2:
                return new PlacaVideo(preco, nome, marca, "Hardware", peso);
            default:
                return new PlacaMae(preco, nome, marca, "Hardware", peso);
        }
    }
    
}
