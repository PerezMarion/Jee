<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Détails livre</title>
<link rel="stylesheet" href="inc/menu.css">
</head>
<body>

<c:import url="/WEB-INF/menu.jsp"/>

<h2>Détails concernant <c:out value="${livre.titre}"/> :</h2>
<ul>
	<li>Auteur : <c:out value="${livre.auteur.prenom}"/> <c:out value="${livre.auteur.nom}"/></li>
	<li>Nombre de pages : <c:out value="${livre.nbPages}"/></li>
	<li>Categorie : <c:out value="${livre.categorie}"/></li>
</ul>
</body>
</html>