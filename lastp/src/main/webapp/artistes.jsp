<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hibernate.models.Artiste" %> <!-- Import de la classe Artiste -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des artistes</title>
    <!-- Ajout de Bootstrap pour le style -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h3>Bonjour, nous sommes le : <span style="color: red;"><%=new Date()%></span></h3>
        <h1>Liste des artistes</h1>

        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Prénom</th>
                    <th scope="col">Année de Naissance</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.artistes}" var="artiste">
                    <tr>
                        <td>${artiste.id}</td>
                        <td>${artiste.nom}</td>
                        <td>${artiste.prenom}</td>
                        <td>${artiste.annee_naissance}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Ajout de Bootstrap pour le style -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
