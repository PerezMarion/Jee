<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Menu</title>
	<link rel="stylesheet" href="inc/menu.css">
</head>
<body>
	<h1 class="grandTitre">Menu</h1>
	<ul class="listeMenu">
		<li><a href="<c:url value="/"/>">Acceuil</a></li>
		<li><a href="<c:url value="/ListeAuteurs"/>">Liste des auteurs</a></li>
		<li><a href="<c:url value="/ListeLivres"/>">Liste des livres</a></li>
		<li><a href="<c:url value="/AjouterAuteur"/>">Ajouter un auteur</a></li>
		<li><a href="<c:url value="/AjouterLivre"/>">Ajouter un livre</a></li>
	</ul>
</body>
</html>