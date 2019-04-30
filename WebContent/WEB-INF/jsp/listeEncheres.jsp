<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/style.css">
<title>Encheres</title>
</head>
<body>
		<header>
		<nav>
		<div id="blocduhaut">
		<form action="${pageContext.request.contextPath}/creacompte.jsp" method="get">
			<input
				type="submit"
				value="S'inscrire"
				>
		</form>
		<form action="${pageContext.request.contextPath}/index.jsp" method="get">
			<input
				type="submit"
				value="Se connecter">
		</form>
		</div>
		</nav>
		
		</header>
		<div id="conteneur">
		
			<h1>Liste des enchères</h1>
		<div id="bloccommerce2">
			<div id="sousbloc3">
					<input
						type="search"
						class="bb"
						value="Article à rechercher"
						style="height: 40px" ><br>
			<select	name="Catégories" id="Catégories" style="height: 30px">
					<option value="0" hidden>Selectionner une catégorie</option>
					<option value="1">Multimédia</option>
					<option value="2">Loisirs</option>
			</select>			
			</div> <!-- fin du sousbloc3 -->
			<div id="sousbloc3">
						<input
							type="search"
							class="bb"
							value="Rechercher"
							style="height:50px">
			</div> <!-- fin du sousbloc3 -->
			
			
		</div><!-- fin du bloccommerce2 -->
		
		
		<div id="bloccommerce">
		<div id="sousbloc1">
		
		<img src="https://dummyimage.com/200X200/000/fff" alt="image du produit" class="imageflottante"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
			tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
			consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
			cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
			proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
		<div id="vide"></div>
		<div id="vide">
 			
		</div>
		<div id="vide">
  			
		</div>
		<div id="vide">
 			
  			</div>
		</div>
		<div id="sousbloc2">
		<img src="https://dummyimage.com/200X200/000/fff" alt="image du produit" class="imageflottante"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
			tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
			consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
			cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
			proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
			</div>
		
		<div id="vide"></div>
		<div id="vide">
 			
		</div>
		<div id="vide">
  			
		</div>
		<div id="vide">
 			
  			</div></div>
		</div> 
		
	</body>
</html>