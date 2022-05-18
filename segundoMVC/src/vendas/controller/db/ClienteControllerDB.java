package vendas.controller.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vendas.model.Cliente;

public class ClienteControllerDB {
	private Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedido", "root", "fjsistemas");
		return con;
	}

	public Cliente getCliente(int id) throws Exception {
		Connection con = getConnection();

		try {
			Cliente cliente = null;

			String sql = "SELECT id, nome, cpf FROM cliente WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");

				cliente = new Cliente();
				cliente.setId(id);
				cliente.setNome(nome);
				cliente.setCPF(cpf);
			}
			rs.close();
			ps.close();

			if (cliente == null) {
				throw new Exception("Cliente não encontrado");
			}
			return cliente;

		} catch (Exception e) {
			throw e;

		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public void insertClient(Cliente cliente) throws Exception {
		Connection con = getConnection();

		try {
			String sql = "INSERT INTO cliente (nome, cpf) VALUES (?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCPF());

			ps.executeUpdate();

		} catch (Exception e) {
			throw e;
		}
		finally {
			if (con!= null) {
				con.close();
			}
		}
	}
	public List<Cliente> listClients() throws Exception{
		Connection con = getConnection();
		
		try {
			List<Cliente> list = new ArrayList<Cliente>();
			
			String sql = "SELECT id, nome, cpf FROM cliente";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				
				Cliente cliente = new Cliente();
				cliente.setId(id);
				cliente.setNome(nome);
				cliente.setCPF(cpf);
				
				list.add(cliente);
				
				
			}
			rs.close();
			st.close();
			
			return list;
			
		} catch (Exception e) {
			throw e;
		}
		finally {
			if(con!=null) {
				con.close();
			}
		}
	}
	
	public void deleteCliente(Cliente cliente) throws Exception{
		Connection con = getConnection();
		try {
			String sql = "DELETE FROM cliente WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, cliente.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		}
		finally {
			if(con!=null) {
				con.close();
			}
		}
	}
	public void updateClient(Cliente cliente) throws Exception{
		Connection con = getConnection();
		try {
			String sql = "UPDATE cliente SET nome = ?, cpf = ? WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCPF());
			ps.setInt(3, cliente.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if(con!= null) {
				con.close();
			}
		}
	}
	public List<Cliente> searchCliente(String string) throws Exception{
		Connection con = getConnection();
		try {
			List <Cliente>list = new ArrayList<Cliente>();
			
			String sql = "SELECT id, nome, cpf FROM cliente WHERE nome LIKE'"+string+"%'";
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				
				Cliente cliente = new Cliente();
				cliente.setId(id);
				cliente.setNome(nome);
				cliente.setCPF(cpf);
				
				list.add(cliente);
				System.out.println("ID: "+id+", nome: "+nome+", cpf: "+cpf);
			}
			rs.close();
			st.close();
			return list;
		}
		
		catch (Exception e) {
			throw e;
		} finally {
			if (con!= null) {
				con.close();
			}
		}
	}
	

	
	
	
	
	
	
	
	
	
}
