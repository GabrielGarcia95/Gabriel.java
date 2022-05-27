package vendas.jframe;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import vendas.controller.db.ClienteControllerDB;
import vendas.model.Cliente;

public class AdcClienteJFrame extends JFrame {

	private JPanel contentPane;
	private TextField textnome;
	private TextField textcpf;
	private Button btnaddcliente;
	ClienteControllerDB clienteC = new ClienteControllerDB();
	private ListarClientesJframe listar;

	public void adicionarCliente() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setNome(textnome.getText());
		cliente.setCPF(textcpf.getText());
		clienteC.insertClient(cliente);
		setVisible(false);
		listar.listaDeClientes();
		
	}

	public AdcClienteJFrame() {
		setTitle("Adicionar cliente");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 379, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(65dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("NOME:");
		contentPane.add(lblNewLabel, "2, 2, right, default");
		
		textnome = new TextField();
		contentPane.add(textnome, "4, 2, 17, 1");
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		contentPane.add(lblNewLabel_1, "2, 4");
		
		textcpf = new TextField();
		contentPane.add(textcpf, "4, 4, 17, 1");
		
		btnaddcliente = new Button("Adicionar");
		btnaddcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					adicionarCliente();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnaddcliente, "4, 6, 10, 1");
		
		Button button = new Button("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(button, "18, 6, 3, 1");
	}

	public ListarClientesJframe getListar() {
		return listar;
	}

	public void setListar(ListarClientesJframe listar) {
		this.listar = listar;
	}

}
