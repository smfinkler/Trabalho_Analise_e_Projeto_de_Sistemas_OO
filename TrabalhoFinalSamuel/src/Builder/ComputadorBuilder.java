
package Builder;

public abstract class ComputadorBuilder {
    protected ComputadorProduct computador = new ComputadorProduct();
    public abstract void buildPreco();
    public abstract void buildProcessador();
    public abstract void buildPlacaVideo();
    public abstract void buildPlacaMae();
    public abstract void buildQtdMemoriaRAM();
    public abstract void buildQtdArmazenamento();
    public ComputadorProduct getComputador(){
        return computador;
    };
}
