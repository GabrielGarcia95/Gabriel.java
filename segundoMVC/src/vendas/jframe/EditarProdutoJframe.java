package vendas.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import vendas.controller.db.ProdutoControllerDB;
import vendas.model.Produto;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarProdutoJframe extends JFrame {

	private JPanel contentPane;
	private TextField txtID;
	private TextField txtNome;
	private TextField txtValor;
	private JButton btnConfirmar;
	ProdutoControllerDB produtoC = new ProdutoControllerDB();
	
	public void EditarProduto () throws Exception {
		Produto produto = new Produto();
		int id = Integer.parseInt(txtID.getText());
		produto.setId(id);
		produto.setNome(txtNome.getText());
		double valor = Double.parseDouble(txtValor.getText());
		produto.setPreco(valor);
		produtoC.updateProduct(produto);
		
	}

	public EditarProdutoJframe() {
		setBounds(100, 100, 355, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(32dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(133dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("ID produto");
		contentPane.add(lblNewLabel, "2, 2, right, default");
		
		txtID = new TextField();
		contentPane.add(txtID, "4, 2, left, default");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		contentPane.add(lblNewLabel_1, "2, 4, right, default");
		
		txtNome = new TextField();
		contentPane.add(txtNome, "4, 4");
		
		JLabel lblNewLabel_2 = new JLabel("Valor R$");
		contentPane.add(lblNewLabel_2, "2, 6, right, default");
		
		txtValor = new TextField();
		contentPane.add(txtValor, "4, 6");
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EditarProduto();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnConfirmar, "4, 8");
	}

}
