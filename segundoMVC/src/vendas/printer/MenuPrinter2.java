package vendas.printer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vendas.UI.VendasAPP2;
import vendas.controller.ClienteController;
import vendas.controller.PedidoController;
import vendas.controller.ProdutoController;
import vendas.controller.db.ClienteControllerDB;
import vendas.controller.db.PedidoControllerDB;
import vendas.controller.db.ProdutoControllerDB;
import vendas.model.Cliente;
import vendas.model.Pedido;
import vendas.model.Produto;

//Sistema de menu usando switchs
//e também usando métodos para deixar o código um pouco mais "limpo"

public class MenuPrinter2 {
	Scanner sc = VendasAPP2.getScanner();
	ProdutoPrinter produ = new ProdutoPrinter();
	ClientePrinter clie = new ClientePrinter();
	PedidoPrinter pediP = new PedidoPrinter();
	ClienteControllerDB controCDB = new ClienteControllerDB();
	ProdutoControllerDB controPDB = new ProdutoControllerDB();
	PedidoControllerDB controPed = new PedidoControllerDB();

	public void executarPrinter(ClienteController controleC, ProdutoController controleP, PedidoController pedidoC)
			throws Exception {

		int x = 0;
		// Usando while para executar a opção desejada e voltar para o menu
		while (x != 4) {
			System.out.println();
			System.out.println("==========MENU PRINCIPAL==========");
			System.out.println("BEM VINDO, DIGITE O QUE DESEJA NO MENU");
			System.out.println("[1] - Cadastro\n[2] - Produtos\n[3] - Pedidos");
			System.out.println("[4] - Sair");
			System.out.print("MENU: ");
			x = sc.nextInt();

			// uma espécie de "switch pai", para servir de menu príncipal
			switch (x) {
			// case do "switch pai"
			case 1:
				int back = 0;
				// while para se manter no menu de cadastro
				while (back != 5) {
					System.out.println();
					System.out.println("Digite [1] para Cadastrar um cliente."
							+ "\nDigite [2] para ver nossa lista de clientes" + "\nDigite [3] para atualizar cadastro"
							+ "\nDigite [4] para excluir um cliente\nDigite [5] Menu príncipal");
					back = sc.nextInt();
					sc.nextLine();
					// menu de cadastro
					switch (back) {
					// utilizando métodos para deixar mais limpo
					case 1:
						inserirNovoCliente(controleC);
						break;
					case 2:
						exibirListaClientes(controleC);
						break;
					case 3:
						editarCliente(controleC);
						break;
					case 4:
						excluirCliente(controleC);
						break;
					}

				}

				break;
			// case do "switch pai"
			case 2:
				int p = 0;
				// while para se manter no menu de produtos
				while (p != 5) {
					System.out.println();
					System.out.println(
							"Digite [1] Ver produtos\nDigite [2] Pesquiser um produto por Id \nDigite [3] Cadastrar ou editar um produto "
									+ "\nDigite [4] Excluir um produto \nDigite [5] Menu Príncipal\nDigite [6] Editar um produto.");
					p = sc.nextInt();
					sc.nextLine();
					// menu de produtos
					switch (p) {
					case 1:
						listarProduto(controleP);
						break;
					case 2:
						exibirProduto(controleP);
						break;
					case 3:
						inserirProduto(controleP);
						break;
					case 4:
						excluirProduto(controleP);
						break;
					case 6:
						editarProduto(controleP);
						break;

					}

				}
				// case do "switch pai"
			case 3:
				int backP = 0;
				// while para se manter no menu de pedidos
				while (backP != 5) {
					System.out.println();
					System.out.println(
							"Digite [1] Realizar um pedido\nDigite [2] Ver pedido(s)\nDigite [3] Buscar um pedido\nDigite [4] Excluir Pedido\nDigite [5] Menu Príncipal");
					backP = sc.nextInt();
					// menu de pedidos
					switch (backP) {
					case 1:
						fazerPedido(controleC, controleP, pedidoC);
						break;
					case 2:
						listarPedidos(pedidoC);
						break;
					case 3:
						exibirPedido(pedidoC);
						break;
					case 4:
						deletePedido(controPed);
						break;

					}
				}

			}

			System.out.println();
		}
		System.out.println("Fim do programa");
	}

	// métodos aonde acontece tudo
	private void inserirNovoCliente(ClienteController controleC) {

		// usando while com 'try catch' para inserir um cliente com mensagem de erro
		// para caso o cliente for cadastrado sem nome
		// o while é para voltar ao ínicio para caso o cliente for inserido sem nome e
		// disparar um erro
		boolean valido = false;
		while (!valido) {
			try {
				// controleC.inserirCliente(clie.capturarCliente(new Cliente()));
				controCDB.insertClient(clie.capturarCliente(new Cliente()));
				valido = true;
			} catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
			}
		}
	}

	public void exibirListaClientes(ClienteController controleC) throws Exception {
		clie.exibirLista(controCDB.listClients());
	}

	public void exibirClientesDB(List<Cliente> list) {
		for (Cliente cliente : list) {
			exibeCliente(cliente);
		}
	}

	public void editarCliente(ClienteController controleC) {
		// usando while com 'try catch' para editar um cliente com mensagem de erro para
		// caso o cliente editado estiver sem nome
		// o while é para voltar ao ínicio para caso o cliente inserido estiver sem nome
		// e então
		// disparar um erro
		boolean valido = false;
		while (!valido) {
			try {
				System.out.print("Digite o Id do usuario que deseja editar:");
				int a = Integer.parseInt(sc.nextLine());
				Cliente cliente = controCDB.getCliente(a);
				cliente = clie.capturarCliente(cliente);
				controCDB.updateClient(cliente);
			} catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
			}
		}

	}

	public void exibeCliente(Cliente cliente) {
		System.out.println(cliente);
	}

	public void excluirCliente(ClienteController controleC) throws Exception {
		System.out.print("Digite o ID do cliente que queira excluir:");
		int excluir = sc.nextInt();
//		controleC.excluirCliente(excluir);
		Cliente x = controCDB.getCliente(excluir);
		controCDB.deleteCliente(x);
		System.out.println("Cliente excluido com sucesso!");

	}

	public void listarProduto(ProdutoController controleP) throws Exception {
		// produ.listarProdutos(controleP.listarProdutos());
		produ.listarProdutos(controPDB.listProduct());

	}
//	public void listarProdutosDB(List<Produto> list) {
//		for(Produto produto : list) {
//			exibirProdutoDB(produto);
//		}
//	}

//	public void exibirProdutoDB(Produto produto) {
//		System.out.println(produto);
//	}
	public void editarProduto(ProdutoController controleP) throws Exception {

		try {
			System.out.print("Digite o Id do Produto que deseja editar:");
			int a = Integer.parseInt(sc.nextLine());
			Produto produto = controPDB.getProduto(a);
			produto = produ.capturarProduto(produto);
			controPDB.updateProduct(produto);
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	public void exibirProduto(ProdutoController controleP) throws Exception {
		System.out.print("Digite o id do produto que deseja visualizar: ");
		int i = sc.nextInt();
		produ.exibirProduto(controPDB.getProduto(i));
	}

	public void inserirProduto(ProdutoController controleP) throws Exception {
		controPDB.insertProduct(produ.capturarProduto(new Produto()));
		// controleP.inserirProduto(produ.capturarProduto(new Produto()));

	}

	public void excluirProduto(ProdutoController controleP) throws Exception {
		System.out.print("Digite o ID do produto que queira excluir: ");
		int excluir = sc.nextInt();
		Produto pr = controPDB.getProduto(excluir);
		controPDB.deleteProduct(pr);
		System.out.print("Produto excluído com sucesso.");
	}
	public void exibirPedido(PedidoController pedidoC) throws Exception{
		System.out.println("Digite o id do pedido que queira buscar");
		int idp = sc.nextInt();
		controPed.buscarPedido(idp);
		//pediP.exibePedido(controPed.buscarPedido(idp));
	}

//	public void fazerPedido(ClienteController controleC, ProdutoController controleP, PedidoController pedidoC)
//			// Anotando pedido utilizando todas as classes
//			// Criando um novo representando (listarProduto) para a ArrayList<produto>
//			throws Exception {
//		System.out.println("Para fazer um pedido os adicione no carrinho");
//		Pedido pedido = new Pedido();
//		List<Produto> listarProduto = new ArrayList<>();
//		System.out.println("Quantidade de itens que deseja adicionar no Carrinho de compras");
//		int i = sc.nextInt();
//		System.out.println("Você irá adicionar " + i + " iten(s), agora veja os itens disponíveis:");
//		produ.listarProdutos(controleP.listarProdutos());
//		System.out.print("Digite o id do item que deseja adicionar no carrinho - ");
//		// utilizando o for para caso o pedido haver mais de 1 item, ele se repete até
//		// que seja acrescentado o número índicado de itens
//		for (int t = 0; t < i; t++) {
//			System.out.print("Id:");
//			int carrinho = sc.nextInt();
//			listarProduto.add(controleP.carregarProduto(carrinho));
//		}
//		// finalizando o pedido
//		System.out.print("Id do cliente: ");
//		int idPedido = sc.nextInt();
//		pedido.setCliente(controleC.carregarCliente(idPedido));
//		pedido.setProdutos(listarProduto);
//		pedido.somar();
//		pedidoC.inserirPedido(pedido);
//		pediP.exibirPedidos(pedidoC.listarPedidos());
//		System.out.println();
//	}

	public void fazerPedido(ClienteController controleC, ProdutoController controleP, PedidoController pedidoC)
			// Anotando pedido utilizando todas as classes
			// Criando um novo representando (listarProduto) para a ArrayList<produto>
			throws Exception {
		System.out.println("Para fazer um pedido os adicione no carrinho");
		Pedido pedido = new Pedido();
		List<Produto> listarProduto = new ArrayList<>();
		System.out.println("Quantidade de itens que deseja adicionar no Carrinho de compras");
		int i = sc.nextInt();
		System.out.println("Você irá adicionar " + i + " iten(s), agora veja os itens disponíveis:");
		produ.listarProdutos(controPDB.listProduct());
		System.out.print("Digite o id do item que deseja adicionar no carrinho - ");
// utilizando o for para caso o pedido haver mais de 1 item, ele se repete até
// que seja acrescentado o número índicado de itens
		for (int t = 0; t < i; t++) {
			System.out.print("Id:");
			int carrinho = sc.nextInt();
			listarProduto.add(controPDB.getProduto(carrinho));
				}
// finalizando o pedido
		System.out.print("Id do cliente: ");
		int idcliente = sc.nextInt();
		pedido.setCliente(controCDB.getCliente(idcliente));
		pedido.setProdutos(listarProduto);
		pedido.setDate(new Date(System.currentTimeMillis()));
		pedido.somar();
		controPed.inserirPedido(pedido);
		System.out.println();
	}

	public void listarPedidos(PedidoController pedidoC) throws Exception {
		controPed.listarPedidos();

	}
	public void deletePedido(PedidoControllerDB pedidoC) throws Exception{
		System.out.print("Digite o ID do pedido que queira excluir:");
		int excluir = sc.nextInt();
		Pedido x = controPed.buscarPedido(excluir);
		controPed.excluirPedido(x);
		System.out.println("Pedido excluido com sucesso!");
	}
}