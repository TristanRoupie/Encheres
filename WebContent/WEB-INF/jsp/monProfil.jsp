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
		<h1 class="text-center mt-3 mb-5">Mon Profil</h1>

		<form action="${pageContext.request.contextPath}/connexionInscription"
			method="post">
			<div class="form-group row justify-content-around col-sm-10 offset-sm-1">
				<div class="form-group col-sm-6">
					<div class="form-group row">
						<label for="pseudo" class="col-sm-3 col-form-label">Pseudo :</label>
						<input type="text" name="pseudo" required class="form-control col-sm-5" value="${requestScope.monprofil.pseudo}" placeholder="Pseudo"/>
					</div>
					<div class="form-group row">
						<label for="prenom" class="col-sm-3 col-form-label">Prénom :</label>
						<input id="prenom" type="text" name="prenom" class="form-control col-sm-5" value="${requestScope.monprofil.prenom}" placeholder="Prénom" />
					</div>
					<div class="form-group row">
						<label for="telephone" class="col-sm-3 col-form-label">Téléphone :</label>
						<input id="telephone" type="text" name="telephone" class="form-control col-sm-5" value="${requestScope.monprofil.telephone}" placeholder="Téléphone"/>
					</div>
					<div class="form-group row">
						<label for="codepostal" class="col-sm-3 col-form-label">Code Postal :</label>
						<input id="codepostal" type="text" pattern="[0-9]{5}" name="codepostal" class="form-control col-sm-5" value="${requestScope.monprofil.codepostal}" placeholder="Code postal" />
					</div>	 
					<c:if test="${empty nom}">
						<!-- si il y a pas de nom -->
						<div class="form-group row">
							<label for="mdpnow" class="col-sm-3 col-form-label">Mot de passe :</label>
							<input id="mdpnow" type="password" name="mdpnow" class="form-control col-sm-5" value="${requestScope.monprofil.mdpnow}" placeholder="Mot de passe" />
						</div>
	
					</c:if>
					<c:if test="${!empty nom}">
						<!-- Mot de passe si connecté -->
						<div class="form-group">
							<label for="mdpnow" class="col-sm-3 col-form-label">Mot de passe actuel :</label>
							<input id="mdpnow" type="password" name="mdpnow" class="form-control col-sm-5" placeholder="Mot de passe actuel" />
						</div>
						<div class="form-group">
							<label for="newmdp" class="col-sm-3 col-form-label">Nouveau mot de passe :</label>
							<input id="newmdp" type="password" name="newmdp" class="form-control col-sm-5" placeholder="Nouveau mot de passe" />
						</div>
					</c:if>
				</div>
				<div class="form-group col-sm-6">
					<div class="form-group row">
						<label for="nom" class="col-sm-3 col-form-label">Nom :</label>
						<input type="text" name="nom" id="nom" class="form-control col-sm-5" value="${requestScope.monprofil.nom}" placeholder="Nom" />
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-3 col-form-label">Email :</label>
						<input type="email" name="email" id="email" class="form-control col-sm-5" value="${requestScope.monprofil.email}" placeholder="E-mail" />
					</div>
					<div class="form-group row">
						<label for="rue" class="col-sm-3 col-form-label">Rue :</label>
						<input type="text" name="rue" id="Rue" class="form-control col-sm-5" value="${requestScope.monprofil.Rue}" placeholder="Rue"/>
					</div>
					<div class="form-group row">
						<label for="ville" class="col-sm-3 col-form-label">Ville :</label>
						<input type="text" name="ville" id="ville" class="form-control col-sm-5" value="${requestScope.monprofil.ville}" placeholder="Ville" />
					</div>
					<div class="form-group row">
						<label for="confirmation" class="col-sm-3 col-form-label">Confirmation :</label>
						<input type="password" name="confirmation" id="confirmation" class="form-control col-sm-5" placeholder="Confirmer mot de passe" />
					</div>
				</div>
				<div class="form-group d-flex justify-content-around col-sm-6 mt-5">
					<input type="submit" value="Créer" class="form-control btn btn-info col-sm-4" name="create" />
					<input type="submit" value="Annuler" class="form-control btn btn-info col-sm-4" name="cancel" />
				</div>
			</div>
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