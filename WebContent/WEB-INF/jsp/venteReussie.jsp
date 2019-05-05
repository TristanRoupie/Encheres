<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id=conteneur>
			<c:choose>
				<c:when test="${Date > Enchere.article.finEnchere}">
					<h1>Détail vente</h1>
					<jsp:include page="detailVente.jsp">
				</c:when>
				<c:otherwise>
					<c:if
						test="${empty idUtilisateur || idUtilisateur != Enchere.idUtilisateur || idUtilisateur != Enchere.article.vendeur.id}">
						<h1>L'enchère est terminée</h1>
					</c:if>
					<c:if test="${currentUser.id == Enchere.idUtilisateur}">
						<h3>Vous avez remporté la vente</h3>
					</c:if>
					<c:if test="${currentUser.id == Enchere.article.vendeur}">
						<h3>${Enchere.utilisateur.pseudo}a remporté
							l'enchère !</h3>
					</c:if>
				</c:otherwise>
			</c:choose>
	
	</div>

</body>
</html>