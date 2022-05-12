package vendas.printer;

import java.util.Collection;

import vendas.model.Produto;

public class ProdutoPrinter {
	public void listarProdutos(Collection<Produto> collection){
		System.out.println();
		System.out.println("======Produtos Dispon�veis======");
		for(Produto produto: collection)  {
			System.out.println("ID: "+produto.getId()+" Produto: "+ produto.getNome() +" | Pre�o: R$"+ produto.getPreco());
			
		}
		
	}
	public void exibirProduto(Produto produto) {
		System.out.println(produto);
	}
	

}
