package vendas.jframe;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import vendas.controller.db.ProdutoControllerDB;
import vendas.model.Produto;

public class ListaProdutoJFrame extends JFrame {

	private JPanel contentPane;
	ProdutoControllerDB controleP = new ProdutoControllerDB();
	private JButton btnExcluirProduto;
	private JList<Produto> listprodut;
	
	public void listarProdutos () throws Exception {
		DefaultListModel<Produto> modelP = new DefaultListModel<>();
		listprodut.removeAll();
		for(Produto produto : controleP.listProduct()) {
			modelP.addElement(produto);
		}
		listprodut.setModel(modelP);
	}
	public void excluirProduto() throws Exception {
		Produto produto = listprodut.getSelectedValue();
		controleP.deleteProduct(produto);
		
	}
	public void atualizar() throws Exception {
		listprodut.removeAll();
	    listarProdutos();
	}

	public ListaProdutoJFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(170dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(241dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnAddProduto = new JButton("Adicionar novo produto");
		btnAddProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProdutoJframe addpro = new AddProdutoJframe();
				addpro.setListar(ListaProdutoJFrame.this);
				addpro.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Lista de produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel, "4, 2, center, default");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_1, "2, 4");
		
		listprodut = new JList();
		contentPane.add(listprodut, "4, 4, fill, fill");
		
		Component verticalStrut = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut, "6, 4");
		contentPane.add(btnAddProduto, "4, 6");
		
		btnExcluirProduto = new JButton("Excluir");
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					excluirProduto();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnExcluirProduto, "4, 8");
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atualizar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnAtualizar, "4, 10");
	}



}
