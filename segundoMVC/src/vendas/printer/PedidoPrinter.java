package vendas.printer;

import java.util.Collection;

import vendas.model.Pedido;

public class PedidoPrinter {
	public void exibirPedidos(Collection<Pedido> pedidos) {
		System.out.println();
		System.out.println("==========PEDIDOS==========");
		for (Pedido pedido : pedidos) {
			System.out.println("ID do pedido: " + pedido.getId() + " | " + pedido.getId()+ " | " + pedido.getDate());
			for (Pedido produto : pedidos) {
				System.out.println(produto.getProdutos());
			}
			System.out.println(pedido.getPrecoTotal());
		}

	}

	public void exibePedido(Pedido pedido) {
		System.out.println(pedido);
	}

	// public void exibePedido(Pedido pedido) {
//		System.out.println("id Cliente: "+pedido.getId()+ " | data do pedido: "+pedido.getDate()+" | preço total: "+pedido.getPrecoTotal());
//		Produto[] produto = null;
//		for ( Produto produto1 : produto) {
//			System.out.println(produto1);
//		}}



}
