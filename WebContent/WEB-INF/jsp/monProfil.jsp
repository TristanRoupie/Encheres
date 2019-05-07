<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<link rel="stylesheet" href="css/bootstrap-reboot.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Mon Profil</title>
</head>
<body>
	<div class="container-fluid">
		<!-- debut du conteneur -->
		<h1 class="text-center mt-3 mb-3">Mon Profil</h1>

		<form action="${pageContext.request.contextPath}/connexionInscription"
			method="post">
			<div class="form-group row justify-content-around col-sm-10 offset-sm-1">
				<div class="form-group col-sm-6 bg-primary">
					<div class="form-group">
						<label for="pseudo">Pseudo</label>
						<input type="text" name="pseudo" required class="pseudo" value="${requestScope.monprofil.pseudo}" placeholder="pseudo"/>
					</div>
					<div class="form-group">
						<label for="prenom">Prénom</label>
						<input type="text" name="prenom" class="prenom" value="${requestScope.monprofil.prenom}" placeholder="prénom" />
					</div>
					<div class="form-group">
						<label for="telephone">Téléphone</label>
						<input type="text" name="telephone" class="telephone" value="${requestScope.monprofil.telephone}" placeholder="téléphone"/>
					</div>
					<div class="form-group">
						<label for="codepostal">Code Postal</label>
						<input type="text" pattern="[0-9]{5}" name="codepostal" class="codeposte" value="${requestScope.monprofil.codepostal}" placeholder="Code postal" />
					</div>	 
					<c:if test="${empty nom}">
						<!-- si il y a pas de nom -->
						<div class="form-group">
							<label for="mdpnow">Mot de passe</label>
							<input type="password" name="mdpnow" class="mdpnow" value="${requestScope.monprofil.mdpnow}" placeholder="mot de passe" />
						</div>
	
					</c:if>
					<c:if test="${!empty nom}">
						<!-- Mot de passe si connecté -->
						<div class="form-group">
							<label for="mdpnow">Mot de passe actuel</label>
							<input id="mdpnow" type="password" name="mdpnow" placeholder="Mot de passe actuel" />
						</div>
						<div class="form-group">
							<label for="newmdp">Nouveau mot de passe</label>
							<input type="password" name="newmdp" placeholder="Nouveau mot de passe" />
						</div>
					</c:if>
				</div>
				<div class="form-group col-sm-6 bg-info">
					<div class="form-group">
						<label for="nom">Nom</label>
						<input type="text" name="nom" class="nom" value="${requestScope.monprofil.nom}" />
					</div>
					<div class="form-group">
						<label for="email">Email</label>
						<input type="email" name="email" class="email" value="${requestScope.monprofil.email}" placeholder="E-mail" />
					</div>
					<div class="form-group">
						<label for="rue">Rue</label>
						<input type="text" name="rue" class="Rue" value="${requestScope.monprofil.Rue}" />
					</div>
					<div class="form-group">
						<label for="ville">Ville</label>
						<input type="text" name="ville" class="ville" value="${requestScope.monprofil.ville}" placeholder="ville" />
					</div>
					<div class="form-group">
						<label for="confirmation">Confirmation</label>
						<input type="password" name="confirmation" class="confirmation" placeholder="confirmer mot de passe" />
					</div>
				</div>
				<div class="form-group row">
					<input type="submit" value="Créer" class="form-control btn btn-info col-sm-6" name="create" />
					<input type="submit" value="Annuler" class="form-control btn btn-info col-sm-6" name="cancel" />
				</div>
			</div>
		</form>
		<form action="${pageContext.request.contextPath}/home">
			<input type="submit" value="Annuler" class="supprimer" name="cancel" />
		</form>

		<c:if test="${empty nom}">

			<%-- <form action="${pageContext.request.contextPath}/home" method="get">
						
					</form> --%>

		</c:if>
		<c:if test="${!empty nom}">
			<form
				action="${pageContext.request.contextPath}/connexionInscription"
				method="post">
				<input type="submit" value="Enregistrer" class="enregistrer"
					name="save" />
			</form>
			<form action="${pageContext.request.contextPath}/home" method="post">
				<input type="submit" value="Supprimer mon compte" class="supprimer"
					name="delete" />
			</form>
			<p>Votre crédit est de :${requestScope.monprofil.credit}</p>
		</c:if>
	</div>
</body>
</html>