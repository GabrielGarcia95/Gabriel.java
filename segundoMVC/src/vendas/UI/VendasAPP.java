package vendas.UI;

import vendas.printer.ClientePrinter;
import vendas.printer.PedidoPrinter;
import vendas.printer.ProdutoPrinter;

import java.util.ArrayList;
import java.util.List;

import vendas.controller.ClienteController;
import vendas.controller.PedidoController;
import vendas.controller.ProdutoController;
import vendas.model.Cliente;
import vendas.model.Pedido;
import vendas.model.Produto;

public class VendasAPP {
	public static void main(String[] args) {

		ClienteController controlador = new ClienteController();
		ClientePrinter printer = new ClientePrinter();

		controlador.inserirCliente(new Cliente(369, "Gabriel", "123.123.123"));
		controlador.inserirCliente(new Cliente(370, "Cristiano", "987.654.321"));
		controlador.inserirCliente(new Cliente(371, "Daniel", "357.159.852"));
		controlador.inserirCliente(new Cliente(372, "Tiago", "789.654.123"));
		controlador.inserirCliente(new Cliente(373, "Rodolfo", "258.741.369"));
		controlador.inserirCliente(new Cliente(374, "Pablo", "963.258.741"));

		// excluir cliente
		// controlador.excluirCliente(374);
		// editar cliente
		Cliente cliente = controlador.carregarCliente(369);
		cliente.setNome("Gabriel Andrade");
		controlador.atualizarCliente(cliente);
		Cliente cliente1 = controlador.carregarCliente(374);
		cliente1.setCPF("963.852.744");
		controlador.atualizarCliente(cliente1);

		printer.exibirLista(controlador.listarClientes());
		printer.exibirCliente(controlador.carregarCliente(371));

		ProdutoController controProdu = new ProdutoController();
		ProdutoPrinter printerProdu = new ProdutoPrinter();

		controProdu.inserirProduto(new Produto(900, "Televisão", 5500.50));
		controProdu.inserirProduto(new Produto(910, "Notebook", 3500.50));
		controProdu.inserirProduto(new Produto(920, "Celular", 2500.50));
		controProdu.inserirProduto(new Produto(930, "Caixa de Som", 299.99));
		controProdu.inserirProduto(new Produto(940, "Teclado", 219.99));
		controProdu.inserirProduto(new Produto(950, "Mouse", 199.99));
		controProdu.inserirProduto(new Produto(960, "MousePad", 50.00));
		controProdu.inserirProduto(new Produto(970, "Headset", 400.00));

		printerProdu.listarProdutos(controProdu.listarProdutos());

		PedidoController controPedido = new PedidoController();
		PedidoPrinter printerPedido = new PedidoPrinter();

		Pedido pedido = new Pedido();
		List<Produto> listaProduto = new ArrayList<>();
		listaProduto.add(controProdu.carregarProduto(910));
		listaProduto.add(controProdu.carregarProduto(970));
		listaProduto.add(controProdu.carregarProduto(950));
		pedido.setId(456123);
		pedido.setCliente(controlador.carregarCliente(372));
		pedido.setProdutos(listaProduto);
		pedido.somar();
		
		controPedido.inserirPedido(pedido);
//		controPedido.inserirPedido(listaProduto);
		
		printerPedido.exibirPedidos(controPedido.listarPedidos());
		
		// Pedido pedido2 = new Pedido(0, null, cliente1, 0, listaProduto)
		// pedido.getProdutos().add(controProdu.carregarProduto(900));
		// controPedido.inserirPedido(new Pedido(controProdu.carregarProduto(900)));
		// controPedido.listarPedidos();


	}

}
