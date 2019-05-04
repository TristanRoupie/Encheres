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
	<div class="conteneur">
		<h1><a href="${pageContext.request.contextPath}/home"></a>Eni-Enchères</h1>
		<div class="bloccommerce2">
			<div class="sousbloc3">
				<h4>identifiant</h4>
			</div>
			<!-- fin du sousbloc -->
			<div class="soubloc3">
				<form action="${pageContext.request.contextPath}" method="post">
					<input class="bloclogin" type="text" name="login" size="15" />
				</form>
			</div>
			<!-- fin du sousbloc -->
		</div>
		<!-- fin du bloccommerce -->

		<div class="bloccommerce2">
			<div class="sousbloc3">
				<h4>Mot de passe</h4>
			</div>
			<!-- fin du sousbloc -->
			<div class="soubloc3">
				<form action="${pageContext.request.contextPath}" method="post">
					<input class="bloclogin" type="text" name="mdp" size="15" />
				</form>
			</div>
			<!-- fin du sousbloc -->
		</div>
		<!-- fin du bloccommerce -->
		<div class="bloccommerce">
			<div class="sousbloc3">
				<form action="${pageContext.request.contextPath}/monProfil" method="get">
					<input type="submit" class="supprimer" value="Connexion"
						name="connexion" />
					<div class="sousbloc3">
						<input type="submit" class="supprimer" value="Créer un compte"
							name="supprimer" />
					</div>
				</form>
			</div>

		</div>

	</div>
	<!-- Fin du conteneur -->
</body>
</html>