<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

				<form
					action="${pageContext.request.contextPath}/connexionInscription"
					method="post">
					<div class="bloccommerce2">
						<div class="sousbloc3">
							<label for="pseudo">Pseudo</label> <input type="text"
								name="pseudo" class="pseudo"
								value="${requestScope.monprofil.pseudo}" /><br /> <label
								for="prenom">Prénom</label> <input type="text" name="prenom"
								class="prenom" value="${requestScope.monprofil.prenom}"><br />
							<label for="telephone">Téléphone</label> <input type="text"
								name="telephone" class="telephone"
								value="${requestScope.monprofil.telephone}" /><br /> <label
								for="codepostal">Code Postal</label> <input type="text"
								pattern="[0-9]{5}" name="codepostal" class="codeposte"
								value="${requestScope.monprofil.codepostal}" /><br />
							<c:if test="${empty nom}"> <!-- si il y a pas de nom -->



								<label for="mdpnow">Mot de passe</label>
								<input type="password" name="mdpnow" class="mdpnow"
									value="${requestScope.monprofil.mdpnow}" />
								<br />
							</c:if>
							<c:if test="${!empty nom}">
								<!-- Moot de passe si connecté -->
								<label for="newmdp">Nouveau mot de passe</label>
								<input type="password" name="newmdp" class="newmdp" />
								<br />
							</c:if>
						</div>
						<!-- fin du sousbloc3 -->
						<div class="sousbloc3">
							<label for="nom">Nom</label> <input type="text" name="nom"
								class="nom" value="${requestScope.monprofil.nom}" /><br /> <label
								for="email">Email</label> <input type="email" name="email"
								class="email" value="${requestScope.monprofil.email}" /><br />
							<label for="rue">Rue</label> <input type="text" name="rue"
								class="Rue" value="${requestScope.monprofil.Rue}" /><br /> <label
								for="ville">Ville</label> <input type="text" name="ville"
								class="ville" value="${requestScope.monprofil.ville}" /><br />
							<c:if test="${!empty nom}">
								<label for="confirmation">Confirmation</label>
								<input type="password" name="confirmation" class="confirmation" />
								<br />
							</c:if>
						</div>
						<!-- fin du sousbloc4 -->
					</div>
					<!-- fin du bloccommerce2 -->


				</form>
				<c:if test="${empty nom}">

					<form action="${pageContext.request.contextPath}/home" method="get">
						<input type="submit" value="Créer le compte" class="enregistrer"
							style="height: 100px" /> <input type="submit" value="Annuler"
							class="supprimer" style="height: 100px" />
					</form>



				</c:if>
				<c:if test="${!empty nom}">
					<form action="${pageContext.request.contextPath}/connexionInscription"
						method="post">
						<input type="submit" value="Enregistrer" class="enregistrer"
							style="height: 100px" />
					</form>
					<form action="${pageContext.request.contextPath}/home"
						method="post">
						<input type="submit" value="Supprimer mon compte"
							class="supprimer" style="height: 100px" />
					</form>
					<p>Votre crédit est de :${requestScope.monprofil.credit}</p>
				</c:if>
			</div>
			<div class="sousbloc3"></div>
		</div>
	</div>
	<!-- fin du conteneur -->
</body>
</html>