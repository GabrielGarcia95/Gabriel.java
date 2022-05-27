package vendas.jframe;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.TextField;

public class MenuJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJFrame frame = new MenuJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public MenuJFrame() {
		setBounds(100, 100, 479, 300);
		
		JMenuBar BarraDoMenu = new JMenuBar();
		setJMenuBar(BarraDoMenu);
		
		JMenu MenuCadastro = new JMenu("Cadastro");
		BarraDoMenu.add(MenuCadastro);
		
		JMenuItem AdicionarCliente = new JMenuItem("Adicionar Cliente");
		AdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdcClienteJFrame adcC = new AdcClienteJFrame();
				adcC.setVisible(true);
			}
		});
		MenuCadastro.add(AdicionarCliente);
		
		JMenuItem ExibirListaClientes = new JMenuItem("Lista de clientes");
		ExibirListaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarClientesJframe listar = new ListarClientesJframe();
				try {
					listar.listaDeClientes();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				listar.setVisible(true);
			}
		});
		MenuCadastro.add(ExibirListaClientes);
		
		JMenuItem AtualizarCliente = new JMenuItem("Atualizar cliente");
		AtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarClienteJframe edt = new EditarClienteJframe();
				edt.setVisible(true);
			}
		});
		MenuCadastro.add(AtualizarCliente);
		
		JMenu MenuProdutos = new JMenu("Produtos");
		BarraDoMenu.add(MenuProdutos);
		
		JMenuItem MenuVerProdutos = new JMenuItem("Ver produtos dispon\u00EDveis");
		MenuVerProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaProdutoJFrame listar = new ListaProdutoJFrame();
				try {
					listar.listarProdutos();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				listar.setVisible(true);
			}
		});
		
		MenuVerProdutos.addMouseListener(new MouseAdapter() {
			
		});
		MenuProdutos.add(MenuVerProdutos);
		
		JMenuItem MenuEditarRemoverProduto = new JMenuItem("Editar produto");
		MenuEditarRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarProdutoJframe edtpro = new EditarProdutoJframe();
				edtpro.setVisible(true);
			}
		});
		MenuProdutos.add(MenuEditarRemoverProduto);
		
		JMenu MenuPedidos = new JMenu("Pedidos");
		BarraDoMenu.add(MenuPedidos);
		
		JMenuItem VerPedidos = new JMenuItem("Ver pedidos");
		VerPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPedidosJFrame pedidos = new ListaPedidosJFrame();
				try {
					pedidos.listaPedidos();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pedidos.setVisible(true);
			}
		});
		MenuPedidos.add(VerPedidos);
		
		JMenuItem EditarPedido = new JMenuItem("Editar pedidos");
		MenuPedidos.add(EditarPedido);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[122.00px,grow][][68.00px,grow][116.00px,grow]", "[23px,grow][grow][][][][][]"));
		
		JButton AdicionarItensAoPedido = new JButton("Adicionar itens ao pedido");
		AdicionarItensAoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidoProdutoJFrame projframe = new PedidoProdutoJFrame();
				try {
					projframe.listarProdutos();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				projframe.setVisible(true);
			}
		});
		contentPane.add(AdicionarItensAoPedido, "cell 0 0");
		
		JLabel lblNewLabel = new JLabel("Itens adicionados:");
		contentPane.add(lblNewLabel, "cell 2 0 1 2,alignx right");
		
		JButton SelecionarCliente = new JButton("Selecionar cliente");
		SelecionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarClienteJFrame cliejframe = new SelecionarClienteJFrame();
				try {
					cliejframe.listarCliente();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cliejframe.setVisible(true);
			}
		});
		
		TextField ItensAdicionados = new TextField();
		contentPane.add(ItensAdicionados, "cell 3 0 1 2,grow");
		contentPane.add(SelecionarCliente, "cell 0 1");
		
		Label label = new Label("Cliente :");
		contentPane.add(label, "cell 2 3,alignx right");
		
		JFormattedTextField ExibirClienteSelecionado = new JFormattedTextField();
		contentPane.add(ExibirClienteSelecionado, "cell 3 3,growx");
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E9todo de pagamento");
		contentPane.add(lblNewLabel_2, "cell 0 4,alignx right");
		
		JRadioButton PagamentoDinheiro = new JRadioButton("Dinheiro");
		contentPane.add(PagamentoDinheiro, "cell 2 4");
		
		JRadioButton PagamentoCartao = new JRadioButton("Cart\u00E3o ou PIX");
		contentPane.add(PagamentoCartao, "cell 3 4");
		
		JLabel lblNewLabel_1 = new JLabel("Valor total :");
		contentPane.add(lblNewLabel_1, "cell 0 5,alignx trailing");
		
		JFormattedTextField ExibirValorTotalPedido = new JFormattedTextField();
		contentPane.add(ExibirValorTotalPedido, "cell 2 5,growx");
		
		JButton ConfirmarPedido = new JButton("CONFIRMAR PEDIDO");
		ConfirmarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ConfirmarPedido, "Pedido confirmado!");
			}
		});
		contentPane.add(ConfirmarPedido, "cell 3 5");
	}

}
