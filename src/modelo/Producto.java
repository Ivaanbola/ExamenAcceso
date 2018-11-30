package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ProductosDAO;

public class Producto {

	private int id;
	private String descripcion;
	private double precio;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(int id, String descripcion, double precio) {
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(String descripcion, double precio) {
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
/**
 * devuelve un array list con los productos de la base de datos
 * @return
 */
	public ArrayList<Producto> listarProductos() {
		ArrayList<Producto> lista = null;
		try {
			lista = ProductosDAO.getInstance().listarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
/**
 * busca un producto en la base de datos
 * @param id
 */
	public void buscarID(int id) {
		Producto e = null;
		try {
			e = ProductosDAO.getInstance().buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			this.id = e.getId();
			this.descripcion = e.getDescripcion();
			this.precio = e.getPrecio();
		}
	}
/**
 * inserta un producto en la base de datos
 */
	public void insertar() {
		try {
			ProductosDAO.getInstance().insert(this);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/**
 * borra un producto en la base de datos
 */
	public void borrar() {
		try {
			ProductosDAO.getInstance().delete(this);
			System.out.println("Registro eliminado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/**
 * actualiza un producto en la base de datos
 */
	public void actualizar() {
		try {
			ProductosDAO.getInstance().update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
