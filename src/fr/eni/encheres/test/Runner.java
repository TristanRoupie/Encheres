package fr.eni.encheres.test;

import java.util.Date;

import org.junit.jupiter.api.Test;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

class Runner {

	@Test
	void test() {
		// Ajout utilisteur
		Utilisateur newUtilisateur = new Utilisateur("pseudo", "Roupie", "Tristan", "Tristan.roupie@gmail.com",
				"rue de la libération", 35190, "Labaussaine", "yoyo", 587, 0);
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		if (utilisateurDAO.selectUtilisateurByEmail(newUtilisateur.getEmail()) == null) {
			utilisateurDAO.addUtilisateur(newUtilisateur);

		}
		// Ajout utilisteur
		Utilisateur newUtilisateur2 = new Utilisateur("pseudo6", "Roupie", "Tristan", "Tristan.roupie87@gmail.com",
				"rue de la libération", 35190, "Labaussaine", "yoyo", 587, 0);
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
		Categorie categorie = new Categorie("super electro");
		ArticleVendu article = new ArticleVendu("seche linge", "lave super bien le linge",
				new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 1000), 15, 0, 0,
				utilisateur, categorie);
		ArticleVenduDAO artcileDAO = DAOFactory.getArticleVenduDAO();
		artcileDAO.addArticle(article);
		// Ajout d'un article sans adresse de recuperation
				categorie = new Categorie("super electro");
				article = new ArticleVendu("seche cheveux", "seche super bien les cheveux",
						new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 1000), 15, 0, 0,
						utilisateur, categorie);
				artcileDAO = DAOFactory.getArticleVenduDAO();
				artcileDAO.addArticle(article);
	
	// modifier un article
	categorie = new Categorie("super lolipop");
	article = 
	artcileDAO = DAOFactory.getArticleVenduDAO();
	artcileDAO.updateArticle(article);
}
}
