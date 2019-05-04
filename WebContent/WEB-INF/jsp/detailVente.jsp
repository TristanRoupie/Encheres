<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Detail Vente</title>
</head>
<body>
	<div id="conteneur">
		<label for="pseudo">Pseudo</label> <input type="text" name="nomObjet"
			class="**" value="${requestScope.utilissateur.pseudo}" /> <label
			for="pseudo">Description</label> <input type="text" name="nomObjet"
			class="**" value="${requestScope.idArticle.descriptionArticle}" /> <label
			for="pseudo">Catégorie</label> <input type="text" name="nomObjet"
			class="**" value="${requestScope.idArticle.nomArticle}" /> <label
			for="pseudo">Meilleure offre</label> <input type="text"
			name="nomObjet" class="**" value="${requestScope.idObjet.nomObjet}" />
		<label for="pseudo">Mise a prix</label> <input type="text"
			name="nomObjet" class="**" value="${requestScope.idObjet.nomObjet}" />
		<label for="pseudo">Fin de l'enchère</label> <input type="text"
			name="nomObjet" class="**" value="${requestScope.idObjet.nomObjet}" />
		<label for="pseudo">Vendeur</label> <input type="text" name="nomObjet"
			class="**" value="${requestScope.idObjet.nomObjet}" />
	</div>
</body>
</html>