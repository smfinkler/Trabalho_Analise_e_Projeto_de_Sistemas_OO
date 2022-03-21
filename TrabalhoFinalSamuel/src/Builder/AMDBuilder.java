
package Builder;

public class AMDBuilder extends ComputadorBuilder{

    @Override
    public void buildPreco() {
        computador.preco = 6000;
    }

    @Override
    public void buildProcessador() {
        computador.processador = "Ryzen 5 5600X";
    }

    @Override
    public void buildPlacaVideo() {
        computador.placa_video = "AMD Radeon RX 6600XT";
    }

    @Override
    public void buildPlacaMae() {
        computador.placa_mae = "MSI MAG B550 Tomahawk";
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
