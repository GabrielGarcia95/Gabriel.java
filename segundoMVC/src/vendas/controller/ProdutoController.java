package vendas.controller;

import java.util.Collection;
import java.util.HashMap;

import vendas.model.Produto;

public class ProdutoController {
	private HashMap<Integer, Produto> produtos = new HashMap<>();

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
