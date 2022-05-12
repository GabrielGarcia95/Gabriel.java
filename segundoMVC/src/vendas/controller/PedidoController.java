package vendas.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import vendas.model.Pedido;

public class PedidoController {
	private HashMap<Integer, Pedido> pedidos = new HashMap<>();

	public List<Pedido> pedido;
	

	
	public void inserirPedido(Pedido pedido) {
		pedidos.put(pedido.getId(), pedido);
	}

	public void atualizarPedido(Pedido pedido) {
		pedidos.replace(pedido.getId(), pedido);
	}

	public void excluirPedido(int id) {
		pedidos.remove(id);
	}

	public Collection<Pedido> listarPedidos() {
		return pedidos.values();
	}

	public Pedido carregarPedido(int id) {
		return pedidos.get(id);
	}

}
