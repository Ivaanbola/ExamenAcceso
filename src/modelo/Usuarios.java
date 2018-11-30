package modelo;

import java.sql.SQLException;

import dao.DAOUsuarios;

public class Usuarios {
	private String usuario;
	private String contrase�a;

	public Usuarios() {

	}
	
	public Usuarios( String usuario, String contrase�a) {
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public static boolean buscar(String nombre, String contrase�a) {
		Usuarios e = null;
		try {
			e = DAOUsuarios.getInstance().buscar(nombre, contrase�a);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e == null) {
			return false;
		} else
			return true;
	}

}
