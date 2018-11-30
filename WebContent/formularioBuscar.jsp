<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="controlador.GProducto"%>
<%@page import="modelo.Producto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = "0";
		Producto p = new Producto();

		if (request.getAttribute("id") != null) {
			id = request.getAttribute("id").toString();
			p.buscarID(Integer.parseInt(id));
	%>
	<table>
		<tr>
			<th>Decripcion</th>
			<th>Precio</th>
		</tr>
		<tr>
			<td><%=p.getDescripcion()%></td>
			<td><%=p.getPrecio()%></td>
		</tr>
	</table>
	<%
		}
	%>



	<form action="GProducto">
		<label>Introduce Id del producto a buscar:</label> <input type="text"
			name="id"> <input type="hidden" name="opcion" value="3">
		<input type="submit" value="BUSCAR">
	</form>
</body>
</html>