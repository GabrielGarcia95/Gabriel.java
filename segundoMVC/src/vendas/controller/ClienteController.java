package vendas.controller;

import java.util.Collection;
import java.util.HashMap;

import vendas.model.Cliente;

public class ClienteController {
	private HashMap<Integer, Cliente> clientes = new HashMap<>();
    
	public ClienteController() {
		//adicionando clientes para o código não iniciar vazio
		try {
			inserirCliente(new Cliente(369, "Gabriel", "123.123.123"));
			inserirCliente(new Cliente(370, "Cristiano", "987.654.321"));
			inserirCliente(new Cliente(371, "Daniel", "357.159.852"));
			inserirCliente(new Cliente(372, "Tiago", "789.654.123"));
			inserirCliente(new Cliente(373, "Rodolfo", "258.741.369"));
			inserirCliente(new Cliente(374, "Pablo", "963.258.741"));

			
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	//criando erro para caso o cliente cadastrado estiver repetindo o Id(codigo)
	public void inserirCliente(Cliente cliente) throws Exception {
		if (clientes.containsKey(cliente.getId())) {
			throw new Exception("Código já existe");
		}
		//criando erros para caso o cliente cadastrado estiver sem nome
		if (cliente.getNome().trim().equals("")) {
			throw new Exception("Não é possível inserir um cliente sem nome.");
		}
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
