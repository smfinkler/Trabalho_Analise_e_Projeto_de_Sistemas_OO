
package Strategy;

public class Correios implements Entrega{
    int prazo;
    int valor;

    @Override
    public int calcularPrazo(String estado) {
        switch (estado) {
            case "RS":
            case "SC":
            case "PR":
                System.out.println("Região SUL");
                return 10;
            case "SP":
            case "MG":
            case "RJ":
            case "ES":
                System.out.println("Região Sudeste");
                return 12;
            case "MT":
            case "MS":
            case "GO":
            case "DF":
                System.out.println("Região Centro-oeste");
                return 13;
            case "BA":
            case "PI":
            case "MA":
            case "CE":
            case "RN":
            case "PB":
            case "PE":
            case "AL":
            case "SE":
                System.out.println("Região Nordeste");
                return 15;
            case "TO":
            case "PA":
            case "AP":
            case "RR":
            case "AM":
            case "AC":
            case "RO":
                System.out.println("Região Norte");
                return 16;
            default:
                break;
        }
        return 0;
    }
    
}
