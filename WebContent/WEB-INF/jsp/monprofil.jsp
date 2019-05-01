<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/style.css">
<title>Mon Profil</title>
</head>
<body>
	<div id="conteneur"> <!-- debut du conteneur -->
		<h1>Mon Profil</h1>
		
		<div id="bloccommerce2">
			<div id="sousbloc3">
		<label for="pseudo"  ${requestScope.monprofil.pseudo}>Pseudo :</label><input type="text" id="pseudo" class="pseudo"/><br />
		<label for="prenom"${requestScope.monprofil.prenom}>Prénom :</label><input type="text" id="prenom" class="prenom"><br />
		<label for="telephone"${requestScope.monprofil.telephone}>Téléphone :</label><input type="text" id="telephone" class="telephone"/><br />
		<label for="codepostal"${requestScope.monprofil.codepostal}>Code Postal :</label><input type="text" id="codepostal" class="codeposte"/><br />
		<label for="mdpnow"${requestScope.monprofil.mdpnow}>Mot de passe actuel :</label><input type="text" id="mdpnow" class="mdpnow"/><br />
		<label for="newmdp"${requestScope.monprofil.newmdp}>Nouveau mot de passe :</label><input type="text" id="newmdp" class="newmdp"/><br />
			</div> <!-- fin du sousbloc3 -->
			<div id="sousbloc3">
		<label for="nom" ${requestScope.monprofil.nom}>Nom :</label><input type="text" id="nom" class="nom" /><br />
		<label for="email" ${requestScope.monprofil.email}>Prénom :</label><input type="text" id=""email" class="email"/><br />
		<label for="rue" ${requestScope.monprofil.Rue}>Prénom :</label><input type="text" id="Rue" class="Rue"/><br />
		<label for="ville" ${requestScope.monprofil.ville}>Ville :</label><input type="text" id="ville" class="ville"/><br />
		<label for="confirmation" ${requestScope.monprofil.confirmation}>Confirmation :</label><input type="text" id="confirmation" class="confirmation"/><br />
			</div> <!-- fin du sousbloc4 -->
			
			
		</div><!-- fin du bloccommerce2 -->
		
		<p>Votre crédit est de :${requestScope.monprofil.credit}</p>
		
		<div id="bloccommerce2">
		<div id="sousbloc3">
		<form action="${pageContext.request.contextPath}/jsp/encheres" method="get">
			<input id
				type="submit"
				value="Enregistrer"
				class="enregistrer"
				style="height: 100px"/>
		</form>
		</div>
		<div id="sousbloc3">
		<form action="${pageContext.request.contextPath}/jsp/creaCompte" method="get">
			<input id
				type="submit"
				value="Supprimer mon compte"
				class="supprimer"
				style="height: 100px"/>
		</form>
		</div>
		
		</div>
	
	
	
	
	</div><!-- fin du conteneur -->
</body>
</html>