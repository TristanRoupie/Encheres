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
		<header class="row justify-content-between loulou" >
			<nav class="navbar col-sm-8 loulou ">
				<a href="${pageContext.request.contextPath}/">
				<img src="${pageContext.request.contextPath}/images/logo.png" width="70%" alt="Logo de la société" class="rounded"></a>
			</nav>			
		</header>
		<h1 class="text-center mt-3 mb-5">Bien enchères</h1>
		
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
	<footer class="row justify-content-center fixed-bottom riri loulou " >
			<a href="mailto:someone@yoursite.com" class="d-flex align-items-center">Envoyer un mail</a>		
		</footer>
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