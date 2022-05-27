package vendas.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import vendas.controller.db.ClienteControllerDB;
import vendas.model.Cliente;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class EditarClienteJframe extends JFrame {

	private JPanel contentPane;
	private TextField txtID;
	private TextField txtNome;
	private TextField txtCPF;
	private JButton btnUpdateCliente;
	ClienteControllerDB clienteC = new ClienteControllerDB();
	private TextField textCliente;
	
	public void updateCliente() throws Exception {
		Cliente cliente = new Cliente();
		int x = Integer.parseInt(txtID.getText());
		cliente.setId(x);
		cliente.setNome(txtNome.getText());
		cliente.setCPF(txtCPF.getText());
		clienteC.updateClient(cliente);
		
	}
	
	public void buscarID () throws Exception {
		int x = Integer.parseInt(txtID.getText());
		Cliente cliente = clienteC.getCliente(x);
		textCliente.setText(cliente.toString());
	}

	public EditarClienteJframe() {
		setTitle("Atualizar cadastro do Cliente");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 346, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(14dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(37dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblIDcliente = new JLabel("ID");
		contentPane.add(lblIDcliente, "2, 2, center, default");
		
		txtID = new TextField();
		contentPane.add(txtID, "4, 2, left, default");
		
		JButton btnBuscarID = new JButton("Buscar");
		btnBuscarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarID();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnBuscarID, "6, 2");
		
		textCliente = new TextField();
		contentPane.add(textCliente, "4, 4, 3, 1");
		
		JLabel lblNewLabel = new JLabel("Nome");
		contentPane.add(lblNewLabel, "2, 6, center, default");
		
		txtNome = new TextField();
		contentPane.add(txtNome, "4, 6, 3, 1");
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		contentPane.add(lblNewLabel_1, "2, 8, center, default");
		
		txtCPF = new TextField();
		contentPane.add(txtCPF, "4, 8, 3, 1");
		
		btnUpdateCliente = new JButton("Atualizar");
		btnUpdateCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateCliente();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnUpdateCliente, "4, 10");
	}

}
