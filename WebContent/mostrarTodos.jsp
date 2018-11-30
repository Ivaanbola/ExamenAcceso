<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.GProducto"%>
<%@page import="modelo.Producto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/includes/header.inc.jsp"%>

	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>Descripcion</th>
			<th>Precio</th>
			<th>Editar</th>
			<th>Añadir al carrito</th>
		</tr>

		<%
			Producto producto = new Producto();

			ArrayList<Producto> lista = producto.listarProductos();
			if (lista != null) {
				for (Producto p : lista) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getDescripcion()%></td>
			<td><%=p.getPrecio()%></td>
			<td><a href="GProducto?opcion=6&id=<%=p.getId()%>"> Editar </a></td>
			<td><a href="#">
					Comprar </a></td>
			<td><a href="GProducto?opcion=3&id=<%=p.getId()%>"> Ver
					producto </a></td>
		</tr>
		<%
			}
			}
		%>
		<a href="GProducto?opcion=6&id=0">Dar de alta un nuevo Producto</a>
	</table>


</body>
</html>