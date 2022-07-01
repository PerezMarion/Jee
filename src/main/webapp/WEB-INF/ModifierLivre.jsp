<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier un livre</title>
<link rel="stylesheet" href="inc/menu.css">
</head>
<body>
<c:import url="/WEB-INF/menu.jsp"/>

<div class="formulaire">
	<form method="post" action="<c:url value="/ModifierLivre"><c:param name="id" value="${livre.id}"/></c:url>">
		<fieldset>
			<legend>Modifier un livre</legend>
			
			<label for="titre">Titre</label>
			<input value="${livre.titre}" type="text" id="titre" name="titre" size="30">
			
			<label for="idAuteur">Auteur</label>
			<select id="idAuteur" name="idAuteur">
				<c:forEach items="${listeAuteurs}" var="auteur">
				<option ${auteur.id == livre.auteur.id ? "selected":""} value="${auteur.id}">${auteur.prenom} ${auteur.nom}</option>
				</c:forEach>
			</select>
			
			<label for="nbPages">Nombre de pages</label>
			<input value="${livre.nbPages}" type="text" id="nbPages" name="nbPages" size="10">
			
			<label for="categorie">Categorie</label>
			<input value="${livre.categorie}" type="text" id="categorie" name="categorie" size="30">
		</fieldset>
		<input type="submit" value="Valider">
		<input type="reset" value="Remettre à zéro">
	</form>
</div>
</body>
</html>