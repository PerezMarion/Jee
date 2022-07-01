<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des livres</title>
<link rel="stylesheet" href="inc/menu.css">
</head>
<body>

<c:import url="/WEB-INF/menu.jsp"/>

<h2>Liste des livres : </h2>
	<c:choose>
		<c:when test="${empty listeLivres}">
			Aucun livre trouvé.
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Titre</th>
					<th>Auteur</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${listeLivres}" var="livre">
				<tr>
					<td><c:out value="${livre.titre}"></c:out></td>
					<td><c:out value="${livre.auteur.prenom}"></c:out> <c:out value="${livre.auteur.nom}"></c:out></td>
					<td>
						<a href="<c:url value="/DetailsLivre"><c:param name="id" value="${livre.id}"/></c:url>">Voir</a>
						<a href="<c:url value="/ModifierLivre"><c:param name="id" value="${livre.id}"/></c:url>">Modifier</a>
						<a href="<c:url value="/SupprimerLivre"><c:param name="id" value="${livre.id}"/></c:url>">Supprimer</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>