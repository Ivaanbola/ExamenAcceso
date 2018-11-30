<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/includes/header.inc.jsp"%>
    <%= application.getAttribute("msgOferta") %>		

	<a href="mostrarTodos.jsp">Mostrar todos los productos</a>  <br>

	<a href=GProducto?opcion=3&id=0>Buscar un producto</a>  <br>

</body>
</html>