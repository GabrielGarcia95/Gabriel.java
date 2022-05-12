package vendas.controller;

import java.util.Collection;
import java.util.HashMap;

import vendas.model.Cliente;

public class ClienteController {
	private HashMap<Integer, Cliente> clientes = new HashMap<>();

	public void inserirCliente(Cliente cliente) {
		clientes.put(cliente.getId(), cliente);
	}

	public void atualizarCliente(Cliente cliente) {
		clientes.replace(cliente.getId(), cliente);
	}

	public void excluirCliente(int id) {
		clientes.remove(id);
	}

	public Collection<Cliente> listarClientes() {
		return clientes.values();
	}

	public Cliente carregarCliente(int id) {
		return clientes.get(id);
	}

}
