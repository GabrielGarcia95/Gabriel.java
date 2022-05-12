package vendas.UI;

import vendas.printer.ClientePrinter;
import vendas.printer.MenuPrinter;
import vendas.printer.PedidoPrinter;
import vendas.printer.ProdutoPrinter;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import vendas.controller.ClienteController;
import vendas.controller.PedidoController;
import vendas.controller.ProdutoController;
import vendas.model.Cliente;
import vendas.model.Pedido;
import vendas.model.Produto;

public class VendasAPP2 {
	private static Scanner scanner = new Scanner(System.in);

	public static Scanner getScanner() {
		return scanner;
	}

	public static void main(String[] args) throws Exception {
		
		ClienteController controlador = new ClienteController();
		MenuPrinter menuP = new MenuPrinter();
		
		
		
		menuP.executarPrinter(controlador);
//		ClientePrinter printer = new ClientePrinter();
//		
//		try {
//			controlador.inserirCliente(printer.capturarCliente(new Cliente()));
//			
//		} catch (Exception e) {
//			System.err.println(e.getLocalizedMessage());
//			
//		}
		//*exibir lista (teste)
//		Collection<Cliente> collection = controlador.listarClientes();
//		printer.exibirLista(collection);
//		System.out.println("Total de clientes: collection.size()+" clientes.");
		
		// alterar clientes já cadastrados
//		try {
//			controlador.atualizarCliente(printer.capturarCliente(controlador.carregarCliente(372)));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println(e.getLocalizedMessage());
//		}
		
		
		//listar os clientes
//		collection = controlador.listarClientes();
//		printer.exibirLista(collection);
//		System.out.println("Clientes: "+collection.size()+" .");
//		
		// excluir cliente
		// controlador.excluirCliente(374);
		// editar cliente
//		Cliente cliente = controlador.carregarCliente(369);
//		cliente.setNome("Gabriel Andrade");
//		controlador.atualizarCliente(cliente);
//		Cliente cliente1 = controlador.carregarCliente(374);
//		cliente1.setCPF("963.852.744");
//		controlador.atualizarCliente(cliente1);
//
		//printer.exibirLista(controlador.listarClientes());
		//printer.exibirCliente(controlador.carregarCliente(371));

//		ProdutoController controProdu = new ProdutoController();
//		ProdutoPrinter printerProdu = new ProdutoPrinter();
//        
//		
//
//		printerProdu.listarProdutos(controProdu.listarProdutos());

//	    PedidoController controPedido = new PedidoController();
//		PedidoPrinter printerPedido = new PedidoPrinter();

//		Pedido pedido = new Pedido();
//		List<Produto> listaProduto = new ArrayList<>();
//		listaProduto.add(controProdu.carregarProduto(910));
//		listaProduto.add(controProdu.carregarProduto(970));
//		listaProduto.add(controProdu.carregarProduto(950));
//		pedido.setId(456123);
//		pedido.setCliente(controlador.carregarCliente(372));
//		pedido.setProdutos(listaProduto);
//		pedido.somar();
//		
		//controPedido.inserirPedido(pedido);
//		controPedido.inserirPedido(listaProduto);
		
		//printerPedido.exibirPedidos(controPedido.listarPedidos());
		
	}

}
