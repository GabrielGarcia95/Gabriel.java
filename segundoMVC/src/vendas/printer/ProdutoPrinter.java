package vendas.printer;

import java.util.Collection; 
import java.util.Scanner;

import vendas.UI.VendasAPP2;
import vendas.model.Produto;


public class ProdutoPrinter {
	public Produto capturarProduto(Produto produto) {
		//m�todo para ver se o produto j� existe
		boolean isNew = produto.isNew();
		
		Scanner sc = VendasAPP2.getScanner();
		
		if(!isNew) {
			System.out.println("Alterando ID do produto: "+produto.getId());
		}
		else {
			System.out.println("Inserindo um novo Produto.");
		}
		if(isNew) {
			System.out.print("Informe o ID: ");
			produto.setId(sc.nextInt());
			sc.nextLine();
		}
		System.out.print("Informe o nome do produto: ");
		if(!isNew) {
			System.out.print("[Produto anterior: "+produto.getNome()+"] Novo produto: ");
		}
		String nome = sc.nextLine();
		if(isNew || (!isNew && !nome.trim().isEmpty())){
			produto.setNome(nome);
		}
		if(!isNew) {
			System.out.println("Pre�o anterior: " + produto.getPreco());
		}
		System.out.print("Informe o pre�o: ");
		produto.setPreco(sc.nextDouble());
		System.out.println("Confirmando novas altera��es, Produto: "+produto.getNome()+", pre�o: R$" +produto.getPreco());
		
		return produto;
		
	}
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
