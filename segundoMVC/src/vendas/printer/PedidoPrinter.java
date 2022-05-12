package vendas.printer;

import java.util.Collection;

import vendas.model.Pedido;

public class PedidoPrinter {
	public void exibirPedidos(Collection<Pedido> pedidos) {
		System.out.println();
		System.out.println("==========PEDIDOS==========");
		for (Pedido pedido : pedidos) {
			System.out.println("ID do pedido: "+pedido.getId()+" | "+pedido.getCliente());
			for (Pedido produto : pedidos) {
				System.out.println(produto.getProdutos());
			}
			System.out.println(pedido.getPrecoTotal());
			}
		

	}

}
