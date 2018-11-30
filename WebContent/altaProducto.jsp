<%@page import="com.sun.javafx.fxml.ParseTraceElement"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controlador.GProducto"%>
<%@page import="modelo.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/includes/header.inc.jsp"%>
			<%
				String id = "0";
				if (request.getAttribute("id") != null) {
					id = request.getAttribute("id").toString();
				}
				Producto p = new Producto();
				p.buscarID(Integer.parseInt(id));
			%>
			<div >
				<h3>Insertar</h3>
				<form name="usuario" action="GProducto" method="post">
					<ul>
						<li><label>Descripcion:</label><input type="text" name="descripcion"
							id="descripcion"
							value='<%if (request.getAttribute("id") != null)
				out.print(p.getDescripcion());%>'>
						<li><label>Precio:</label><input type="text" name="precio"
							id="precio" 
							value='<%if (request.getAttribute("id") != null)
				out.print(p.getPrecio());%>'>
							<input type="hidden" name="id" id="id"
							value='<%if (request.getAttribute("id") != null)
				out.print(p.getId());%>'>
							<input type="hidden" name="opcion" value="1">
						<li><input type="submit" name="enviar" value="Guardar">
					</ul>
				</form>

				<a href="mostrarTodos.jsp">Volver a la lista</a>
				<%
					if (request.getAttribute("id") != null)
						out.print("<a href='GProducto?opcion=2&id=" + p.getId() + "'>Borrar</a>");
				%>
			</div>

		




</body>
</html>