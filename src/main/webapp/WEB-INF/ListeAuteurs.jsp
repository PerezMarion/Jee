<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des auteurs</title>
<link rel="stylesheet" href="inc/menu.css">
</head>
<body>
<c:import url="/WEB-INF/menu.jsp"/>
<h2>Liste des auteurs : </h2>
	<c:choose>
		<c:when test="${empty listeAuteurs}">
			Aucun auteur trouvé.
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Prenom</th>
					<th>Nom</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${listeAuteurs}" var="auteur">
				<tr>
					<td><c:out value="${auteur.prenom}"></c:out></td>
					<td><c:out value="${auteur.nom}"></c:out></td>
					<td>
						<a href="<c:url value="/DetailsAuteur"><c:param name="id" value="${auteur.id}"/></c:url>">Voir</a>
						<a href="<c:url value="/ModifierAuteur"><c:param name="id" value="${auteur.id}"/></c:url>">Modifier</a>
						<a href="<c:url value="/SupprimerAuteur"><c:param name="id" value="${auteur.id}"/></c:url>">Supprimer</a>
						
					</td>
					
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>