package vendas.controller;

public enum OpcaoSistema {
	INSERIR(1),
	ATUALIZAR(2),
	EXCLUIR(3);
	
	private int press;
	
	private OpcaoSistema(int press) {
		this.press = press;
	}

	public int getInserir() {
		return press;
	}
	
}
