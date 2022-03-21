
package Builder;

public class Director {
    protected ComputadorBuilder montador;
	 
    public Director(ComputadorBuilder montador) {
        this.montador = montador;
    }
 
    public void montarComputador() {
        montador.buildPreco();
        montador.buildProcessador();
        montador.buildPlacaVideo();
        montador.buildPlacaMae();
        montador.buildQtdMemoriaRAM();
        montador.buildQtdArmazenamento();
    }
 
    public ComputadorProduct getComputador() {
        return montador.getComputador();
    }
}
