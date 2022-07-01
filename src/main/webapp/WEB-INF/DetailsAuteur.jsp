<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>D�tails auteur</title>
<link rel="stylesheet" href="inc/menu.css">
</head>
<body>

<c:import url="/WEB-INF/menu.jsp"/>

<h2>D�tails concernant <c:out value="${auteur.prenom}"/> <c:out value="${auteur.nom}" /> :</h2>
<ul>
	<li>T�l�phone : <c:out value="${auteur.telephone}"/></li>
	<li>Adresse mail : <c:out value="${auteur.email}"/></li>
</ul>
</body>
</html>