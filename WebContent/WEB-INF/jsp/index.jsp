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
			<div class="blocduhaut">
				<c:if test="${connexion}">
					<form action="${pageContext.request.contextPath}/home" method="get">
						<input type="submit" value="Déconnexion">
					</form>
					<form action="${pageContext.request.contextPath}/monProfil"
						method="get">
						<input type="submit" value="Mon profil">
					</form>
					<form action="${pageContext.request.contextPath}/vendreArticle"
						method="get">
						<input type="submit" value="Vendre un article">
					</form>
				</c:if>
			</div>

			<c:if test="${!connexion}">
				<div class="blocduhaut">
					<form
						action="${pageContext.request.contextPath}/connexionInscription"
						method="get">
						<input type="submit" value="S'inscrire"> <input
							type="submit" value="Se connecter">
					</form>
				</div>
			</c:if>
		</nav>
	</header>
	<div class="conteneur">
		<h1>Liste des enchères</h1>
		<div>
			<h3>Filtres</h3>
			<form action="${pageContext.request.contextPath}/home"
				method="post">
				<div class="bb">
					<input type="search" class="bb" value="Article à rechercher"
						style="height: 40px">
				</div>
			</form>
			<h3>Catégories</h3>
			<div class="bb">
				<form action="${pageContext.request.contextPath}/home"
					method="post">
					<select name="Catégories" class="Catégories" style="height: 30px">
						<option value="0" hidden>Selectionner une catégorie</option>
						<option value="1">Informatique</option>
						<option value="2">Ameublement</option>
						<option value="3">Vêtements</option>
						<option value="4">Sport & loisirs</option>
					</select>
				</form>
			</div>


		</div>
		<div class="bloccommerce">
			<c:if test="${!connexion}">
				<form action="${pageContext.request.contextPath}/Catégorie.java"
					method="post">
					<div class="sousbloc1">
						<input type="radio" class="jj" name="commerce" value="achats"
							checked> Achats

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
							<input type="checkbox" class="ventecours" name="ventecours"
								checked> <label for="ventecours">Mes ventes en
								cours</label>
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
					</div>
				</form>
			</c:if>
		</div>
		<!-- fin bloc commerce -->
		<div class="vide">
			<div class="bloccommerce">
				<div class="sousbloc1">
				<c:if test="${listArticle>0}">
				<%-- <c:forEach var="idObjet" items=""${listArticle}> --%>
					<img src="https://dummyimage.com/200X200/000/fff"
						alt="image du produit" class="imageflottante">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur. Excepteur sint occaecat cupidatat non proident,
						sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
						<%-- </c:forEach> --%>
						</c:if>
				</div>
				<div class="sousbloc2">
				<c:if test="${listArticle>0}">
			<%-- 	<c:forEach var="idObjet" items=""${listArticle}> --%>
					<img src="https://dummyimage.com/200X200/000/fff"
						alt="image du produit" class="imageflottante">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur. Excepteur sint occaecat cupidatat non proident,
						sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
						<%-- </c:forEach> --%>
						</c:if>
				</div>
			</div>
		</div>
		</div>
</body>
</html>