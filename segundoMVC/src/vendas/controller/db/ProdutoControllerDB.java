package vendas.controller.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vendas.model.Produto;

public class ProdutoControllerDB {
	private Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedido", "root", "fjsistemas");
		return con;
	}

	public Produto getProduto(int id) throws Exception {
		Connection con = getConnection();

		try {
			Produto produto = null;

			String sql = "SELECT id, nome, preço FROM produto WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
				String nome = rs.getString("nome");
				Double preço = rs.getDouble("preço");

				produto = new Produto();
				produto.setId(id);
				produto.setNome(nome);
				produto.setPreco(preço);
			}
			rs.close();
			ps.close();
			if (produto == null) {
				throw new Exception("Produto não encontrado");
			}
			return produto;
		} catch (Exception e) {
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public void insertProduct(Produto produto) throws Exception {
		Connection con = getConnection();
		try {
			String sql = "INSERT INTO produto (nome, preço) VALUES(?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getPreco());

			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	public List<Produto> listProduct() throws Exception{
		Connection con = getConnection();
		try {
			List<Produto> list = new ArrayList<Produto>();
			
			String sql = "SELECT id, nome, preço FROM produto";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				Double preço = rs.getDouble("preço");
				
				Produto produto = new Produto();
				produto.setId(id);
				produto.setNome(nome);
				produto.setPreco(preço);
				
				list.add(produto);
			}
			rs.close();
			st.close();
			
			return list;
		} catch (Exception e) {
			throw e;
		}finally {
			if(con!= null) {
				con.close();
			}
		}
		
	}
	public void deleteProduct(Produto produto) throws Exception{
		Connection con = getConnection();
		try {
			String sql = "DELETE FROM produto WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, produto.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		}finally {
			if(con!=null) {
				con.close();
			}
		}
	}
	public void updateProduct(Produto produto) throws Exception{
		Connection con = getConnection();
		try {
			String sql = "UPDATE produto SET nome = ?, preço = ? WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getPreco());
			ps.setInt(3, produto.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if(con!=null) {
				con.close();
			}
		}
	}
	public List<Produto> searchProduct(String pdt) throws Exception{
		Connection con = getConnection();
		try {
			List<Produto> list = new ArrayList<Produto>();
			
			String sql = "SELECT id, nome, preço FROM produto WHERE nome LIKE '"+pdt+"%'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				Double preço = rs.getDouble("preço");
				
				Produto produto2 = new Produto();
				produto2.setId(id);
				produto2.setNome(nome);
				produto2.setPreco(preço);
				
				list.add(produto2);
				System.out.println("ID: "+id+", Nome: "+nome+", Preço: R$"+preço);
			}
			rs.close();
			st.close();
			return list;
			
		} catch (Exception e) {
			throw e;
		}finally {
			if(con!= null) {
				con.close();
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
