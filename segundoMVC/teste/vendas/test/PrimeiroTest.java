package vendas.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendas.controller.db.ClienteControllerDB;
import vendas.controller.db.PedidoControllerDB;
import vendas.controller.db.ProdutoControllerDB;
import vendas.model.Cliente;
import vendas.model.Pedido;
import vendas.model.Produto;
import vendas.printer.ClientePrinter;
import vendas.printer.PedidoPrinter;
import vendas.printer.ProdutoPrinter;

public class PrimeiroTest {
//============ TESTES CLIENTES ===========//
	@DisplayName("Buscar cliente pelo ID")
	@Test
	void BuscarClienteID() throws Exception {
		ClienteControllerDB control = new ClienteControllerDB();
		control.getCliente(1);
		/**
		 * Classe para testar a busca de um cliente pelo ID
		 */
		
	}
	@DisplayName("Inserir um cliente manualmente")
	@Test
	void inserirCliente() throws Exception {
		ClienteControllerDB control = new ClienteControllerDB();
		Cliente cliente = new Cliente();
		cliente.setNome("Gustavo Nascimento");
		cliente.setCPF("456.456.982-00");
		cliente = control.insertClient(cliente);
		
		assertNotEquals(0, cliente.getId());
		/**
		 * Inserir um cliente
		 */
	}
	@DisplayName("Excluir cliente")
	@Test
	void excluirCliente() throws Exception {
		ClienteControllerDB control = new ClienteControllerDB();
		Cliente cliente = new Cliente();
		cliente.setId(21);
		control.deleteCliente(cliente);
	}
	
	@DisplayName("Exibir os clientes do banco")
	@Test
	void exibirListaClientes() throws Exception {
		ClienteControllerDB control = new ClienteControllerDB();
		ClientePrinter printer = new ClientePrinter();
		printer.exibirLista(control.listClients());
		/**
		 * Exibir uma lista de clientes do banco no console
		 */
	}
	@DisplayName("Editar um cliente")
	@Test
	void editClient () throws Exception {
		ClienteControllerDB control = new ClienteControllerDB();
		Cliente cliente = new Cliente();
		cliente.setId(22);  //ID
		cliente.setNome("Wesley Silva");
		cliente.setCPF("741.147.741");
		control.updateClient(cliente);
		assertNotEquals(0, cliente.getId());
		/**
		 * Editar um cliente já cadastrado, selecionando-o pelo ID
		 */
	}
//============TESTE PRODUTOS===============//
	@DisplayName("Exibir os produtos do banco no console")
	@Test
	void exibirListaProdutos() throws Exception {
		ProdutoControllerDB control = new ProdutoControllerDB();
		ProdutoPrinter printer = new ProdutoPrinter();
		printer.listarProdutos(control.listProduct());
		/**
		 * Exibir no console todos os produtos cadastrados no banco
		 */
	}
	@DisplayName("Editar/Atualizar um produto")
	@Test
	void editProduct() throws Exception {
		ProdutoControllerDB control = new ProdutoControllerDB();
		Produto produto = new Produto();
		produto.setId(5);//ID
		produto.setNome("SmartTV");
		produto.setPreco(4000.99);
		control.updateProduct(produto);
		
		assertNotEquals(0, produto.getId());
		/**
		 * Editar um produto já cadastrado no banco
		 * atualizando ele pelo ID
		 */
	}
	@DisplayName("Exibir um produto especifico pelo ID")
	@Test
	void exibirProduto() throws Exception {
		ProdutoControllerDB control = new ProdutoControllerDB();
		ProdutoPrinter printer = new ProdutoPrinter();
		printer.exibirProduto(control.getProduto(2));
		/*
		 * Exibir no console um produto pelo Id cadastrado no banco
		 */
	}
	@DisplayName("Cadastrar um novo produto")
	@Test
	void cadastrarProduto() throws Exception {
		ProdutoControllerDB control = new ProdutoControllerDB();
		Produto produto = new Produto();
		produto.setNome("Kit de pilhas");
		produto.setPreco(10.50);
		control.insertProduct(produto);
		assertNotEquals(0, produto.getId());
		/**
		 * Cadastrando um novo produto no banco de dados
		 * o id é gerado automaticamente pelo banco
		 */
	}
	@DisplayName("Excluir um produto")
	@Test
	void excluirProduto() throws Exception {
		ProdutoControllerDB control = new ProdutoControllerDB();
		Produto produto = new Produto();
		produto.setId(13);
		control.deleteProduct(produto);
		/**
		 * Excluindo produto pelo ID
		 */
		
	}
//==============PEDIDOS=============//	
	@DisplayName("Exibir Pedido")
	@Test
	void exibirPedido() throws Exception {
		PedidoControllerDB control = new PedidoControllerDB();
		PedidoPrinter printer = new PedidoPrinter();
		printer.exibePedido(control.buscarPedido(1));
		/**
		 * Buscar um pedido pelo ID
		 */
	}
	@DisplayName("Realizar um pedido")
	@Test
	void fazerPedido() throws Exception {
		PedidoControllerDB control = new PedidoControllerDB();
		ProdutoControllerDB controlProdu = new ProdutoControllerDB();
		Pedido pedido = new Pedido();
		ClienteControllerDB controlClie = new ClienteControllerDB();
		List<Produto> produto = new ArrayList<>();
		pedido.setDate(new Date(System.currentTimeMillis()));
		pedido.setCliente(controlClie.getCliente(8));
		produto.add(controlProdu.getProduto(5));
		produto.add(controlProdu.getProduto(8));
		pedido.setProdutos(produto);
		pedido.somar();
		control.inserirPedido(pedido);
		
	}
}
