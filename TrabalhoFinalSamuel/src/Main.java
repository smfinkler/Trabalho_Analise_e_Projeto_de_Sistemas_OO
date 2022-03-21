


import Builder.AMDBuilder;
import Builder.ComputadorProduct;
import Builder.Director;
import Builder.IntelBuilder;
import Command.Compra;
import Command.PagamentoBoleto;
import Command.PagamentoCartaoCredito;
import Command.PagamentoCartaoDebito;
import Command.PagamentoCommand;
import FactoryMethod.HardwareFactory;
import FactoryMethod.Mouse;
import FactoryMethod.PerifericoFactory;
import FactoryMethod.PlacaMae;
import FactoryMethod.PlacaVideo;
import FactoryMethod.Processador;
import FactoryMethod.Produto;
import FactoryMethod.ProdutoFactory;
import FactoryMethod.Teclado;
import Iterator.Iterator;
import Iterator.ProdutosIterator;
import Model.Administrador;
import Model.Cliente;
import Strategy.Correios;
import Strategy.Entrega;
import Strategy.Transportadora;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Cliente clienteLogado = null;
    
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in); 
        
        ArrayList<Cliente> listaClientes = new ArrayList();
        ArrayList<Administrador> listaAdmins = new ArrayList();
        ArrayList<Produto> listaProdutos = new ArrayList(); 
        
        //Builder de PC
        Director montador;
        ComputadorProduct computador;
        
        //factory de produto
        ProdutoFactory factory;
        Produto product;

        //administradores pré-cadastrados
        listaAdmins.add(new Administrador("1", "Samuel", "123456", "admin@ecommerce.com"));
        listaAdmins.add(new Administrador("2", "Finkler", "654321", "admin2@ecommerce.com"));
        
        //clientes pré-cadastrados
        listaClientes.add(new Cliente("11111111111", "Samuel Finkler", "111111", "RS", "95800000", "smfinkler@gmail.com"));
        listaClientes.add(new Cliente("22222222222", "Fulano da Silva", "222222", "SC", "95800000", "fulano@gmail.com"));
        listaClientes.add(new Cliente("33333333333", "Ciclano dos Santos", "333333", "SP", "95800000", "ciclano@gmail.com"));
                
        //produtos pré-cadastrados
        listaProdutos.add(new Processador(1000, "Core i9", "Intel", "Hardware", 1));
        listaProdutos.add(new Processador(1800, "Ryzen 5 5600X", "AMD", "Hardware", 0.450));
        listaProdutos.add(new Processador(2500, "Ryzen 7 5800X", "AMD", "Hardware", 0.247));
        listaProdutos.add(new Processador(3260, "Ryzen 9 5900X", "AMD", "Hardware", 0.247));       
        listaProdutos.add(new Processador(7500, "Core i9 12900K", "Intel", "Hardware", 0.465));
        listaProdutos.add(new Processador(2650, "Core i7 11700K", "Intel", "Hardware", 0.450));
        listaProdutos.add(new Processador(1400, "Core i5 11400", "AMD", "Hardware", 0.320));
        listaProdutos.add(new Teclado(1000, "K95 RGB Platinum", "Corsair", "Periféricos", 2.615));
        listaProdutos.add(new Teclado(650, "Alloy Elite 2 RGB", "Hyperx", "Periféricos", 1.885));
        listaProdutos.add(new Mouse(280, "Deathadder V2 Chroma", "Razer", "Periféricos", 0.316));
        listaProdutos.add(new PlacaMae(1300, "MAG B550 Tomahawk", "MSI", "Hardware", 1.910));
        listaProdutos.add(new PlacaVideo(4300, "Placa de Vídeo Asus Dual RX 6600 XT O8G", "Asus", "Hardware", 1.550));
               
        
        int option=0, option2, option3;
        String login="";
        String senha;
        int formaPagamento, prazoEntrega;
        int acesso =  0;
        
        do{
            do{
                System.out.println("\nMENU:");
                System.out.println("1-Login Usuário:");
                System.out.println("2-Login ADMIN:");
                System.out.println("3-Sair:");
                option = e.nextInt();
            }while(option<1 || option>3);

            if(option==1){
                System.out.println("Informe seu CPF:");
                login = e.nextLine();
                login = e.nextLine();
                System.out.println("Informe sua senha:");
                senha = e.nextLine();
                acesso = validarAcessoCliente(login, senha, listaClientes); 
            }else if(option==2){
                System.out.println("Informe seu código:");
                login = e.nextLine();
                login = e.nextLine();
                System.out.println("Informe sua senha:");
                senha = e.nextLine();
                acesso = validarAcessoAdmin(login, senha, listaAdmins); 
            }

            if(acesso==1){
                System.out.println("\nMENU CLIENTE:");
                System.out.println("1-Comprar PC montado Intel");
                System.out.println("2-Comprar PC montado AMD");
                System.out.println("3-Comprar outro produto");
                System.out.println("4-Sair");
                option2 = e.nextInt();
                switch (option2) {
                    case 1:
                        montador = new Director(new IntelBuilder());
                        montador.montarComputador();
                        computador = montador.getComputador();
                        computador.imprimirComputador();
                        formaPagamento = escolherFormaPagamento();
                        prazoEntrega = escolherFormaEntrega();
                        executarCompra(computador.getPreco(), formaPagamento, prazoEntrega);
                        break;
                    case 2:
                        montador = new Director(new AMDBuilder());
                        montador.montarComputador();
                        computador = montador.getComputador();
                        computador.imprimirComputador();
                        formaPagamento = escolherFormaPagamento();
                        prazoEntrega = escolherFormaEntrega();
                        executarCompra(computador.getPreco(), formaPagamento, prazoEntrega);
                        break;
                    case 3:
                        int cont=1;
                        Iterator produtosIterator = new ProdutosIterator(listaProdutos);
                        System.out.println("PRODUTOS");
                        while (produtosIterator.hasNext()) {
                            Produto produto = (Produto)produtosIterator.next();
                            System.out.print(cont);
                            produto.exibirProduto();
                            cont++;
                        }   System.out.println("\nInforme o número do produto que deseja comprar:");
                        int numProdutoCompra = e.nextInt();
                        Produto produto = listaProdutos.get(numProdutoCompra-1);
                        produto.exibirProduto();
                        formaPagamento = escolherFormaPagamento();
                        prazoEntrega = escolherFormaEntrega();
                        executarCompra(produto.getPreco(), formaPagamento, prazoEntrega);
                        break;
                    default:
                        break;               
                }
            }else if(acesso==2){
                System.out.println("MENU ADMIN:");
                System.out.println("1-Cadastrar novo produto");
                System.out.println("2-Sair");
                option2 = e.nextInt();
                if(option2==1){
                    do{
                       System.out.println("1-Hardware");
                        System.out.println("2-Periférico");
                        System.out.println("3-Cancelar");
                        option3 = e.nextInt(); 
                    }while(option3 <1 || option3>3);                
                    if(option3==1){
                        factory = new HardwareFactory();
                        product = factory.criarProduto();
                        listaProdutos.add(product);
                        product.exibirInfo();
                        System.out.println();
                    }else{
                        factory = new PerifericoFactory();
                        product = factory.criarProduto();
                        listaProdutos.add(product);
                        product.exibirInfo();
                        System.out.println();
                    }
                }
            } 
        }while(option!=3);               
    }
    
    public static int validarAcessoCliente(String login, String senha, ArrayList<Cliente> listaClientes){
        for(int i=0; i<listaClientes.size(); i++){
            if(listaClientes.get(i).getCpf().equals(login) && listaClientes.get(i).getSenha().equals(senha)){
                clienteLogado = listaClientes.get(i);
                System.out.println("Validado com sucesso");
                return 1;
            }
        }
        System.out.println("CPF ou senha incorretos");
        return 0;  
    }
    
    public static int validarAcessoAdmin(String login, String senha, ArrayList<Administrador> listaAdmins){
        for(int i=0; i<listaAdmins.size(); i++){
            if(listaAdmins.get(i).getCodigo().equals(login) && listaAdmins.get(i).getSenha().equals(senha)){
                System.out.println("Validado com sucesso");
                return 2;
            }
        }
        System.out.println("Código ou senha incorretos");
        return 0;  
    } 
    
    public static int escolherFormaPagamento(){
        Scanner e = new Scanner(System.in);
        int formaPagamento=0;
        do{
            System.out.println("\nESCOLHA A FORMA DE PAGAMENTO:");
            System.out.println("1- Cartão de crédito");
            System.out.println("2- Cartão de débito");
            System.out.println("3- Boleto bancário");
            formaPagamento = e.nextInt();
        }while(formaPagamento<1 || formaPagamento>3);
        return formaPagamento;        
    }
    
    public static int escolherFormaEntrega(){
        Scanner e = new Scanner(System.in);
        Entrega entrega = null;
        int formaEntrega=0;
        do{
            System.out.println("\nESCOLHA A FORMA DE ENTREGA:");
            System.out.println("1- Correios");
            System.out.println("2- Transportadora");
            formaEntrega = e.nextInt();
        }while(formaEntrega<1 || formaEntrega>2);
        
        if(formaEntrega==1){
            entrega = new Correios();
            System.out.println("Entrega será realizada pelos correios");
        }else{
            entrega = new Transportadora();
            System.out.println("Entrega será realizada por transportadora");
        }
        return entrega.calcularPrazo(clienteLogado.getEstado());        
    }
    
    public static void executarCompra(double valor, int opPagamento, int prazoEntrega){
        Compra compra = new Compra();
	compra.setValores(valor, prazoEntrega);
        PagamentoCommand formaDePagamento;
        switch (opPagamento) {
            case 1:
                formaDePagamento = new PagamentoCartaoCredito();
                break;
            case 2:
                formaDePagamento = new PagamentoCartaoDebito();
                break;
            default:
                formaDePagamento = new PagamentoBoleto();
                break;
        }
	formaDePagamento.processarCompra(compra);
    }
    
}
