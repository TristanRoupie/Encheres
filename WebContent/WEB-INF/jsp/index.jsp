<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Encheres</title>
</head>
<body>
			<header>
			<nav>
			<c:if test="${connexion}">
				<a href="${pageContext.request.contextPath}/home">
					<input type="submit" value="Déconnexion" id="boutonnav">
				</a>
				<a href="${pageContext.request.contextPath}/monProfil">
					<input type="submit" value="Mon Profil" id="boutonnav">
				</a>
				<a href="${pageContext.request.contextPath}/vendreArticle">
					<input type="submit" value="Vendre un article" id="boutonnav">
				</a>					
			</c:if>
			<c:if test="${!connexion}">
				<a href="${pageContext.request.contextPath}/monProfil">
					<input type="submit" value="S'inscrire" id="boutonnav">
				</a>
				<a href="${pageContext.request.contextPath}/connexionInscription">
					<input type="submit" value="Se connecter" id="boutonnav">
				</a>
			</c:if>
			</nav>
		</header>

	<div id="conteneur">
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


			<div id="bb">
				<select name="Catégories" id="Catégories" style="height: 30px">
					<option value="0" hidden>Selectionner une catégorie</option>
					<!-- A verifier si la value apparait bien sans conflit avec le nom -->
					<option value="${Categorie.getLibelle()}">Informatique</option>
					<option value="${Categorie.getLibelle()}"">Ameublement</option>
					<option value="${Categorie.getLibelle()}"">Vêtements</option>
					<option value="${Categorie.getLibelle()}"">Sport & loisirs</option>
				</select>

	
			</div>
			</form>
	</div>



	<div class="bloccommerce">
		<c:if test="${!connexion}">
			<form action="${pageContext.request.contextPath}/Catégorie.java" method="post">
				<div class="sousbloc1">
					<input type="radio" class="jj" name="commerce" value="achats"
						checked> Achats
		
	</div>
	<div id="sousbloc2">


		<div class="vide"></div>
		<div class="vide">
			<input type="checkbox" class="enchouverte" name="enchouverte" checked>
			<label for="enchouverte">Enchères ouvertes</label>
		</div>
		<div class="vide">
			<input type="checkbox" class="enchcours" name="enchcours"> <label
				for="enchcours">Enchères en cours</label>
		</div>
		<div class="vide">
			<input type="checkbox" class="enchremportes" name="enchremportes"
				checked> <label for="enchremportes">Enchères
				remportées</label>
		</div>
	</div>
	<div class="sousbloc2">
		<input type="radio" class="jj" name="commerce" value="ventes" checked>Mes
		ventes
		<div id="vide"></div>
		<div id="vide">
			<input type="checkbox" id="ventecours" name="ventecours" checked>
			<label for="ventecours">Mes ventes en cours</label>
		</div>
		<div id="vide">
			<input type="checkbox" id="ventenondébut" name="ventenondébut">
			<label for="ventenondébut">Ventes non débutées</label>
		</div>
		<div id="vide">
			<input type="checkbox" id="ventetermine" name="ventetermine" checked>
			<label for="ventetermine">Ventes terminées</label>
		</div>
		<input type="submit" value="Rechercher" />
	</div>

</form>
</c:if>
	</div>
	
	

	

	
	
		<div id="bloccommerce">
			
				
				

				
					
						<div class="bloccommerce">
							<div class="sousbloc1">
								<c:if test="${listArticle.size()>0}">
									 <c:forEach var="element" items="${listArticle}"> <!-- Boucle permettant de chercher l'article dans une liste et de l'afficher apres -->
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
	
	
</body>
</html>