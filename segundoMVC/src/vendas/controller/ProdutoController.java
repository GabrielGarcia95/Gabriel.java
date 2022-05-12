package vendas.controller;

import java.util.Collection;
import java.util.HashMap;

import vendas.model.Produto;

public class ProdutoController {
	private HashMap<Integer, Produto> produtos = new HashMap<>();
	
	public ProdutoController() {
		try {
        	inserirProduto(new Produto(900, "Televisão", 5500.50));
    		inserirProduto(new Produto(910, "Notebook", 3500.50));
    		inserirProduto(new Produto(920, "Celular", 2500.50));
    		inserirProduto(new Produto(930, "Caixa de Som", 299.99));
    		inserirProduto(new Produto(940, "Teclado", 219.99));
    		inserirProduto(new Produto(950, "Mouse", 199.99));
    		inserirProduto(new Produto(960, "MousePad", 50.00));
    		inserirProduto(new Produto(970, "Headset", 400.00));
			
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	public void inserirProduto(Produto produto) {
		produtos.put (produto.getId(), produto);
	}

	public void atualizarProduto(Produto produto) {
		produtos.replace (produto.getId(), produto);
	}

	public void excluirProduto(int id) {
		produtos.remove(id);
	}

	public Collection<Produto> listarProdutos() {
		return produtos.values();
	}

	public Produto carregarProduto(int id) {
		return produtos.get(id);
	}

}
