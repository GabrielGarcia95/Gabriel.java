package vendas.jframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PedidoProdutoJFrame extends JFrame {

	private JPanel contentPane;
	ProdutoControllerDB produtoC = new ProdutoControllerDB();
	private JList<Produto> listProdutosCarrinho;
	private JButton btnAdcProduto;
	private JList<Produto> listProdutosDisponíveis;
	private JTextField testTOTAL;
	private MenuJFrame menuJ;
	


	public void listarProdutos() throws Exception {
		DefaultListModel<Produto> model = new DefaultListModel<>();
		for (Produto produto : produtoC.listProduct()) {
			model.addElement(produto);
		}
		listProdutosDisponíveis.setModel(model);
	}
	DefaultListModel<Produto> produto = new DefaultListModel<>();
	List<Produto> prod = new ArrayList<>();
	public void carrinhoPedido () throws Exception {
		
		Produto p = listProdutosDisponíveis.getSelectedValue();
		produto.addElement(p);
		prod.add(p);
		listProdutosCarrinho.setModel(produto);
		
		double total = 0;
		for ( Produto produtos : prod) {
			total += produtos.getPreco();
		}
		testTOTAL.setText(Double.toString(total));
		menuJ.getExibirValorTotalPedido().setText(testTOTAL.getText());
		
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
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
		contentPane.add(lblNewLabel_2, "12, 2, center, default");
		
		JLabel lblNewLabel = new JLabel("Produtos:");
		contentPane.add(lblNewLabel, "2, 4, default, top");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "4, 4, fill, fill");
		
		listProdutosDisponíveis = new JList();
		scrollPane.setViewportView(listProdutosDisponíveis);
		
		listProdutosCarrinho = new JList();
		contentPane.add(listProdutosCarrinho, "12, 4, fill, fill");
		
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
		
		JLabel lblNewLabel_3 = new JLabel("TOTAL:");
		contentPane.add(lblNewLabel_3, "6, 6, 6, 1, right, default");
		
		testTOTAL = new JTextField();
		contentPane.add(testTOTAL, "12, 6, fill, default");
		testTOTAL.setColumns(10);
		contentPane.add(btnAdcProduto, "4, 8");
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuJ.getItensAdicionados().setModel(listProdutosCarrinho.getModel());
				setVisible(false);
			}
		});
		contentPane.add(btnConfirmar, "12, 8");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnCancelar, "12, 10, default, top");
	}

	public MenuJFrame getMenuJ() {
		return menuJ;
	}

	public void setMenuJ(MenuJFrame menuJ) {
		this.menuJ = menuJ;
	}


}
