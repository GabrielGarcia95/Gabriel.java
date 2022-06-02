package vendas.jframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import vendas.controller.db.ClienteControllerDB;
import vendas.model.Cliente;

public class SelecionarClienteJFrame extends JFrame {

	private JPanel contentPane;
	ClienteControllerDB cliecontro = new ClienteControllerDB();
	private JFormattedTextField exibirClienteDaBusca;
	private JButton btnBuscarPeloID;
	private JButton btnConfirmarBusca;
	private JScrollPane scrollPane;
	private JList<Cliente> listClientes;
	private MenuJFrame menuJ;
	private JButton btnCancelar;

	public void listarCliente () throws Exception {
		DefaultListModel<Cliente> model = new DefaultListModel<>();
		for ( Cliente cliente : cliecontro.listClients()) {
			model.addElement(cliente);
		}
		listClientes.setModel(model);
	}
	public void buscarClienteID () throws Exception {
		Cliente cliente = listClientes.getSelectedValue();
			exibirClienteDaBusca.setText(cliente.toString());
	}
	
	public SelecionarClienteJFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 476);
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Clientes:");
		contentPane.add(lblNewLabel, "4, 2, center, default");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnCancelar, "6, 2");
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "4, 4, fill, fill");
		
		listClientes = new JList();
		scrollPane.setViewportView(listClientes);
		
		btnBuscarPeloID = new JButton("Selecionar");
		btnBuscarPeloID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarClienteID();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnBuscarPeloID, "Cliente não encontrado!");
				}
			}
		});
		contentPane.add(btnBuscarPeloID, "6, 4");
		
		exibirClienteDaBusca = new JFormattedTextField();
		contentPane.add(exibirClienteDaBusca, "4, 6, fill, default");
		
		btnConfirmarBusca = new JButton("Confirmar ");
		btnConfirmarBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = listClientes.getSelectedValue();
				menuJ.setCliente(cliente);
				setVisible(false);
				
			}
		});
		contentPane.add(btnConfirmarBusca, "6, 6");
	}
	public MenuJFrame getMenuJ() {
		return menuJ;
	}
	public void setMenuJ(MenuJFrame menuJ) {
		this.menuJ = menuJ;
	}

}
