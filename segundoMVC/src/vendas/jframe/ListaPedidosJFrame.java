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

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.List;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;

public class ListaPedidosJFrame extends JFrame {

	private JPanel contentPane;
	private JList<Pedido> listPedidos;
	PedidoControllerDB pedidoC = new PedidoControllerDB();
	
	public void listaPedidos () throws Exception {
		listPedidos.removeAll();
		DefaultListModel<Pedido> pedido = new DefaultListModel<>();
		for ( Pedido pedidos : pedidoC.listarPedidos()) {
			pedido.addElement(pedidos);
		}
		listPedidos.setModel(pedido);
	}

	public ListaPedidosJFrame() {
		setBounds(100, 100, 450, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(32dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Hist\u00F3rico de pedidos");
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		contentPane.add(lblNewLabel, "4, 2, center, default");
		
		listPedidos = new JList();
		contentPane.add(listPedidos, "4, 4, fill, fill");
		
		Component verticalStrut = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut, "6, 4");
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		contentPane.add(horizontalStrut, "4, 6");
	}

}
