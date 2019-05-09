<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<link rel="stylesheet" href="css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>Encheres</title>
</head>
<body class="bg-light">
	<div class="container-fluid"> <!--debut Containeur principal-->
		<!-- Header et navigation haut de page -->
		<header class="row justify-content-between loulou" >
			<nav class="navbar col-sm-8 loulou ">
				<a href="${pageContext.request.contextPath}/">
				<img src="${pageContext.request.contextPath}/images/logo.png" width="70%" alt="Logo de la société" class="rounded"></a>
			</nav>
			<nav class="navbar col-sm-4 loulou" >
				<c:if test="${!empty sessionScope.utilisateur.pseudo}">
					<ul class="nav">
						<li class="nav-item"><a class="nav-link active"
							href="${pageContext.request.contextPath}/connexionInscription">Déconnexion</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/monProfil">Mon
								profil</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/vendreArticle">Vendre
								un article</a></li>
					</ul>
				</c:if>
				<c:if test="${empty sessionScope.utilisateur.pseudo}">
					<ul class="nav ">
						<li class="nav-item"><a class="nav-link text-info" href="${pageContext.request.contextPath}/monProfil">Inscription</a></li>
						<li class="nav-item"><a class="nav-link text-info" href="${pageContext.request.contextPath}/connexionInscription">Se connecter</a></li>
					</ul>
				</c:if>
			</nav>
		</header>
		<!-- Header et navigation haut de page -->
				<%-- <img src="${pageContext.request.contextPath}/images/titre.png" alt="..." class="text-center col-sm-7 offset-sm-1 mt-3 mb-5"></a> --%>
			<h1 class="text-center text-uppercase">Bien enchères</h1>
			<h4 class="text-center">Le site d'enchères qui vous fait gagner des affaires !</h4>
			<c:if test="${!empty sessionScope.utilisateur.pseudo}">
				<p class="font-italic text-capitalize "> Bienvenue ${sessionScope.utilisateur.pseudo}</p>
			</c:if>

			<h3 class="text-left">Filtres</h3>

			<form action="${pageContext.request.contextPath}/" method="post">
				<div class="form-group col-sm-5">
					<input type="search" class="form-control row col-sm-8" value="Article à rechercher" name="article"> 
				</div>
				<div class="form-group row col-sm-5">
					<label for="categories" class="col-sm-3 col-form-label">Catégories : </label>
					<select name="Catégories" class="form-control col-sm-5" id="categories">
						<option hidden value="0">Selectionner une catégorie</option>
						<!-- A verifier si la value apparait bien sans conflit avec le nom -->
						<option value="${Categorie.getLibelle()}">Informatique</option>
						<option value="${Categorie.getLibelle()}">Ameublement</option>
						<option value="${Categorie.getLibelle()}">Vêtements</option>
						<option value="${Categorie.getLibelle()}">Sport et loisirs</option>
					</select>
				</div>
				<div class="mt-4 mb-4">
					<div class="row">
						<c:if test="${!empty sessionScope.utilisateur.pseudo}">
						<div class="col-sm-4">
						<!-- Bloc Achat -->
							<div class="form-check">
								<input type="radio" class="form-check-input" name="commerce" value="achats" checked id="achats">
							<label for="achats" class="form-check-label">Achats</label>
							</div>
							<div class="form-check ml-4">
								<input type="checkbox" class="form-check-input" name="commerce" value="achats" checked id="enchOuvertes">
								<label for="enchOuvertes" class="form-check-label">Enchères ouvertes</label>
							</div>
							<div class="form-check ml-4">
								<input type="checkbox" class="form-check-input" name="commerce" value="achats" checked id="enchCours">
								<label for="enchCours" class="form-check-label">Mes enchères en cours</label>
							</div>
							<div class="form-check ml-4">
								<input type="checkbox" class="form-check-input" name="commerce" value="achats" checked id="enchRemportee">
								<label for="enchRemportee" class="form-check-label">Mes enchères remportées</label>
							</div>
						</div>
						<div class="col-sm-4">
							<!-- Bloc Vente -->
							<div class="form-check">
								<input type="radio" class="form-check-input" name="commerce" value="achats" checked id="achats">
								<label for="achats" class="form-check-label">Mes ventes</label>
							</div>
							<div class="form-check ml-4">
								<input type="checkbox" class="form-check-input" name="vtesEnCours" value="achats" checked id="vtesEnCours">
								<label for="vtesEnCours" class="form-check-label">Mes ventes en cours</label>
							</div>
							<div class="form-check ml-4">
								<input type="checkbox" class="form-check-input" name="vteNonDebutee" value="achats" checked id="vteNonDebutee">
								<label for="vteNonDebutee" class="form-check-label">Ventes non débutées</label>
							</div>
							<div class="form-check ml-4">
								<input type="checkbox" class="form-check-input" name="vteTerminee" value="achats" checked id="vteTerminee">
								<label for="vteTerminee" class="form-check-label">Ventes terminées</label>
							</div>
						</div>
						</c:if>
						<div class="form-group col-sm-3 mt-3">
							<input type="submit" value="Rechercher" class="form-control btn btn-info" name="rechercher"/>
						</div>
					</div>
				</div>
			</form>	

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
		<footer class="row justify-content-center fixed-bottom" style="background-color: #e3f2fd;">
		<p> <br> <br> </p>
		
		</footer>

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