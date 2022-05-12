package vendas.model;



public class Cliente {
	public Cliente(int id, String nome, String cPF) {
		super();
		this.id = id;
		this.nome = nome;
		CPF = cPF;
	}

	

	@Override
	public String toString() {
		return "Cliente ID: " + id + ", Nome: " + nome + ", CPF: " + CPF ;
	}

	private int id;

	private String nome;

	private String CPF;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

}
