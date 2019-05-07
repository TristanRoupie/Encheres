<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css"> --%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Encheres</title>
</head>
<body>
	<div class=""container-fluid"">
		<header>
			<nav>
				<!-- <c:if test="${utilisateur}"> -->
					<a href="${pageContext.request.contextPath}/home"> <input
						type="submit" value="Déconnexion" class="boutonnav">
					</a>
					<a href="${pageContext.request.contextPath}/monProfil"> <input
						type="submit" value="Mon Profil" class="boutonnav">
					</a>
					<a href="${pageContext.request.contextPath}/vendreArticle"> <input
						type="submit" value="Vendre un article" class="boutonnav">
					</a>
				<!-- </c:if> -->
				<!-- <c:if test="${!utilisateur}">  -->
					<a href="${pageContext.request.contextPath}/monProfil"> <input
						type="submit" value="S'inscrire" class="boutonnav">
					</a>
					<a href="${pageContext.request.contextPath}/connexionInscription">
						<input type="submit" value="Se connecter" class="boutonnav">
					</a>
				<!-- </c:if>-->
			</nav>
		</header>

		<h1>
			<a href="${pageContext.request.contextPath}/home">Liste des
				enchères</a>
		</h1>
		<!-- lien sur le nom du site renvoyant a l'accueil, a modifier sur toutes les jsp -->

		<h3>Filtres</h3>

		<form action="${pageContext.request.contextPath}/" method="post">
			<!-- Adresse a definir via la servlet -->

			<div class="bb">
				<input type="search" class="bb" value="Article à rechercher"
					style="height: 40px">
			</div>

			<div class="bb">
				<select name="Catégories" class="Catégories" style="height: 30px">
					<option hidden value="0">Selectionner une catégorie</option>
					<!-- A verifier si la value apparait bien sans conflit avec le nom -->
					<option value="${Categorie.getLibelle()}">Informatique</option>
					<option value="${Categorie.getLibelle()}">Ameublement</option>
					<option value="${Categorie.getLibelle()}">Vêtements</option>
					<option value="${Categorie.getLibelle()}">Sport et loisirs</option>
				</select>
			</div>
		</form>
	

	<div class="bloccommerce">
		<c:if test="${!connexion}">
			<form action="${pageContext.request.contextPath}/Catégorie.java"
				method="post">
				<div class="sousbloc1">
					<input type="radio" class="jj" name="commerce" value="achats"
						checked> Achats
				</div>
				<div class="sousbloc2">
					<div class="vide"></div>
					<div class="vide">
						<input type="checkbox" class="enchouverte" name="enchouverte"
							checked> <label for="enchouverte">Enchères
							ouvertes</label>
					</div>
					<div class="vide">
						<input type="checkbox" class="enchcours" name="enchcours">
						<label for="enchcours">Enchères en cours</label>
					</div>
					<div class="vide">
						<input type="checkbox" class="enchremportes" name="enchremportes"
							checked> <label for="enchremportes">Enchères
							remportées</label>
					</div>
				</div>
				<div class="sousbloc2">
					<input type="radio" class="jj" name="commerce" value="ventes"
						checked>Mes ventes
					<div class="vide"></div>
					<div class="vide">
						<input type="checkbox" class="ventecours" name="ventecours" checked>
						<label for="ventecours">Mes ventes en cours</label>
					</div>
					<div class="vide">
						<input type="checkbox" class="ventenondébut" name="ventenondébut">
						<label for="ventenondébut">Ventes non débutées</label>
					</div>
					<div class="vide">
						<input type="checkbox" class="ventetermine" name="ventetermine"
							checked> <label for="ventetermine">Ventes
							terminées</label>
					</div>
					<input type="submit" value="Rechercher" />
				</div>

			</form>
		</c:if>
	</div>

	<div class="bloccommerce">
		<div class="sousbloc1">
			<c:if test="${listArticle.size()>0}">
				<c:forEach var="element" items="${listArticle}">
					<!-- Boucle permettant de chercher l'article dans une liste et de l'afficher apres -->
					<img src="https://dummyimage.com/200X200/000/fff"
						alt="image du produit" class="imageflottante">

					<ul>
						<!-- creation d'une liste avec les requettes pour récuperer les infos de la base de données -->
						<li>${ art.getNomArticle()}</li>
						<li>${ art.getPrixVente()}</li>
						<li>${ art.getDateFinEncheres().getDay()}/${ art.getDateFinEncheres().getMonth()}/${ art.getDateFinEncheres().getYear()}</li>
						<li>Vendeur: ${ art.getVendeur().getPseudo()}</li>

					</ul>
				</c:forEach>
			</c:if>

		</div>
		<div class="sousbloc2">
			<c:if test="${listArticle.size()>0}">
				<c:forEach var="element" items="${listArticle}">
					<img src="https://dummyimage.com/200X200/000/fff"
						alt="image du produit" class="imageflottante">

					<ul>
						<!-- creation d'une liste avec les requettes pour récuperer les infos de la base de données -->
						<li>${ art.getNomArticle()}</li>
						<li>${ art.getPrixVente()}</li>
						<li>${ art.getDateFinEncheres().getDay()}/${ art.getDateFinEncheres().getMonth()}/${ art.getDateFinEncheres().getYear()}</li>
						<li>Vendeur: ${ art.getVendeur().getPseudo()}</li>
					</ul>

				</c:forEach>
			</c:if>

		</div>
	</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>