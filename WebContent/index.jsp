<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Encheres</title>
</head>
<body>
		<header>
		<nav>
			<ul>
				<li><a href="#">Enchères</a></li>
				<li><a href="#">Vendre un article</a></li>
				<li><a href="#">Mon profil</a></li>
				<li><a href="#">Déconnexion</a></li>			
			</ul>
		</nav>
		
		</header>
		<div id="conteneur">
			<h1>Liste des enchères</h1>
			<div>
				<h3>Filtres</h3>
				<form action="" method="post">
					<input
						type="search"
						value="Article à rechercher"
						style="height: 50px" >
				</form>
				<h3> Catégories</h3>
				<select	name="Catégories" id="Catégories" style="height: 30px">
					<option value="0" hidden>Selectionner une catégorie</option>
					<option value="1">Multimédia</option>
					<option value="2">Loisirs</option>
				</select>
				
		</div>
		<div id="vide" ></div>
		<input type="radio" name="genre" value="homme" checked> Achats
		</div >
		


</body>
</html>