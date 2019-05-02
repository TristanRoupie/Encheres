<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<label for="pseudo"  >Pseudo</label><input type="text" id="pseudo" class="pseudo" value="${requestScope.monprofil.pseudo}"/><br />
		<label for="prenom">Prénom</label><input type="text" id="prenom" class="prenom" value="${requestScope.monprofil.prenom}"><br />
		<label for="telephone">Téléphone</label><input type="text" id="telephone" class="telephone" value="${requestScope.monprofil.telephone}"/><br />
		<label for="codepostal">Code Postal</label><input type="text" id="codepostal" class="codeposte" value="${requestScope.monprofil.codepostal}"/><br />
		<label for="mdpnow">Mot de passe actuel</label><input type="password" id="mdpnow" class="mdpnow" value="${requestScope.monprofil.mdpnow}"/><br />
		<label for="newmdp">Nouveau mot de passe</label><input type="password" id="newmdp" class="newmdp"/><br />
			</div> <!-- fin du sousbloc3 -->
			<div id="sousbloc3">
		<label for="nom" >Nom</label><input type="text" id="nom" class="nom" value="${requestScope.monprofil.nom}" /><br />
		<label for="email" >Prénom</label><input type="text" id=""email" class="email" value="${requestScope.monprofil.email}"/><br />
		<label for="rue" >Prénom</label><input type="text" id="Rue" class="Rue" value="${requestScope.monprofil.Rue}"/><br />
		<label for="ville" >Ville</label><input type="text" id="ville" class="ville" value="${requestScope.monprofil.ville}"/><br />
		<label for="confirmation">Confirmation</label><input type="password" id="confirmation" class="confirmation"/><br />
			</div> <!-- fin du sousbloc4 -->
			
			
		</div><!-- fin du bloccommerce2 -->
		
		<p>Votre crédit est de :${requestScope.monprofil.credit}</p>
		
		<div id="bloccommerce2">
		<div id="sousbloc3">
		<c:if test="${!empty nom}">
			<form action="${pageContext.request.contextPath}/encheres" method="post">
				<input id
					type="submit"
					value="Enregistrer"
					class="enregistrer"
					style="height: 100px"/>
			</form>
			<form action="${pageContext.request.contextPath}/home" method="post">
				<input id
					type="submit"
					value="Supprimer mon compte"
					class="supprimer"
					style="height: 100px"/>
			</form>
		</c:if>
		<c:if test="${empty nom}">
			<form action="${pageContext.request.contextPath}/encheres" method="post">
				<input id
					type="submit"
					value="Créer"
					class="enregistrer"
					style="height: 100px"/>
			</form>
			<form action="${pageContext.request.contextPath}/home" method="post">
				<input id
					type="submit"
					value="Annuler"
					class="supprimer"
					style="height: 100px"/>
			</form>
		</c:if>
		</div>
		<div id="sousbloc3">
		</div>
		
		</div>
	
	
	
	
	</div><!-- fin du conteneur -->
</body>
</html>