<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<link rel="stylesheet" href="css/bootstrap-reboot.min.css">

<title>Mon Profil</title>
</head>
<body class="bg-light">
	<div class="container-fluid">
		<div class="row ">	
			<a href="${pageContext.request.contextPath}/">
			<img src="${pageContext.request.contextPath}/images/logo.png" alt="..." class="rounded float-left"></a>
			<h1 class="text-center col-sm-7 offset-sm-1 mt-3 mb-5">Mon Profil</h1>
		</div>	
			
		
		<form action="${pageContext.request.contextPath}/connexionInscription"
			method="post">
			<div class="form-group row justify-content-around col-sm-10 offset-sm-1">
				<div class="form-group col-sm-6"> <!-- BLOC de Gauche -->
					<div class="form-group row">
						<label for="pseudo" class="col-sm-3 col-form-label">Pseudo :</label>
						<input type="text" name="pseudo" value="${empty sessionScope.utilisateur.pseudo ? '' : sessionScope.utilisateur.pseudo }" required class="form-control col-sm-5" placeholder="Pseudo"/>
					</div>
					<div class="form-group row">
						<label for="prenom" class="col-sm-3 col-form-label">Prénom :</label>
						<input id="prenom" type="text" name="prenom" value="${empty sessionScope.utilisateur.prenom ? '' : sessionScope.utilisateur.prenom }" class="form-control col-sm-5" placeholder="Prénom" />
					</div>
					<div class="form-group row">
						<label for="telephone" class="col-sm-3 col-form-label">Téléphone :</label>
						<input id="telephone" type="text" name="telephone" value="${empty sessionScope.utilisateur.telephone ? '' : sessionScope.utilisateur.telephone }" class="form-control col-sm-5"  placeholder="Téléphone"/>
					</div>
					<div class="form-group row">
						<label for="codepostal" class="col-sm-3 col-form-label">Code Postal :</label>
						<input id="codepostal" type="text" pattern="[0-9]{5}" name="codepostal" value="${empty sessionScope.utilisateur.codePostal ? '' : sessionScope.utilisateur.codePostal }" class="form-control col-sm-5" placeholder="Code postal" />
					</div>	 
					<c:if test="${empty sessionScope.utilisateur.pseudo}">
						<!-- si il y a pas de nom -->
						<div class="form-group row">
							<label for="mdpnow" class="col-sm-3 col-form-label">Mot de passe :</label>
							<input id="mdpnow" type="password" name="mdpnow" class="form-control col-sm-5" value="${empty sessionScope.utilisateur.motDePasse ? '' : sessionScope.utilisateur.motDePasse }" placeholder="Mot de passe" />
						</div>	
					</c:if>
					<c:if test="${!empty sessionScope.utilisateur.pseudo}">
						<!-- Mot de passe si connecté -->						
						<div class="form-group row">
							<label for="mdpnow" class="col-sm-3 col-form-label">Mot de passe actuel :</label>
							<input id="mdpnow" type="password" name="mdpnow" class="form-control col-sm-5" placeholder="Mot de passe actuel" />
						</div>
						<div class="form-group row">
						 <p>Votre crédit est : ${empty sessionScope.utilisateur.credit ? '' : sessionScope.utilisateur.credit } </p>
						
					</div>
						</c:if>
						
					
				</div>  <!-- FIN BLOC de Gauche -->
				<div class="form-group col-sm-6">
					<div class="form-group row">
						<label for="nom" class="col-sm-3 col-form-label">Nom :</label>
						<input type="text" name="nom" id="nom" class="form-control col-sm-5" value="${empty sessionScope.utilisateur.nom ? '' : sessionScope.utilisateur.nom }" placeholder="Nom" />
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-3 col-form-label">Email :</label>
						<input type="email" name="email" id="email" class="form-control col-sm-5" value="${empty sessionScope.utilisateur.email ? '' : sessionScope.utilisateur.email }" placeholder="E-mail" />
					</div>
					<div class="form-group row">
						<label for="rue" class="col-sm-3 col-form-label">Rue :</label>
						<input type="text" name="rue" id="Rue" class="form-control col-sm-5" value="${empty sessionScope.utilisateur.rue ? '' : sessionScope.utilisateur.rue }" placeholder="Rue"/>
					</div>
					<div class="form-group row">
						<label for="ville" class="col-sm-3 col-form-label">Ville :</label>
						<input type="text" name="ville" id="ville" class="form-control col-sm-5" value="${empty sessionScope.utilisateur.ville ? '' : sessionScope.utilisateur.ville }" placeholder="Ville" />
					</div>
					<c:if test="${empty sessionScope.utilisateur.pseudo}">
					<div class="form-group row">
						<label for="confirmation" class="col-sm-3 col-form-label">Confirmation :</label>
						<input type="password" name="confirmation" id="confirmation" class="form-control col-sm-5" placeholder="Confirmer mot de passe" />
					</div>
					</c:if>
					<c:if test="${!empty sessionScope.utilisateur.pseudo}">
					<div class="form-group row">
							<label for="newmdp" class="col-sm-3 col-form-label">Nouveau mot de passe :</label>
							<input id="newmdp" type="password" name="newmdp" class="form-control col-sm-5" placeholder="Nouveau mot de passe" />
						</div>
						</c:if>
				</div>
				<c:if test="${ !empty requestScope.Erreur}">
					<p class="text-decoration-danger">${Erreur}</p>
				</c:if>
				
				<c:if test="${ !empty requestScope.ErreurMDP}">
					<p>${ErreurMDP}</p>
				</c:if>
				<c:if test="${empty sessionScope.utilisateur.pseudo}">
				
				<div class="form-group d-flex justify-content-around col-sm-6 mt-5">
					<input type="submit" value="Créer" class="form-control btn btn-info col-sm-3" name="create" />
					<a href="${pageContext.request.contextPath}/home" class="form-control btn btn-info col-sm-3">Annuler</a>
				</div>
				</c:if>
				<c:if test="${!empty sessionScope.utilisateur.pseudo}">
										
			<div class="form-group d-flex justify-content-around col-sm-6 mt-5">
				<input type="submit" value="Enregistrer" class="form-control btn btn-info col-sm-3"
					name="save" />			
				<input type="submit" value="Supprimer" class="form-control btn btn-info col-sm-3"
					name="delete" />
					</div>
					
			
			
			
		</c:if>
			</div>
		</form>

		
		</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>