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
<title>Vendre Article</title>
</head>
<body class="bg-light">
	<div>
		<div class="row ">	
			<a href="${pageContext.request.contextPath}/">
			<img src="${pageContext.request.contextPath}/images/logo.png" alt="..." class="rounded float-left"></a>
			<h1 class="text-center col-sm-7 offset-sm-1 mt-3 mb-5">Detail vente</h1>
		</div>
			<form action="${pageContext.request.contextPath}/VendreArticleServlet" method="get">
				<div class="form-group row justify-content-around col-sm-10 offset-sm-1">
					<div class="form-group col-sm-6">
						<div class="form-group row">
							<label for="article" class="col-sm-3 col-form-label">Article :</label>
							<input type="text" name="article" id="article" value="${requestScope.Listarticle.article}" class="form-control col-sm-5" />
						</div>
						<div class="form-group row">
							<label for="description" class="col-sm-3 col-form-label">Description :</label>
							<textarea name="description" id="description" value="${requestScope.idArticle.descriptionArticle}" class="form-control col-sm-5"> </textarea>
						</div>
						<div class="form-group row">
							<label for="categorie" class="col-sm-3 col-form-label">Catégorie :</label>
							<input type="text" name="categorie" id="categorie" value="${requestScope.Listarticle.article}" class="form-control col-sm-5" />
						</div>
						<div class="form-group row">
							<label for="bestOffre" class="col-sm-3 col-form-label">Meilleure offre :</label>
							<input type="text" name="bestOffre" id="bestOffre" value="${requestScope.offre}" class="form-control col-sm-5" />
						</div>
						<div class="form-group row">
							<label for="prixdebut" class="col-sm-3 col-form-label">Mise à prix :</label>
							<input type="text" name="prixdebut" id="prixdebut" value="${requestScope.articleVendu.prixVente}" class="form-control col-sm-5" />
						</div>
						<div class="form-group row">
							<label for="finEnch" class="col-sm-3 col-form-label">Fin de l'enchère</label>
							<input type="datetime-local" name="finEnch" id="finEnch" value="${requestScope.articleVendu.dateFinEncheres}" class="form-control col-sm-5" />
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
  								<div class="form-group row">
									<label for="prixdebut" class="col-sm-3 col-form-label">Vendeur:</label>
									<input type="text" name="prixdebut" id="prixdebut" value="${requestScope.utilisateur.pseudo}" class="form-control col-sm-5" />
								</div>
  								<div class="form-group row">
									<label for="myPropo" class="col-sm-3 col-form-label">Ma proposition :</label>
									<input type="number" name="myPropo" id="myPropo" min="${requestScope.articleVendu.prixVente}" class="form-control col-sm-5" />
									<input type="submit" value="Enchérir" name="encherir" class="form-control btn btn-info col-sm-3 offset-sm-1" />
								</div>
												
					</div>
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