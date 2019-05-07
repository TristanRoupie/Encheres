package fr.eni.encheres.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;
import fr.eni.encheres.dal.RetraitDAO;
import fr.eni.encheres.dal.UtilisateurDAO;

class Runner {

	@Test
	void test() {
		// Ajout utilisteur
		Utilisateur newUtilisateur = new Utilisateur("pseudo", "Roupie", "Tristan", "Tristan.roupie@gmail.com",
				"rue de la libération", "35190", "Labaussaine", "yoyo", 587, 0);
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		if (utilisateurDAO.selectUtilisateurByEmail(newUtilisateur.getEmail()) == null) {
			utilisateurDAO.addUtilisateur(newUtilisateur);

		}
		// Ajout utilisteur
		Utilisateur newUtilisateur2 = new Utilisateur("pseudo6", "Roupie", "Tristan", "Tristan.roupie87@gmail.com",
				"rue de la libération", "35190", "Labaussaine", "yoyo", 587, 0);
		UtilisateurDAO utilisateurDAO2 = DAOFactory.getUtilisateurDAO();
		if (utilisateurDAO2.selectUtilisateurByPseudo(newUtilisateur2.getPseudo()) == null) {
			utilisateurDAO2.addUtilisateur(newUtilisateur2);
		}
		System.out.println(newUtilisateur2.getNoUtilisateur());

		// recherche par id
		UtilisateurDAO utilisateurDAO3 = DAOFactory.getUtilisateurDAO();
		Utilisateur utilisateur = utilisateurDAO3.selectUtilisateurByid(2);
		if (utilisateur == null) {
			System.out.println("l'objet n'existe pas");
		} else {
			System.out.println("=====>" + utilisateur);
		}
		// recherche par email
		utilisateur = utilisateurDAO3.selectUtilisateurByEmail("Tristan.roupie87@gmail.com");
		if (utilisateur == null) {
			System.out.println("l'objet n'existe pas");
		} else {
			System.out.println("=====>" + utilisateur);
		}
		// recherche par pseudo
		utilisateur = utilisateurDAO3.selectUtilisateurByPseudo("pseudo");
		if (utilisateur == null) {
			System.out.println("l'objet n'existe pas");
		} else {
			System.out.println("=====>" + utilisateur);
		}

		// Ajout d'un article sans adresse de recuperation
		Categorie categorie = new Categorie("merguez electro");
		ArticleVendu article = new ArticleVendu("seche linge en cours", "lave super bien le linge",
				new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 10)),
				new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 10)), 15, 0, 1, utilisateur, categorie);
		ArticleVenduDAO artcileDAO = DAOFactory.getArticleVenduDAO();
		artcileDAO.addArticle(article);

		// Ajout d'un article sans adresse de recuperation
		categorie = new Categorie("morgo electro");
		article = new ArticleVendu("seche cheveux pas commence", "seche super bien les cheveux",
				new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 10)),
				new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 20)), 15, 0, 0, utilisateur, categorie);
		artcileDAO = DAOFactory.getArticleVenduDAO();
		artcileDAO.addArticle(article);
		System.out.println(article.getNoArticle());

		// Ajout d'un article sans adresse de recuperation
		categorie = new Categorie("morgo electro");
		article = new ArticleVendu("seche cheveux termine", "seche super bien les cheveux",
				new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 10)),
				new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 20)), 15, 0, 2, utilisateur, categorie);
		artcileDAO = DAOFactory.getArticleVenduDAO();
		artcileDAO.addArticle(article);
		System.out.println(article.getNoArticle());

		// Ajout d'un article sans adresse de recuperation
		utilisateur = utilisateurDAO3.selectUtilisateurByPseudo("pseudo6");
		categorie = new Categorie("merguez electro");
		article = new ArticleVendu("seche linge en cours6", "lave super bien le linge",
				new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 10)),
				new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 10)), 15, 0, 1, utilisateur, categorie);
		artcileDAO = DAOFactory.getArticleVenduDAO();
		artcileDAO.addArticle(article);

		// Ajout d'un article sans adresse de recuperation
		categorie = new Categorie("morgo electro");
		article = new ArticleVendu("seche cheveux pas commence6", "seche super bien les cheveux",
				new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 10)),
				new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 20)), 15, 0, 0, utilisateur, categorie);
		artcileDAO = DAOFactory.getArticleVenduDAO();
		artcileDAO.addArticle(article);
		System.out.println(article.getNoArticle());

		// Ajout d'un article sans adresse de recuperation
		categorie = new Categorie("morgo electro");
		article = new ArticleVendu("seche cheveux termine6", "seche super bien les cheveux",
				new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 10)),
				new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 20)), 15, 0, 2, utilisateur, categorie);
		artcileDAO = DAOFactory.getArticleVenduDAO();
		artcileDAO.addArticle(article);
		System.out.println(article.getNoArticle());

		// modifier un article
		categorie = new Categorie("super lolipop");
		article = artcileDAO.selectArticleById(article.getNoArticle());
		article.setCategorie(categorie);
		artcileDAO.updateArticle(article);
		System.out.println(article.getCategorie());

		// ajouter un retrait
		Retrait retrait = new Retrait(article.getNoArticle(), "13 rue general", "35720", "rennes", article);
		RetraitDAO retraitDao = DAOFactory.getRetraitDAO();
		retraitDao.addRetrait(retrait);

		// recherche d article par vendeur
		List<ArticleVendu> articles = artcileDAO.selectArticleVendeur("pseudo", 1, "",6);
		if (articles != null) {
			for (ArticleVendu artcile : articles) {
				System.out.println(artcile);
			}
		} else {
			System.out.println("pas de liste");
		}
		
		// recherche d article en coures d'encheres
				List<ArticleVendu> articles2 = artcileDAO.selectArticleAcheteurOuverte("pseudo", "",-1);
				if (articles != null) {
					for (ArticleVendu artcile : articles) {
						System.out.println(artcile);
					}
				} else {
					System.out.println("pas de liste");
				}
				
				// rajout d'enchères
				utilisateur= utilisateurDAO2.selectUtilisateurByPseudo("pseudo");
				article= artcileDAO.selectArticleById(article.getNoArticle());
				Enchere enchere = new Enchere(new Date(System.currentTimeMillis()),50,utilisateur,article);
				EnchereDAO enchereDao = DAOFactory.getEnchereDAO();
				enchereDao.addEnchere(enchere);
				
				// rajout d'enchères
				utilisateur= utilisateurDAO2.selectUtilisateurByPseudo("pseudo6");
				article= artcileDAO.selectArticleById(article.getNoArticle());
				enchere = new Enchere(new Date(System.currentTimeMillis()),60,utilisateur,article);
				enchereDao = DAOFactory.getEnchereDAO();
				enchereDao.addEnchere(enchere);
				
				// rajout d'enchères
				utilisateur= utilisateurDAO2.selectUtilisateurByPseudo("pseudo");
				article= artcileDAO.selectArticleById(article.getNoArticle()-1);
				enchere = new Enchere(new Date(System.currentTimeMillis()),70,utilisateur,article);
				 enchereDao = DAOFactory.getEnchereDAO();
				enchereDao.addEnchere(enchere);
				
				// rajout d'enchères
				utilisateur= utilisateurDAO2.selectUtilisateurByPseudo("pseudo6");
				article= artcileDAO.selectArticleById(article.getNoArticle()-1);
				enchere = new Enchere(new Date(System.currentTimeMillis()),98,utilisateur,article);
				enchereDao = DAOFactory.getEnchereDAO();
				enchereDao.addEnchere(enchere);
				
				// recherche d article avec une enchere de l utilisateur
				articles2 = artcileDAO.selectArticleEncherEnCours("pseudo6", "",-1);
				if (articles2 != null) {
					for (ArticleVendu artcile : articles2) {
						System.out.println(artcile);
					}
				} else {
					System.out.println("pas de liste");
				}
				
				// recherche d article avec une enchere remportée
				articles2 = artcileDAO.selectArticleEncherRemporte("pseudo6", "",-1);
				if (articles2 != null) {
					for (ArticleVendu artcile : articles2) {
						System.out.println(artcile);
					}
				} else {
					System.out.println("pas de liste");
				}
				
				// recherche utilisateur
				utilisateur = utilisateurDAO.checkUtilisateur("","Tristan.roupie87@gmail.com","yoyo");
				if (utilisateur != null) {
					System.out.println(utilisateur);
				} else {
					System.out.println("mauvais");
				}
				
				
				

	}
}
