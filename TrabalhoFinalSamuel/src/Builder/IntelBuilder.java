
package Builder;

public class IntelBuilder extends ComputadorBuilder{

    @Override
    public void buildPreco() {
        computador.preco = 5000;
    }

    @Override
    public void buildProcessador() {
        computador.processador = "Intel Core i5 11400";
    }

    @Override
    public void buildPlacaVideo() {
        computador.placa_video = "Nvidia GeForce RTX 3060";
    }

    @Override
    public void buildPlacaMae() {
        computador.placa_mae = "Gigabyte B560M Gaming HD";
    }

    @Override
    public void buildQtdMemoriaRAM() {
        computador.qtd_gb_ram = 16;
    }

    @Override
    public void buildQtdArmazenamento() {
        computador.qtd_gb_armazenamento = 1000;
    }
    
}
