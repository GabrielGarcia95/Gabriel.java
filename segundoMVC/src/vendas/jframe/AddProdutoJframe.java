package vendas.jframe;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import vendas.controller.db.ProdutoControllerDB;
import vendas.model.Produto;

public class AddProdutoJframe extends JFrame {
	private TextField txtNomeProduto;
	private TextField txtValorProduto;
	private JButton btnAdicionar;
	ProdutoControllerDB produtoC = new ProdutoControllerDB();
	private ListaProdutoJFrame listar;

	public void adicionarProduto() throws Exception {
		Produto produto = new Produto();
		produto.setNome(txtNomeProduto.getText());
		double x = Double.parseDouble(txtValorProduto.getText());
		produto.setPreco(x);
		produtoC.insertProduct(produto);
		setVisible(false);
		listar.listarProdutos();
	}

	public AddProdutoJframe() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 326, 122);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNomeProduto = new JLabel("Nome");
		GridBagConstraints gbc_lblNomeProduto = new GridBagConstraints();
		gbc_lblNomeProduto.anchor = GridBagConstraints.EAST;
		gbc_lblNomeProduto.gridwidth = 2;
		gbc_lblNomeProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeProduto.gridx = 0;
		gbc_lblNomeProduto.gridy = 0;
		getContentPane().add(lblNomeProduto, gbc_lblNomeProduto);

		txtNomeProduto = new TextField();
		GridBagConstraints gbc_txtNomeProduto = new GridBagConstraints();
		gbc_txtNomeProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeProduto.gridwidth = 9;
		gbc_txtNomeProduto.insets = new Insets(0, 0, 5, 0);
		gbc_txtNomeProduto.gridx = 2;
		gbc_txtNomeProduto.gridy = 0;
		getContentPane().add(txtNomeProduto, gbc_txtNomeProduto);

		JLabel lblValorProduto = new JLabel("Valor R$");
		GridBagConstraints gbc_lblValorProduto = new GridBagConstraints();
		gbc_lblValorProduto.anchor = GridBagConstraints.EAST;
		gbc_lblValorProduto.gridwidth = 2;
		gbc_lblValorProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorProduto.gridx = 0;
		gbc_lblValorProduto.gridy = 1;
		getContentPane().add(lblValorProduto, gbc_lblValorProduto);

		txtValorProduto = new TextField();
		GridBagConstraints gbc_txtValorProduto = new GridBagConstraints();
		gbc_txtValorProduto.insets = new Insets(0, 0, 5, 0);
		gbc_txtValorProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValorProduto.gridwidth = 9;
		gbc_txtValorProduto.gridx = 2;
		gbc_txtValorProduto.gridy = 1;
		getContentPane().add(txtValorProduto, gbc_txtValorProduto);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					adicionarProduto();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.gridwidth = 4;
		gbc_btnAdicionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionar.gridx = 4;
		gbc_btnAdicionar.gridy = 2;
		getContentPane().add(btnAdicionar, gbc_btnAdicionar);
	}

	public ListaProdutoJFrame getListar() {
		return listar;
	}

	public void setListar(ListaProdutoJFrame listar) {
		this.listar = listar;
	}

}
