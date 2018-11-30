package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Producto;
import modelo.Usuarios;

/**
 * Servlet implementation class GProducto
 */
@WebServlet("/GProducto")
public class GProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		inicio(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		inicio(request, response);
	}

	protected void inicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getParameter("opcion")) {
		case "1":
			nuevoProducto(request, response);
			break;
		case "2":
			borrarProducto(request, response);
			break;
		case "3":
			buscarProducto(request, response);
			break;
		case "4":
			peticionLogin(request, response);
			break;
		case "5":
			cerrarLogin(request, response);
			break;
		case "6":
			editar(request, response);
			break;
		default:
			System.out.println("Opcion no valida");
		}

	}

	private void cerrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		System.out.println("Cerrando sesion" + sesion.getAttribute("nombre"));

		if (sesion.getAttribute("nombre") != null) {
			sesion.removeAttribute("nombre");
		}
		response.sendRedirect("formularioLogin.jsp");

	}

	private void peticionLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession sesion = request.getSession();
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");

		if (Usuarios.buscar(nombre, contrasena)) {
			sesion.setAttribute("nombre", nombre);
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("nombre" + nombre + "contrasena" + contrasena);
			response.sendRedirect("formularioLogin.jsp");
		}

	}

	private void buscarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("formularioBuscar.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("formularioBuscar.jsp");
			vista.forward(request, response);
		}

	}

	private void nuevoProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descripcion = request.getParameter("descripcion");
		Double precio = Double.parseDouble(request.getParameter("precio"));

		Producto p = new Producto(descripcion, precio);
		if (request.getParameter("id") != "") {
			int id = Integer.parseInt(request.getParameter("id"));
			p.setId(id);
			p.actualizar();
		} else
			p.insertar();

		response.sendRedirect("mostrarTodos.jsp");

	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("altaProducto.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("altaProducto.jsp");
			vista.forward(request, response);
		}

	}

	private void borrarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Producto p = new Producto();
		p.buscarID(Integer.parseInt(request.getParameter("id")));
		p.borrar();
		response.sendRedirect("mostrarTodos.jsp");

	}

}
