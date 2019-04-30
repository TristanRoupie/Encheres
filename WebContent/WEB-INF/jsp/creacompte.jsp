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
	<div id="conteneur">
		<h1>Eni-Enchères</h1>
	<div id="bloccommerce2">
	<div id="sousbloc3">
		<h4>Identifiant</h4>	
	</div> <!-- fin du sousbloc -->
	<div id="soubloc3">
		<form action="${pageContext.request.contextPath}" method="post">
			<input
				class="bloclogin"
				type="text" 
				name="login"
				size="15" />
			</form>		
	</div> <!-- fin du sousbloc -->	
	</div>	<!-- fin du bloccommerce -->
	
	<div id="bloccommerce2">
	<div id="sousbloc3">
		<h4>Mot de passe</h4>	
	</div> <!-- fin du sousbloc -->
	<div id="soubloc3">
		<form action="${pageContext.request.contextPath}" method="post">
			<input
				class="bloclogin"
				type="text" 
				name="mdp" 
				size="15" />
			</form>		
	</div> <!-- fin du sousbloc -->	
	</div>	<!-- fin du bloccommerce -->
	<div id="bloccommerce">
	<div id="sousbloc3">
		<form action="${pageContext.request.contextPath}/index.jsp" method="get">
			<input id
				type="submit"
				class="supprimer"
				value="Connexion"
				style="height: 100px"/>
		</form>
	</div>
	<div id="sousbloc3">
		<form action="${pageContext.request.contextPath}/createprofil.jsp" method="get">
			<input id
				type="submit"
				class="supprimer"
				value="Créer un compte"
				style="height: 100px"/>
		</form>
	</div>
	</div>
	
	</div><!-- Fin du conteneur -->
</body>
</html>