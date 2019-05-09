<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<link rel="stylesheet" href="css/bootstrap-reboot.min.css">
<title>Encheres</title>
</head>
<body class="bg-light">
	<div class="container-fluid">
	<header class="row justify-content-between loulou" >
			<nav class="navbar col-sm-8 loulou ">
				<a href="${pageContext.request.contextPath}/">
				<img src="${pageContext.request.contextPath}/images/logo.png" width="70%" alt="Logo de la société" class="rounded"></a>
			</nav>			
		</header>
		
			
			<h1 class="text-center mb-sm-5 mt-sm-5">Connexion</h1>
		
		<form action="${pageContext.request.contextPath}/connexionInscription"
			method="post">
			<div
				class="form-group row justify-content-around col-sm-10 offset-sm-1">
				<div class="form-group col-sm-6">
					<div class="form-group row offset-sm-1">
						<label for="login" class="col-sm-4 col-form-label">Pseudo
							/ Email :</label> <input type="text" name="login" id="login"
							class="form-control col-sm-5"
							placeholder="Tapez votre identifiant" />
					</div>
					<div class="form-group row offset-sm-1">
						<label for="mdp" class="col-sm-4 col-form-label">Mot de
							passe :</label> <input type="password" name="mdp" id="mdp"
							class="form-control col-sm-5"
							placeholder="Tapez votre mot de passe" />
					</div>
					<c:if test="${ !empty requestScope.ErreurConnexion}">
						<p>${ErreurConnexion}</p>
					</c:if>
						<div class="form-group d-flex justify-content-around  mt-5">
							<input type="submit" value="connexion" name="connexion"
								class="form-control btn btn-info col-sm-3" /> <a
								href="${pageContext.request.contextPath}/home"
								class="form-control btn btn-info col-sm-3">Annuler</a>
						</div>
				</div>
			</div>
		</form>
		<%-- <h4>identifiant</h4>			
			<!-- fin du sousbloc -->				
					<input class="bloclogin" type="text" name="login" size="15" />			
			<!-- fin du sousbloc -->		
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
				<form action="${pageContext.request.contextPath}/home" method="get">
					<input type="submit" class="supprimer" value="Connexion"
						name="connexion" /></form>
					<div class="sousbloc3">
					<form action="${pageContext.request.contextPath}/monProfil" method="get">
						<input type="submit" class="supprimer" value="Créer un compte"
							name="supprimer" />
						</form>	
					</div>
				</form>
			</div>
		</div> --%>
		<footer class="row justify-content-center fixed-bottom riri loulou " >
			<a href="mailto:someone@yoursite.com" class="d-flex align-items-center">Envoyer un mail</a>		
		</footer>
	</div>
	<!-- Fin du conteneur -->
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