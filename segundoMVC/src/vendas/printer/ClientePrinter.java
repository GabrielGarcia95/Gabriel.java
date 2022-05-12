package vendas.printer;

import java.util.Collection;
import java.util.Scanner;

import vendas.UI.VendasAPP2;
import vendas.model.Cliente;

public class ClientePrinter {
	public Cliente capturarCliente(Cliente cliente) {
		boolean isNew = cliente.isNew();

		Scanner sc = VendasAPP2.getScanner();

		if (!isNew) {
			System.out.println("Alterando Id do cliente: " + cliente.getId());
		} else {
			System.out.println("Inserindo um novo cliente: ");
		}
		System.out.println();

		if (isNew) {
			System.out.print("Informe o Id: ");
			cliente.setId(sc.nextInt());
			sc.nextLine();
		}
		System.out.print("Informe o nome: ");
		String nome = sc.nextLine();

		if (!isNew) {
			System.out.print("[Nome anterior: " + cliente.getNome() + "]");
		}
		if (isNew || (!isNew && !nome.trim().equals(""))) {
			cliente.setNome(nome);
		}
		System.out.print("Informe o CPF: ");
		if (!isNew) {
			System.out.print("CPF anterior: " + cliente.getCPF());
		}
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
