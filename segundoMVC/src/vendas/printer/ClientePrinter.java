package vendas.printer;

import java.util.Collection;
import java.util.Scanner;

import vendas.model.Cliente;

public class ClientePrinter {
	public void exibirLista(Collection<Cliente> collection) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("======Lista de Clientes=======");
		for(Cliente cliente : collection) {
		System.out.println("ID: "+cliente.getId()+" Nome: "+ cliente.getNome() +" | CPF: "+ cliente.getCPF());
		//System.out.println(clientes);
		//	exibirCliente(cliente);
		}
	}

	public void exibirCliente(Cliente cliente) {
		System.out.println();
		System.out.println("===== Cliente que mais gastou na loja ======");
		System.out.println(cliente);
		
		
		}
	

}
