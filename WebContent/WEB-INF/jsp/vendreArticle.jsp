<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Nouvelle vente</h1>
	<div class="conteneur">
	<form action="${pageContext.request.contextPath}/home" method="post">
		<div class="bloccommerce">
			<div class="sousbloc3">
				<img src="https://dummyimage.com/200X200/000/fff"
					alt="image du produit">
			</div>
			<div class="sousbloc3">
				<h4>Article</h4>
				<h4>Description</h4>
				<h4>Catégorie</h4>
				<h4>Photo de l'article</h4>
				<h4>Mise à prix</h4>
				<h4>Début de l'enchère</h4>
				<h4>Fin de l'enchère de tristant</h4>
			</div>
			
				<div class="sousbloc4">

					<input type="text" size="30"><br> <br>
					<textarea rows="5" cols="50" name="categorie"></textarea>
					<br> <br> <select name="Catégories" class="Catégories"
						style="height: 30px">
						<option value="0" hidden>Selectionner une catégorie</option>
						<option value="1">Multimédia</option>
						<option value="2">Loisirs</option>
						<option value="3">Vêtements</option>
						<option value="4">Sport & loisirs</option>
					</select><br> <br> <input type="number" min="0"><br>
					<br> <input type="datetime-local"><br> <br>
					<input type="datetime-local"><br> <br>

				</div>
		</div>
		<!-- Fin du bloccommerce -->
		<div class="bloccommerce">
			<div class="sousbloc3">
				<h3>Retrait</h3>
			</div>
			<!--fin du sousbloc-->
		</div>
		<div class="bloccommerce">
			<div class="sousbloc3">
				<h4>Rue</h4>
				<h4>Code postal</h4>
				<h4>Ville</h4>
			</div>
			<!--fin du sousbloc-->
			<div class="sousbloc3">
				<input type="text" size="30"><br> <br> <input
					type="text" size="30"><br> <br> <input
					type="text" size="30">
			</div>
			<!--fin du sousbloc-->
		</div>
		<!--fin du bloccommerce-->
		<div class="sousbloc5">
				<div class="bloccommerce3">

					<input type="submit" value="Enregistrer" class="supprimer">

					<a href="${pageContext.request.contextPath}/home" title="Google">Annuler
						la vente</a> <a href="${pageContext.request.contextPath}/home"
						title="Google">Annuler</a>

				</div>

			</div>







		</form>

	</div>
	<!-- fin du conteneur -->

</body>
</html>