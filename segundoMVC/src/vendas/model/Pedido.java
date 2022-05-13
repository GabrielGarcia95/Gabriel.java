package vendas.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private int id;

	private Date date;

	private Cliente cliente;

	private List<Produto> produtos = new ArrayList<>();

	private List<Produto> somaPedidos;

	private double precoTotal;

	public void somar() {
		precoTotal = 0;
		for (Produto produto : produtos) {
			precoTotal += produto.getPreco();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getSomaPedidos() {
		return somaPedidos;
	}

	public void setSomaPedidos(List<Produto> somaPedidos) {
		this.somaPedidos = somaPedidos;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

}
