<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>Mon Profil</title>
</head>
<body>
	<div id="conteneur"> <!-- debut du conteneur -->
		<h1>Mon Profil</h1>
		
		<div id="bloccommerce2">
			<div id="sousbloc3">
		<label for="pseudo">Pseudo :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="pseudo" /></form><br />
		<label for="prenom">Prénom :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="prenom" /></form><br />
		<label for="telephone">Téléphone :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="telephone" /></form><br />
		<label for="codepostal">Code Postal :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="codepostal" /></form><br />
		<label for="mdpnow">Mot de passe actuel :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="mdpnow" /></form><br />
		<label for="newmdp">Nouveau mot de passe :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="newmdp" /></form><br />
			</div> <!-- fin du sousbloc3 -->
			<div id="sousbloc3">
		<label for="nom">Nom :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="nom"  /></form><br />
		<label for="email">Prénom :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="email"/></form><br />
		<label for="rue">Prénom :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="Rue" /></form><br />
		<label for="ville">Ville :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="ville" /></form><br />
		<label for="confirmation">Confirmation :</label><form action="${pageContext.request.contextPath}"method="get"><input type="text" id="confirmation" /></form><br />
			</div> <!-- fin du sousbloc4 -->
			
			
		</div><!-- fin du bloccommerce2 -->
		
		<p>Votre crédit est de :</p>
		
		<div id="bloccommerce2">
		<div id="sousbloc3">
		<form action="${pageContext.request.contextPath}" method="get">
			<input id
				type="submit"
				value="Enregistrer"
				class="enregistrer"
				style="height: 100px"/>
		</form>
		</div>
		<div id="sousbloc3">
		<form action="${pageContext.request.contextPath}/creaCompte" method="get">
			<input id
				type="submit"
				value="Annuler"
				class="supprimer"
				style="height: 100px"/>
		</form>
		</div>
		
		</div>
	
	
	
	
	</div><!-- fin du conteneur -->
</body>
</html>