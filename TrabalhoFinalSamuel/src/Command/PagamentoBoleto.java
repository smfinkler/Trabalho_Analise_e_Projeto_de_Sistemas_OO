
package Command;

public class PagamentoBoleto implements PagamentoCommand{

    @Override
    public void processarCompra(Compra compra) {
        System.out.println("Boleto gerado!\n" + compra.getInfoNota());
    }
    
}
