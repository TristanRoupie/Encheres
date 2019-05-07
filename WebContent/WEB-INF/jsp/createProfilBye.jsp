<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Mon Profil</title>
</head>
<body>
	<div class="conteneur">
		<!-- debut du conteneur -->
		<h1>Mon Profil</h1>

		<div class="bloccommerce2">
			<div class="sousbloc3">
				<label for="pseudo">Pseudo :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="pseudo" name="nickname"/>
				</form>
				<br /> <label for="prenom">Prénom :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="prenom" name="firstname"/>
				</form>
				<br /> <label for="telephone">Téléphone :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="telephone" name="phone"/>
				</form>
				<br /> <label for="codepostal">Code Postal :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="codepostal" name="zipcode"/>
				</form>
				<br /> <label for="mdpnow">Mot de passe actuel :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="mdpnow" name="mdpnow"/>
				</form>
				<br /> <label for="newmdp">Nouveau mot de passe :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="newmdp" name="newmdp"/>
				</form>
				<br />
			</div>
			<!-- fin du sousbloc3 -->
			<div class="sousbloc3">
				<label for="nom">Nom :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="nom" name="lastname"/>
				</form>
				<br /> <label for="email">Prénom :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="email"  name="mail"/>
				</form>
				<br /> <label for="rue">Prénom :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="Rue" name="street"/>
				</form>
				<br /> <label for="ville">Ville :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="ville" name="city"/>
				</form>
				<br /> <label for="confirmation">Confirmation :</label>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" class="confirmation" name="confirm" />
				</form>
				<br />
			</div>
			<!-- fin du sousbloc4 -->


		</div>
		<!-- fin du bloccommerce2 -->

		<p>Votre crédit est de :</p>

		<div class="bloccommerce2">
			<div class="sousbloc3">
				<form action="${pageContext.request.contextPath}/connexionInscription" method="get">
					<input class type="submit" value="Créer" class="enregistrer"
						style="height: 100px" name="create" />
				</form>
			</div>
			<div class="sousbloc3">
				<form action="${pageContext.request.contextPath}/creaCompte"
					method="get">
					<input type="submit" value="Annuler" class="supprimer"
						style="height: 100px" name="cancel" />
				</form>
			</div>

		</div>




	</div>
	<!-- fin du conteneur -->
</body>
</html>