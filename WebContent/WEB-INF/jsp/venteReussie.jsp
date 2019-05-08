<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="fr.eni.encheres.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<link rel="stylesheet" href="css/bootstrap-reboot.min.css">
<title>ENI Enchères</title>
</head>
<body class="bg-light">	
		<div class="container-fluid">
			<div class="row ">	
			<a href="${pageContext.request.contextPath}/home">
			<img src="${pageContext.request.contextPath}/images/logo.png" alt="..." class="rounded float-left"></a>
			<h1 class="text-center col-sm-7 offset-sm-1 mt-3 mb-5">Bien enchères</h1>
		</div>
			<c:choose>
				<c:when test="${Date > Enchere.article.finEnchere}">
					<h1 class="text-center mt-3 mb-5">Détail vente</h1>
					<jsp:include page="detailVente.jsp">
				</c:when>
				<c:otherwise>
					<c:if
						test="${empty idUtilisateur || idUtilisateur != Enchere.idUtilisateur || idUtilisateur != Enchere.article.vendeur.id}">
						<h1 class="text-center mt-3 mb-5">L'enchère est terminée</h1>
					</c:if>
					<c:if test="${currentUser.id == Enchere.idUtilisateur}">
						<h3 class="text-center mt-3 mb-5">Vous avez remporté la vente</h3>
					</c:if>
					<c:if test="${currentUser.id == Enchere.article.vendeur}">
						<h3 class="text-center mt-3 mb-5">${Enchere.utilisateur.pseudo}a remporté
							l'enchère !</h3>
					</c:if>
				</c:otherwise>
			</c:choose>
	
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>