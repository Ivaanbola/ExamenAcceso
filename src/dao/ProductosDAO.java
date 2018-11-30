package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import modelo.Producto;
import singleton.DBConnection;

public class ProductosDAO {
	
	private Connection con = null;

	public static ProductosDAO instance = null;

	public ProductosDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	public static ProductosDAO getInstance() throws SQLException {
		if (instance == null)
			instance = new ProductosDAO();
		return instance;
	}
	
	public void insert(Producto n) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO productlos (descripcion, precio) VALUES (?,?)");
		ps.setString(1, n.getDescripcion());
		ps.setDouble(2, n.getPrecio());
		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList<Producto> listarTodos() throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("SELECT * from productos");
		ResultSet rs = ps.executeQuery();

		ArrayList<Producto> result = null;

		while (rs.next()) {
			if (result == null)
				result = new ArrayList<>();
			result.add(new Producto(rs.getInt("id"), rs.getString("descripcion"), rs.getDouble("precio")));
		}
		rs.close();
		ps.close();
		return result;
	}

	
	public Producto buscarID(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM productos WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Producto result = null;
		if (rs.next()) {
			result = new Producto(rs.getInt("id"), rs.getString("descripcion"), rs.getDouble("precio"));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	
	public void delete(Producto e) throws SQLException {
		delete(e.getId());
	}

	public void delete(int id) throws SQLException {
		if (id <= 0)
			return;

		PreparedStatement ps = con.prepareStatement("DELETE FROM productos WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}
	
	public void update(Producto n) throws SQLException {
		if (n.getId() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"UPDATE productos SET  descripcion = ?, precio = ? WHERE id = ?");
		ps.setString(1, n.getDescripcion());
		ps.setDouble(2, n.getPrecio());
		ps.setInt(3, n.getId());

		ps.executeUpdate();
		ps.close();
	}

	
}
