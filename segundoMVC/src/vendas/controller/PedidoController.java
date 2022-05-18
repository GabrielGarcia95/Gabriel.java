package vendas.controller;

import java.util.Collection; 
import java.util.HashMap;

import vendas.model.Pedido;

public class PedidoController {
	private HashMap<Integer, Pedido> pedidos = new HashMap<>();

//	public Collection<Pedido> pedido;

	public void inserirPedido(Pedido pedido) {
		pedidos.put(pedido.getId(), pedido);
	}

	public void atualizarPedido(Pedido pedido) {
		pedidos.replace(pedido.getId(), pedido);
	}

	public void excluirPedido(int id) {
		pedidos.remove(id);
	}

	public Collection<Pedido> listarPedidos() throws Exception {
		// throw new Exception("Lista de pedidos vazia");
		return pedidos.values();
	}

	public Pedido carregarPedido(int id) {
		return pedidos.get(id);
	}

}
