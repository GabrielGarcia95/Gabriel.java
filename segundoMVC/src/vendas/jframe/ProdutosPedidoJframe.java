package vendas.jframe;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import vendas.controller.db.ProdutoControllerDB;
import vendas.model.Produto;

public class ProdutosPedidoJframe extends JFrame {

	private JPanel contentPane;
	private JList<Produto> listProduto;
	private Produto produto;
	ProdutoControllerDB produtoC = new ProdutoControllerDB();
	
	public void setModel(DefaultListModel<Produto> model) throws Exception {
		listProduto.setModel(model);
	}

	public ProdutosPedidoJframe() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "2, 2, fill, fill");
		
		listProduto = new JList();
		scrollPane.setViewportView(listProduto);
	}

	public Produto getProduto() {
		return produto;
	}

}
