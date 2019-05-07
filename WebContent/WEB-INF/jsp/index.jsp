<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Encheres</title>
</head>
<body>
	<div class="container-fluid">
		<!--debut Containeur principal-->
		<header class="row justify-content-end ">
			<nav>
				<!-- <c:if test="${utilisateur}"> -->
				<a href="${pageContext.request.contextPath}/home"> <input
					value="Déconnexion" type="button" class="btn btn-outline-primary">
				</a> <a href="${pageContext.request.contextPath}/monProfil"> <input
					type="submit" value="Mon Profil" class="btn btn-outline-primary">
				</a> <a href="${pageContext.request.contextPath}/vendreArticle"> <input
					type="submit" value="Vendre un article"
					class="btn btn-outline-primary">
				</a>
				<!-- </c:if> -->
				<!-- <c:if test="${!utilisateur}">  -->
				<a href="${pageContext.request.contextPath}/monProfil"> <input
					value="S'inscrire" type="button" class="btn btn-outline-primary">
				</a> <a href="${pageContext.request.contextPath}/connexionInscription">
					<input type="submit" value="Se connecter"
					class="btn btn-outline-primary">
				</a>
				<!-- </c:if>-->
			</nav>
		</header>
		<div>
		<h2>${requestScope.session.pseudo}</h2>
		
			<h1 class="row justify-content-center">
				<a href="${pageContext.request.contextPath}/home">Liste des
					enchères</a>
			</h1>
			<!-- lien sur le nom du site renvoyant a l'accueil, a modifier sur toutes les jsp -->

			<h3 class="row justify-content-center">Filtres</h3>

			<form action="${pageContext.request.contextPath}/" method="post"
				class="row justify-content-around">

				<!-- Adresse a definir via la servlet -->


				<input type="search" class="form-control"
					value="Article à rechercher" style="height: 40px"> <select
					name="Catégories" class="form-control" style="height: 30px">
					<option hidden value="0">Selectionner une catégorie</option>
					<!-- A verifier si la value apparait bien sans conflit avec le nom -->
					<option value="${Categorie.getLibelle()}">Informatique</option>
					<option value="${Categorie.getLibelle()}">Ameublement</option>
					<option value="${Categorie.getLibelle()}">Vêtements</option>
					<option value="${Categorie.getLibelle()}">Sport et loisirs</option>
				</select>
				<c:if test="${!connexion}">
					<input type="radio" class="form-control" name="commerce"
						value="achats" checked> Achats
				
					
					
							<input type="checkbox" class="form-control" name="enchouverte"
						checked>
					<label for="enchouverte">Enchères ouvertes</label>


					<input type="checkbox" class="form-control" name="enchcours">
					<label for="enchcours">Enchères en cours</label>


					<input type="checkbox" class="form-control" name="enchremportes"
						checked>
					<label for="enchremportes">Enchères remportées</label>


					<!-- Fin du bloc 2 (blue) -->
					<div class="col">
						<!-- Debut du bloc 2 (blue) -->
						<input type="radio" class="form-group" name="commerce"
							value="ventes" checked>Mes ventes <input type="checkbox"
							class="form-group" name="ventecours" checked> <label
							for="ventecours">Mes ventes en cours</label> <input
							type="checkbox" class="form-group" name="ventenondébut">
						<label for="ventenondébut">Ventes non débutées</label> <input
							type="checkbox" class="form-group" name="ventetermine" checked>
						<label for="ventetermine">Ventes terminées</label>

					</div>
					<!-- Fin du bloc 2 (blue) -->

					<!-- Debut du bloc 2 (blue) -->
					<input type="submit" value="Rechercher" class="form-group" />

					<!-- Fin du bloc 2 (blue) -->
				</c:if>
			</form>
		</div>

	</div>

	<div class="col-4">
		<!--debut du bloc 1 (yellow) -->






	</div>
	<!-- fin du bloc 1 (yellow)-->

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

	<!--Fin Containeur principal-->
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