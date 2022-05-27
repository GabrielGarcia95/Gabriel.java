package vendas.jframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class PedidoProdutoJFrame extends JFrame {

	private JPanel contentPane;
	ProdutoControllerDB produtoC = new ProdutoControllerDB();
	private JList<Produto> listProdutosDisponíveis;
	private JList<Produto> listProdutosCarrinho;
	private JButton btnAdcProduto;
	
	public void listarProdutos() throws Exception {
		DefaultListModel<Produto> model = new DefaultListModel<>();
		for (Produto produto : produtoC.listProduct()) {
			model.addElement(produto);
		}
		listProdutosDisponíveis.setModel(model);
	}
	public void carrinhoPedido () throws Exception {
		DefaultListModel<Produto> produto = new DefaultListModel<>();
//		for ( Produto pro : produtoC.listProduct()) {
//			pro = listProdutosDisponíveis.getSelectedValue();
//			produto.addElement(pro);
//			listProdutosCarrinho.setModel(produto);
//		}
		Produto p = listProdutosDisponíveis.getSelectedValue();
		produto.addElement(p);
		listProdutosCarrinho.setModel(produto);
	}

	public PedidoProdutoJFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1299, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(41dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(186dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(0dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(227dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(247dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel_1 = new JLabel("Dispon\u00EDveis");
		contentPane.add(lblNewLabel_1, "4, 2, center, default");
		
		JLabel lblNewLabel_2 = new JLabel("Carrinho");
		contentPane.add(lblNewLabel_2, "8, 2, center, default");
		
		JLabel lblNewLabel = new JLabel("Produtos:");
		contentPane.add(lblNewLabel, "2, 4, default, top");
		
		listProdutosDisponíveis = new JList();
		contentPane.add(listProdutosDisponíveis, "4, 4, fill, fill");
		
		listProdutosCarrinho = new JList();
		contentPane.add(listProdutosCarrinho, "8, 4, fill, fill");
		
		btnAdcProduto = new JButton("Adicionar ao carrinho");
		btnAdcProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carrinhoPedido();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnAdcProduto, "4, 8");
		
		JButton btnConfirmar = new JButton("Confirmar");
		contentPane.add(btnConfirmar, "8, 8");
		
		JButton btnDltProduto = new JButton("Remover");
		contentPane.add(btnDltProduto, "4, 10, default, top");
		
		JButton btnCancelar = new JButton("Cancelar");
		contentPane.add(btnCancelar, "8, 10, default, top");
	}

}
