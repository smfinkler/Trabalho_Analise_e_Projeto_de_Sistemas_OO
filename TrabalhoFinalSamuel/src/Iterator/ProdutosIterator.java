
package Iterator;

import FactoryMethod.Produto;
import java.util.ArrayList;

public class ProdutosIterator implements Iterator{
    ArrayList<Produto> listaProdutos = new ArrayList();
    int posicao = 0;
    
    public ProdutosIterator(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
	
    public Object next() {
        Produto produto = listaProdutos.get(posicao);
        posicao++;
        return produto;
    }
	
    public boolean hasNext() {
        if (posicao >= listaProdutos.size() || listaProdutos.get(posicao) == null) {
            return false;
	} else {
            return true;
	}
    }
    
}
