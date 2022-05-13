package vendas.printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import vendas.UI.VendasAPP2;
import vendas.controller.ClienteController;
import vendas.controller.PedidoController;
import vendas.controller.ProdutoController;
import vendas.model.Cliente;
import vendas.model.Pedido;
import vendas.model.Produto;

public class MenuPrinter {

	public void executarPrinter(ClienteController controleC, ProdutoController controleP, PedidoController pedidoC)
			throws Exception {
		Scanner sc = VendasAPP2.getScanner();
		ProdutoPrinter produ = new ProdutoPrinter();
		ClientePrinter teste = new ClientePrinter();
		PedidoPrinter pediP = new PedidoPrinter();

		int x = 0;
		while (x != 4) {
			System.out.println();
			System.out.println("==========MENU PRINCIPAL==========");
			System.out.println("BEM VINDO, DIGITE O QUE DESEJA NO MENU");
			System.out.println("[1] - Cadastro\n[2] - Produtos\n[3] - Pedidos");
			System.out.println("[4] - Sair");
			x = sc.nextInt();

			switch (x) {
			case 1:
				int back = 0;
				while (back != 5) {
					System.out.println();
					System.out.println("Digite [1] para Cadastrar ou Editar um cliente."
							+ "\nDigite [2] para ver nossa lista de clientes" + "\nDigite [3] para atualizar cadastro"
							+ "\nDigite [4] para excluir um cliente\nDigite [5] Menu príncipal");
					back = sc.nextInt();
					sc.nextLine();
					switch (back) {
					case 1:
						controleC.inserirCliente(teste.capturarCliente(new Cliente()));
						//exemploNovoCliente();
						break;
					case 2:
						teste.exibirLista(controleC.listarClientes());
						break;
					case 3:
						System.out.print("Digite o Id do usuario que deseja editar:");
						int a = Integer.parseInt(sc.nextLine());
						Cliente cliente = controleC.carregarCliente(a);
						cliente = teste.capturarCliente(cliente);
						controleC.atualizarCliente(cliente);
						break;
					case 4:
						System.out.print("Digite o ID do cliente que queira excluir:");
						int excluir = sc.nextInt();
						controleC.excluirCliente(excluir);
						System.out.println("Cliente excluido com sucesso!");
						break;
					}

				}

				break;
			case 2:
				int p = 0;
				while (p != 5) {
					System.out.println();
					System.out.println(
							"Digite [1] Ver produtos\nDigite [2] Pesquiser um produto por Id \nDigite [3] Cadastrar ou editar um produto "
									+ "\nDigite [4] Excluir um produto \nDigite [5] Menu Príncipal.");
					p = sc.nextInt();
					sc.nextLine();
					switch (p) {
					case 1:
						produ.listarProdutos(controleP.listarProdutos());
						;
						break;
					case 2:
						System.out.print("Digite o id do produto que deseja visualizar: ");
						int i = sc.nextInt();
						produ.exibirProduto(controleP.carregarProduto(i));
					case 3:
						controleP.inserirProduto(produ.capturarProduto(new Produto()));
					case 4:
						System.out.print("Digite o ID do produto que queira excluir: ");
						int excluir = sc.nextInt();
						controleP.excluirProduto(excluir);
						System.out.print("Produto excluído com sucesso.");
					}

				}
			case 3:
				int backP = 0;
				while (backP != 5) {
					System.out.println();
					System.out.println("Digite [1] Realizar um pedido");
					backP = sc.nextInt();
					switch (backP) {
					case 1:
						System.out.println("Para fazer um pedido os adicione no carrinho");
						Pedido pedido = new Pedido();
						List<Produto> listarProduto = new ArrayList<>();
						System.out.println("Quantidade de itens que deseja adicionar no Carrinho de compras");
						int i = sc.nextInt();
						System.out.println("Você irá adicionar "+i+" iten(s), agora veja os itens disponíveis:");
						produ.listarProdutos(controleP.listarProdutos());
						System.out.print("Digite o id do item que deseja adicionar no carrinho - ");
						for (int t = 0; t < i; t++) {
							System.out.print("Id:");
							int carrinho = sc.nextInt();
							listarProduto.add(controleP.carregarProduto(carrinho));
						}
						System.out.print("Id do cliente: ");
						int idPedido = sc.nextInt();
						pedido.setCliente(controleC.carregarCliente(idPedido));
						pedido.setProdutos(listarProduto);
						pedido.somar();
						pedidoC.inserirPedido(pedido);
						pediP.exibirPedidos(pedidoC.listarPedidos());
						System.out.println();

					}
				}

			}

			System.out.println();
		}
		System.out.println("Fim do programa");
	}
	
	private void exemploNovoCliente() {
		ClienteController clienteController = new ClienteController();
		ClientePrinter clientePrinter = new ClientePrinter();
		boolean valido = false;
		while (!valido) {
			try {
				clienteController.inserirCliente(clientePrinter.capturarCliente(new Cliente()));
				valido = true;
			} catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
			}
		}
	}
}