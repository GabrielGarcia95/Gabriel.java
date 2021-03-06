package vendas.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private int id;

	private Date date;

	private Cliente cliente;

	private List<Produto> produtos = new ArrayList<>();

	private double precoTotal;

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", date=" + date + ", cliente=" + cliente + 
				", produtos=" + produtos
				+ ", precoTotal=" + precoTotal + "]";
	}

	//M?todo para somar os pedidos utilizando um "for" mais pratico
	//declarando o valor da variavel em '0' e adicionando valor(produto.getPreco()) conforme 
	//o for se repete
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

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public int getId(List<Produto> listarProduto) {
		return id;
		
	}



}
