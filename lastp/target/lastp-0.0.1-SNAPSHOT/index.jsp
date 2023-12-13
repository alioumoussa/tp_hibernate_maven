<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page JSP</title>
</head>
<body>
Bonjour, nous sommes le <font color="red"><%=new Date()%></font>

<h1>Actions ORM</h1>
<ul>
<li><a
href="${pageContext.request.contextPath}/Jdbc?action=pays">Liste des pays</a>
<li><a
href="${pageContext.request.contextPath}/Jdbc?action=artistes">Liste des artistes</a>
</li>
<li><a
href="${pageContext.request.contextPath}/Jdbc?action=lister">Lister des film</a>
</li>
<li><a
href="${pageContext.request.contextPath}/Jdbc?action=region">Lister des regions</a>
</li>

<li><a
href="${pageContext.request.contextPath}/Jdbc?action=insertion">Inserer un artiste</a>
</li>
</ul>
</body>
</html>