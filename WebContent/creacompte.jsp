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
	<div>
		<header>
			<h1>Eni-Enchères</h1>
		</header>

		<div id="conteneur">
			<h4>Identifiant :</h4>
			<form action="${pageContext.request.contextPath}" method="post">
			<input
				type="text" 
				name="login" 
				size="15" />
			</form>	
			<h4>Mot de passe :</h4>
			<form action="${pageContext.request.contextPath}" method="post"">
			<input 
				type="text" 
				name="login"
				size="15" />
			</form>
				<br>
		</div>
		<div>
		<form action="${pageContext.request.contextPath}" method="get">
			<input id
				type="submit"
				value="Connexion"
				style="height: 100px"/>
		</form>
		</div>
			<div>
			<form action="${pageContext.request.contextPath}" method="get">
			<input id
				type="submit"
				value="Créer un compte"
				style="height: 100px"/>
			</form>	
		</div>






	</div>
</body>
</html>