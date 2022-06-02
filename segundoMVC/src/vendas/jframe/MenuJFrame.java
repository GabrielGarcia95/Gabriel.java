package vendas.jframe;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import vendas.controller.db.PedidoControllerDB;
import vendas.model.Cliente;
import vendas.model.Pedido;
import vendas.model.Produto;
import java.awt.Dimension;

public class MenuJFrame extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField ExibirClienteSelecionado;
	private Cliente cliente;
	private JList<Produto> ItensAdicionados;
	private JFormattedTextField ExibirValorTotalPedido;

	public JFormattedTextField getExibirValorTotalPedido() {
		return ExibirValorTotalPedido;
	}


	public void setExibirValorTotalPedido(JFormattedTextField exibirValorTotalPedido) {
		ExibirValorTotalPedido = exibirValorTotalPedido;
	}


	public JList<Produto> getItensAdicionados() {
		return ItensAdicionados;
	}


	public void setItensAdicionados(JList<Produto> itensAdicionados) {
		ItensAdicionados = itensAdicionados;
	}


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
		setBounds(100, 100, 588, 315);
		
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[74.00][122.00px,grow][][68.00px,grow][116.00px,grow]", "[23px,grow][grow][][][][]"));
		
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
				projframe.setMenuJ(MenuJFrame.this);
				projframe.setVisible(true);
			}
		});
		contentPane.add(AdicionarItensAoPedido, "cell 1 0,alignx center");
		
		JLabel lblNewLabel = new JLabel("Itens adicionados:");
		contentPane.add(lblNewLabel, "cell 2 0 1 2,alignx right");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 3 0 2 2,grow");
		
		ItensAdicionados = new JList();
		scrollPane.setViewportView(ItensAdicionados);
		
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
				cliejframe.setMenuJ(MenuJFrame.this);
				cliejframe.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\fjdev2\\Desktop\\imgs\\beta.jpg"));
		contentPane.add(lblNewLabel_3, "cell 0 1 2 1");
		contentPane.add(SelecionarCliente, "cell 1 2,alignx right");
		
		Label label = new Label("Cliente :");
		contentPane.add(label, "cell 2 2,alignx right");
		
		ExibirClienteSelecionado = new JFormattedTextField();
		ExibirClienteSelecionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(ExibirClienteSelecionado, "cell 3 2 2 1,growx");
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\fjdev2\\Desktop\\beta.jpg"));
		contentPane.add(label_1, "flowx,cell 1 3 1 2");
		
		JRadioButton PagamentoDinheiro = new JRadioButton("Dinheiro");
		contentPane.add(PagamentoDinheiro, "cell 2 4");
		
		JRadioButton pagamentoPix = new JRadioButton("Pix");
		contentPane.add(pagamentoPix, "cell 3 4");
		
		JRadioButton pagamentoCartão = new JRadioButton("Cart\u00E3o");
		contentPane.add(pagamentoCartão, "cell 4 4");
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnSair, "cell 0 5,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Valor total :");
		contentPane.add(lblNewLabel_1, "cell 1 5,alignx trailing");
		
		JButton ConfirmarPedido = new JButton("CONFIRMAR PEDIDO");
		ConfirmarPedido.setMaximumSize(new Dimension(220, 25));
		ConfirmarPedido.setIcon(new ImageIcon("C:\\Users\\fjdev2\\Desktop\\aceitar.png"));
		ConfirmarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Object[] options = {"Sim", "Não"};        
				    
					if (JOptionPane.showOptionDialog(MenuJFrame.this, "Confirmar pedido ?", "titulo", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Não") == JOptionPane.YES_OPTION) {
						inserirPedido();
						JOptionPane.showMessageDialog(ConfirmarPedido, "Pedido confirmado!");
						ExibirListaClientes.removeAll();
						ItensAdicionados.removeAll();
					} else {
						JOptionPane.showMessageDialog(ConfirmarPedido, "Pedido CANCELADO!");
						
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		ExibirValorTotalPedido = new JFormattedTextField();
		contentPane.add(ExibirValorTotalPedido, "cell 2 5,growx");
		contentPane.add(ConfirmarPedido, "cell 3 5 2 1");
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E9todo de pagamento:");
		contentPane.add(lblNewLabel_2, "cell 1 4,alignx right");
	}
	public void inserirPedido() throws Exception {
		PedidoControllerDB pedidoC = new PedidoControllerDB();
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		for ( int i = 0; i < ItensAdicionados.getModel().getSize(); i++) {
			Produto produto = ItensAdicionados.getModel().getElementAt(i);
					pedido.getProdutos().add(produto);
		}
		pedido.somar();
		pedido.setDate(new Date(System.currentTimeMillis()));
		pedidoC.inserirPedido(pedido);
		
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		ExibirClienteSelecionado.setText(getCliente().toString());
	}



}
