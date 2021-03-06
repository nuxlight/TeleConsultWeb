<%@page import="org.springframework.context.annotation.Import"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
	<!-- Imports CSS -->
	<link href="resources/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="resources/css/teleconsult.css">
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="conteneurContenu">

				<h1 > Liste des médecins </h1>
				<table id="medecins" >
				<thead>
					<tr>
						<th> Nom </th>
						<th> Prénom </th>
						<th> Spécialité   </th>
						<th> Rôle   </th>
						<th> Structure de santé   </th>
						<th> Consultations   </th>
						<th> Actions </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="medecin" items="${medecin}">
						<tr >
							<td> ${medecin.nom} </td>
							<td> ${medecin.prenom} </td>
							<td> ${medecin.specialite.nom} </td>
							<td> ${medecin.role} </td>
							<td> ${medecin.dmpcstructuresante.nom} </td>
							<td> </td>
							<td>
								<a href="modifier?id=${medecin.id}">Modifier</a>
								<a href="delete?id=${medecin.id}">Supprimer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	

	</div>
</body>
<!-- Imports JS -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="resources/js/accueil.js"></script>
</html>