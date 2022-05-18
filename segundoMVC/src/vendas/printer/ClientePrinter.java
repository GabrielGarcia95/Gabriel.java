package vendas.printer;

import java.util.Collection;
import java.util.Scanner;

import vendas.UI.VendasAPP2;
import vendas.model.Cliente;

public class ClientePrinter {
	public Cliente capturarCliente(Cliente cliente) {
		//monitora se o cliente � novo
		boolean isNew = cliente.isNew();

		Scanner sc = VendasAPP2.getScanner();

		//m�todo para ver se o cliente � novo
		if (!isNew) {
			System.out.println("Alterando Id do cliente: " + cliente.getId());
		} else { //se n�o for novo ele insere um novo cliente
			System.out.println("Inserindo um novo cliente: ");
		}
		System.out.println();

//		if (isNew) {//continua monitorando se � novo ou n�o
//			System.out.print("Informe o Id: ");
//			cliente.setId(sc.nextInt());
//			sc.nextLine();
//		}
		System.out.print("Informe o nome: ");
		

		if (!isNew) {
			System.out.print("[Nome anterior: " + cliente.getNome() + "] Novo nome : ");
		}
		String nome = sc.nextLine();
		if (isNew || (!isNew && !nome.trim().equals(""))) {
			cliente.setNome(nome);
		}
		
		if (!isNew) {
			System.out.print("[CPF anterior: " + cliente.getCPF()+"] -");
		}
		System.out.print("Informe o CPF: ");
		cliente.setCPF(sc.nextLine());
		System.out.println();

		return cliente;
	}

	public void exibirLista(Collection<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			exibirCliente(cliente);
		}

	}

	public void exibirCliente(Cliente cliente) {
		System.out.println(cliente);
	}

}
