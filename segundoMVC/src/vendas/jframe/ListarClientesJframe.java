package vendas.jframe;

import java.awt.Font;
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

import vendas.controller.db.ClienteControllerDB;
import vendas.model.Cliente;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarClientesJframe extends JFrame {

	private JPanel contentPane;
	ClienteControllerDB clienteC = new ClienteControllerDB();
	private JButton btnExcluir;
	private JButton btnEditarCliente;
	private JButton btnAtualizar;
	private JScrollPane scrollPane;
	private JList<Cliente> listClientes;
	
	public void listaDeClientes() throws Exception {
		listClientes.removeAll();
		DefaultListModel<Cliente> model = new DefaultListModel<>();
		for(Cliente cliente : clienteC.listClients()) {
			model.addElement(cliente);
		}
		listClientes.setModel(model);
	}
	
	public void excluirCliente() throws Exception {
		Cliente cliente = listClientes.getSelectedValue();
		clienteC.deleteCliente(cliente);
	}
	public void atualizar() throws Exception {
		listClientes.removeAll();
		listaDeClientes();
	}

	public ListarClientesJframe() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 614);
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
				RowSpec.decode("max(27dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Lista de clientes");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, "4, 2, 1, 2, center, center");
		
		JButton btnAddCliente = new JButton("Adicionar novo cliente");
		btnAddCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdcClienteJFrame adc = new AdcClienteJFrame();
				adc.setListar(ListarClientesJframe.this);
				adc.setVisible(true);
			}
		});
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "4, 4, fill, fill");
		
		listClientes = new JList();
		listClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		//		e.
			}
		});
		scrollPane.setViewportView(listClientes);
		contentPane.add(btnAddCliente, "4, 6");
		
		btnExcluir = new JButton("Excluir cliente");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					excluirCliente();
					atualizar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnExcluir, "4, 8");
		
		btnEditarCliente = new JButton("Editar Cliente");
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarClienteJframe edt = new EditarClienteJframe();
				edt.setVisible(true);
			}
		});
		contentPane.add(btnEditarCliente, "4, 10");
		
		btnAtualizar = new JButton("Atualizar pagina");
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
		contentPane.add(btnAtualizar, "4, 12");
	}

}
