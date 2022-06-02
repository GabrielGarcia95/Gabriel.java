package vendas.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import vendas.controller.db.PedidoControllerDB;
import vendas.model.Pedido;
import vendas.model.Produto;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.List;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaPedidosJFrame extends JFrame {

	private JPanel contentPane;
	PedidoControllerDB pedidoC = new PedidoControllerDB();
	private JList<Pedido> listPedidos;

	public void listaPedidos() throws Exception {
		listPedidos.removeAll();
		DefaultListModel<Pedido> pedido = new DefaultListModel<>();
		for (Pedido pedidos : pedidoC.listarPedidos()) {
			pedido.addElement(pedidos);
		}
		listPedidos.setModel(pedido);
	}

	public ListaPedidosJFrame() {
		setBounds(100, 100, 450, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(32dlu;default)"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblNewLabel = new JLabel("Hist\u00F3rico de pedidos");
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		contentPane.add(lblNewLabel, "4, 2, center, default");

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "4, 4, fill, fill");

		listPedidos = new JList();
		listPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					ProdutosPedidoJframe proped = new ProdutosPedidoJframe();
					DefaultListModel<Produto> model = new DefaultListModel<Produto>();
					listPedidos.getSelectedValue().getProdutos();
					for (Produto produto : listPedidos.getSelectedValue().getProdutos()) {
						model.addElement(produto);
					}
					try {
						proped.setModel(model);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					proped.setVisible(true);
				}

			}
		});
		scrollPane.setViewportView(listPedidos);

		Component verticalStrut = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut, "6, 4");

		JButton btnExcluirPedido = new JButton("Excluir Pedido");
		btnExcluirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido pedido = listPedidos.getSelectedValue();
				try {
					Object[] options = { "Sim", "N�o" };

					if (JOptionPane.showOptionDialog(ListaPedidosJFrame.this, "Excluir pedido ?!", "titulo",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
							"N�o") == JOptionPane.YES_OPTION) {
						pedidoC.excluirPedido(pedido);
						listPedidos.removeAll();
						try {
							listaPedidos();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnExcluirPedido, "4, 6");

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listPedidos.removeAll();
				try {
					listaPedidos();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnAtualizar, "4, 8");
	}

}
