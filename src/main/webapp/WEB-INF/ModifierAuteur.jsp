<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier un auteur</title>
<link rel="stylesheet" href="inc/menu.css">
</head>
<body>
<c:import url="/WEB-INF/menu.jsp"/>

<div class="formulaire">
	<form method="post" action="<c:url value="/ModifierAuteur"><c:param name="idAuteur" value="${auteur.id}"/></c:url>">
		<fieldset>
			<legend>Modifier un auteur</legend>
			
			<label for="prenomAuteur">Prénom</label>
			<input value="${auteur.prenom}" type="text" id="prenomAuteur" name="prenomAuteur" size="30">
			
			<label for="nomAuteur">Nom</label>
			<input value="${auteur.nom}" type="tel" id="nomAuteur" name="nomAuteur" size="30">
			
			<label for="telephoneAuteur">Téléphone</label>
			<input value="${auteur.telephone}" type="text" id="telephoneAuteur" name="telephoneAuteur" size="10">
			
			<label for="emailAuteur">Adresse mail</label>
			<input value="${auteur.email}" type="email" id="emailAuteur" name="emailAuteur" size="30">
			
		</fieldset>
		<input type="submit" value="Valider">
		<input type="reset" value="Remettre à zéro">
	</form>
</div>
</body>
</html>