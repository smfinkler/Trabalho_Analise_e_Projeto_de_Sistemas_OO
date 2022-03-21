
package Command;

public class Compra {
    private static int CONTADOR_ID;
    protected int idNotaFiscal;
    protected double valorTotal;
    protected double prazoEntrega;
    
    public Compra() {
        idNotaFiscal = ++CONTADOR_ID;
    }

    public void setValores(double valor, int prazoEntrega) {
        this.valorTotal = valor;
        this.prazoEntrega = prazoEntrega;
    }

    public String getInfoNota() {
        return new String("Nota fiscal nº: " + idNotaFiscal + "\nLoja: Samuel InfoStore" + "\nValor: " + valorTotal +"\nPrazo de entrega: "+prazoEntrega+" dias");
    }
}
