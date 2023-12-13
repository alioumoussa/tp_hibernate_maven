<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ page import="java.util.Date" %> 
    <%@ page import="java.sql.*" %>
    <%@ page import="java.util.List" %>

   <%@ page import="java.util.Date" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Connexion </title>
</head>
<body>
<h3>Bonjour, nous sommes le : <font color="red"><%=new Date()%></font></h3>
<h1>Liste des films </h1>

<table border="5">
<tr>
<td align="center"><b>Titre</td><td align="center"><b>Annee</td><td align="center"><b>Id Realisateur</td><td align="center"><b>Genre
</td><td align="center"><b>Resume</td><td align="center"><b>Code pays</td>
</tr>
<c:forEach items="${requestScope.films}" var="flm">
<tr>
<td align="center">
<c:out value="${flm.getTitre()}"/> 
</td>
<td align="center">
<c:out value="${flm.annee}"/> 
</td>

<td align="center">
 <c:out value="${flm.id_realisateur}"/> 
</td>
<td align="center">
<c:out value="${flm.genre}"/> 
</td>

<td align="center">
<c:out value="${flm.resume}"/> 
</td>
<td align="center">
<c:out value="${flm.code_pays}"/> 
</td>
</tr>
</c:forEach>


</body>

</html>