<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<link rel="stylesheet" href="css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>Vendre Article</title>
</head>
<body class="bg-light">
	<div>
	<header class="row justify-content-between loulou" >
			<nav class="navbar col-sm-8 loulou ">
				<a href="${pageContext.request.contextPath}/">
				<img src="${pageContext.request.contextPath}/images/logo.png" width="70%" alt="Logo de la société" class="rounded"></a>
			</nav>			
		</header>
		
		<h1 class="text-center mt-3 mb-5">Nouvelle vente</h1>
			<form action="${pageContext.request.contextPath}/VendreArticleServlet" method="post">
				<div class="form-group row justify-content-around col-sm-10 offset-sm-1">
					<div class="form-group col-sm-6">
						<div class="form-group row">
							<label for="article" class="col-sm-3 col-form-label">Article :</label>
							<input type="text" name="article" id="article" class="form-control col-sm-5" />
						</div>
						<div class="form-group row">
							<label for="description" class="col-sm-3 col-form-label">Description :</label>
							<textarea name="description" id="description" class="form-control col-sm-5"> </textarea>
						</div>
						<div class="form-group row">
							<label for="categories" class="col-sm-3 col-form-label">Catégories : </label>
					<select name="Catégories" class="form-control col-sm-5" id="categories">
						<option hidden value="0">Selectionner une catégorie</option>
						<!-- A verifier si la value apparait bien sans conflit avec le nom -->
						<option value="${Categorie.getLibelle()}">Informatique</option>
						<option value="${Categorie.getLibelle()}">Ameublement</option>
						<option value="${Categorie.getLibelle()}">Vêtements</option>
						<option value="${Categorie.getLibelle()}">Sport et loisirs</option>
					</select>
						</div>
						<div class="form-group row">
							<label for="photo" class="col-sm-3 col-form-label">Photo de l'article :</label>
							<input type="file" name="photo" id="photo" placeholder="uploader"/>
						</div>
						<div class="form-group row">
							<label for="prix" class="col-sm-3 col-form-label">Mise à prix :</label>
							<input type="number" name="prix" id="prix" min="0" class="form-control col-sm-5" />
						</div>
						<div class="form-group row">
							<label for="debutEnch" class="col-sm-3 col-form-label">Début de l'enchère :</label>
							<input type="datetime-local" name="debutEnch" id="debutEnch" class="form-control col-sm-5" />
						</div>
						<div class="form-group row">
							<label for="finEnch" class="col-sm-3 col-form-label">Fin de l'enchère :</label>
							<input type="datetime-local" name="finEnch" id="finEnch" class="form-control col-sm-5" />
						</div>						
							<fieldset id="fieldset">
    							<legend>Retrait</legend>
    							<div class="form-group row">
    								<label class="col-sm-3 col-form-label" for="rue">Rue</label>
    								<input type="text" id="rue" name="rue" value="${requestScope.utilisateur.getRue()}" class="form-control col-sm-5"/>
    							</div>
    							<div class="form-group row">
    								<label class="col-sm-3 col-form-label" for="cp">Code postal</label>
    								<input type="text" id="cp" name="cp" value="${requestScope.utilisateur.getCodePostal() }" class="form-control col-sm-5"/>
    							</div>
    							<div class="form-group row">
    								<label class="col-sm-3 col-form-label" for="ville">Ville</label>
    								<input type="text" id="ville" name="ville" value="${requestScope.utilisateur.getVille() }" class="form-control col-sm-5"/>
 	   							</div>
  							</fieldset>
  						<div class="form-group d-flex justify-content-around mb-5 mt-5">						
							<input type="submit" value="Enregistrer" name="enregistrer" class="form-control btn btn-info col-sm-3" />			
							<a href="${pageContext.request.contextPath}/home" class="form-control btn btn-info col-sm-3">Annuler</a>
						</div>
					</div>
				</div>
			</form>
			<footer class="row justify-content-center  riri loulou " >
			<a href="mailto:someone@yoursite.com" class="d-flex align-items-center">Envoyer un mail</a>		
		</footer>
	</div>	
	<%-- 
	<div class="conteneur">
	<form action="${pageContext.request.contextPath}/VendreArticleServlet" method="post">
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
				  <fieldset>
    <legend>Retrait</legend>

    <input type="text"  value="${requestScope.utilisateur.getRue()}" id="rue" name="retrait">
    <label for="rue">Rue</label><br/>

    <input type="text" value="${requestScope.utilisateur.getCodePostal() }" id="cp" name="retrait">
    <label for="cp">Code Postal</label><br/>

    <input type="text" value="${requestScope.utilisateur.getVille() }" id="ville" name="retrait">
    <label for="ville">Ville</label>
  </fieldset>
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
	<!-- fin du conteneur --> --%>
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