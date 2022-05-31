package vendas.controller.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vendas.model.Cliente;
import vendas.model.Pedido;
import vendas.model.Produto;

public class PedidoControllerDB {
	private Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedido", "root", "fjsistemas");
		return con;
	}

	private List <Produto> produtos;

	public void inserirPedido(Pedido pedido) throws Exception {
		Connection con = getConnection();
		try {
			String sql = " INSERT INTO pedido (data, idcliente, valor_total) VALUES (?,?,?) ";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDate(1, pedido.getDate());
			ps.setInt(2, pedido.getCliente().getId());
			ps.setDouble(3, pedido.getPrecoTotal());

			ps.executeUpdate();
			ps.close();

			sql = "SELECT LAST_INSERT_ID() as id";
			PreparedStatement ps2 = con.prepareStatement(sql);
			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				pedido.setId(rs.getInt("id"));
			}
			rs.close();
			ps2.close();

			sql = "INSERT INTO pedido_produto (idpedido, idproduto) VALUES (?,?)";
			for (Produto produto : pedido.getProdutos()) {
				PreparedStatement ps3 = con.prepareStatement(sql);
				ps3.setInt(1, pedido.getId());
				ps3.setInt(2, produto.getId());
				ps3.executeUpdate();
				ps3.close();
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public Pedido buscarPedido(int idpedido) throws Exception {
		Connection con = getConnection();

		Pedido pedido = null;
		try {
			String sql = "SELECT id, data, idcliente, valor_total FROM pedido WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idpedido);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				idpedido = rs.getInt("id");
				Date data = rs.getDate("data");
				int idc = rs.getInt("idcliente");
				Double valor = rs.getDouble("valor_total");

				pedido = new Pedido();
				pedido.setId(idpedido);
				pedido.setDate(data);
				pedido.setId(idc);
				pedido.setPrecoTotal(valor);
				System.out.println("===============================================");
				System.out.println("ID pedido: " + idpedido + ", valor total: " + valor);
				System.out.println("Data do pedido: " + data + ", ID cliente: " + idc);

			}

			rs.close();
			Produto produto = null;
			sql = " SELECT idpedido, idproduto, produto.nome FROM pedido_produto"
					+ " INNER JOIN produto ON produto.id = pedido_produto.idproduto WHERE idpedido = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idpedido);
			ResultSet rs2 = ps.executeQuery();

			while (rs2.next()) {
				idpedido = rs2.getInt("idpedido");
				int idp = rs2.getInt("idproduto");
				String nome = rs2.getString("nome");

				produto = new Produto();
				produto.setId(idpedido);
				produto.setId(idp);
				produto.setNome(nome);
				System.out.println("id produto: " + idp + ", produto : " + nome);
			}

			rs2.close();
			ps.close();

			return pedido;
		} catch (Exception e) {
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
		}

	}

	public void excluirPedido(Pedido pedido) throws Exception {
		Connection con = getConnection();
		try {
			String sql = "DELETE FROM pedido WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, pedido.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public List<Pedido> listarPedidos() throws Exception {
		Connection con = getConnection();

		try {
			List<Pedido> list = new ArrayList<>();

			String sql = "SELECT pedido.id, data, idcliente, valor_total, cliente.nome FROM pedido INNER JOIN cliente ON idcliente = cliente.id";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
	
			while (rs.next()) {
				int id = rs.getInt("id");
				Date data = rs.getDate("data");
				int idc = rs.getInt("idcliente");
				Double tot = rs.getDouble("valor_total");
				String nome = rs.getString("cliente.nome");
				
				Pedido pedido = new Pedido();
				pedido.setId(id);
				pedido.setDate(data);
				pedido.setId(idc);
				pedido.setPrecoTotal(tot);
				
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				pedido.setCliente(cliente);

				
				
				String sql2 = "SELECT idpedido , idproduto, produto.nome, produto.pre�o FROM pedido_produto INNER JOIN produto ON produto.id = pedido_produto.idproduto";

				Statement st2 = con.createStatement();
				ResultSet rs2 = st2.executeQuery(sql2);
				while (rs2.next()) {
						int idped = rs2.getInt("idpedido");
						int idp = rs2.getInt("idproduto");
						String pro = rs2.getString("produto.nome");
						double pre�o = rs2.getDouble("produto.pre�o");
						
						Produto produto = new Produto();
						produto.setId(idped);
						produto.setId(idp);
						produto.setNome(pro);
						produto.setPreco(pre�o);
						pedido.getProdutos().add(produto);
				}
				list.add(pedido);
				st2.close();
				rs2.close();
			}
			st.close();
			rs.close();

			return list;

		} catch (Exception e) {
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public List <Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List <Produto> produtos) {
		this.produtos = produtos;
	}
}