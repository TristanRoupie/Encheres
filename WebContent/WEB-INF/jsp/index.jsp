<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<c:if test="${! connexion}">
				<div id="blocduhaut">
					<form action="${pageContext.request.contextPath}/home"
						method="get">
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
					<form action="${pageContext.request.contextPath}" method="get">
						<input type="submit" value="Enchères">
					</form>			
				</div>
				</c:if>
				<c:if
		</nav>
	</header>
	<div id="conteneur">
		<h1>Liste des enchères</h1>
		<div>
			<h3>Filtres</h3>
			<form action="" method="post">
				<div id="bb">
					<input type="search" class="bb" value="Article à rechercher"
						style="height: 40px">
				</div>
			</form>
			<h3>Catégories</h3>
			<div id="bb">
				<select name="Catégories" id="Catégories" style="height: 30px">
					<option value="0" hidden>Selectionner une catégorie</option>
					<option value="1">Informatique</option>
					<option value="2">Ameublement</option>
					<option value="3">Vêtements</option>
					<option value="4">Sport & loisirs</option>
			</div>
			</select>

		</div>
		<div id="bloccommerce">
			<div id="sousbloc1">
				<input type="radio" class="jj" name="commerce" value="achats"
					checked> Achats

				<div id="vide"></div>
				<div id="vide">
					<input type="checkbox" id="enchouverte" name="enchouverte" checked>
					<label for="enchouverte">Enchères ouvertes</label>
				</div>
				<div id="vide">
					<input type="checkbox" id="enchcours" name="enchcours"> <label
						for="enchcours">Enchères en cours</label>
				</div>
				<div id="vide">
					<input type="checkbox" id="enchremportes" name="enchremportes"
						checked> <label for="enchremportes">Enchères
						remportées</label>
				</div>
			</div>
			<div id="sousbloc2">
				<input type="radio" class="jj" name="commerce" value="ventes"
					checked>Mes ventes

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
					<input type="checkbox" id="ventetermine" name="ventetermine"
						checked> <label for="ventetermine">Ventes
						terminées</label>
				</div>
			</div>
		</div>
		<div id="vide">
			<div id="bloccommerce">
				<div id="sousbloc1">
					<img src="https://dummyimage.com/200X200/000/fff"
						alt="image du produit" class="imageflottante">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur. Excepteur sint occaecat cupidatat non proident,
						sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
				</div>
				<div id="sousbloc2">
					<img src="https://dummyimage.com/200X200/000/fff"
						alt="image du produit" class="imageflottante">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur. Excepteur sint occaecat cupidatat non proident,
						sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
				</div>
			</div>

		</div>
</body>
</html>