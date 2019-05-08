<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Detail Vente</title>
</head>
<body>
	<
	<div id="conteneur">
		<label for="objet">Pseudo</label> <input type="text" name="nomObjet"
			class="**" value="${requestScope.utilissateur.pseudo}" />
		<label for="description">Description</label> <input type="text" name="description"
			class="**" value="${requestScope.idArticle.descriptionArticle}" />
		<label for="categorie">Catégorie</label> <input type="text" name="categorie"
			class="**" value="${requestScope.idArticle.descriptionArticle}" />
		<label for="meilleureOffre">Meilleure offre</label> <input type="text"
			name="meilleureOffre" class="**" value="${requestScope.vente.meilleureOffreVente}" />
		<label for="misePrix">Mise a prix</label> <input type="text"
			name="misePrix" class="**" value="${requestScope.misePrix.misPrixVente}" />
		<label for="finEnchere">Fin de l'enchère</label> <input type="text"
			name="finEnchere" class="**" value="${requestScope.finEnchere.finenchereVente}" />
		<label for="retrait">Retrait</label> <input type="text" name="retrait"
			class="**" value="${requestScope.utilisateur.rue.cp.villeUtilisateur}" />
		<label for="vendeur">Vendeur</label> <input type="text" name="vendeur"
			class="**" value="${requestScope.vendeur.vendeurUtilisateur}" />
			<form action="${requestScope.misePrix.misPrixVente}/home" method="get">
			<p>Ma proposition : <input type="number" name="proposition" id="**" min="0">  </p>
			<input type="button" name="encherir" value="Enchérir">
			</form>
	</div>
</body>
</html>