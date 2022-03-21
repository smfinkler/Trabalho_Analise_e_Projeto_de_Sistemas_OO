
package Builder;

public class ComputadorProduct {
    public double preco;
    public String processador;
    public String placa_video;
    public String placa_mae;
    public int qtd_gb_ram;
    public int qtd_gb_armazenamento;
    
    public void imprimirComputador(){
        System.out.println("Computador: \nProcessador: " + this.processador + "\nPlaca de vídeo: " + this.placa_video
        + "\nPlaca mãe: " + this.placa_mae + "\nMemória RAM: "
        + this.qtd_gb_ram + "GB" + "\nArmazenamento: " + this.qtd_gb_armazenamento + "GB" +"\nValor: " + this.preco);
    }

    public double getPreco() {
        return preco;
    }
       
}
