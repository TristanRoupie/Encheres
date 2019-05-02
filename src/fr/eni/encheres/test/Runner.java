package fr.eni.encheres.test;


import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
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
		// Ajout
		Utilisateur newUtilisateur = new Utilisateur("pseudo", "Roupie", "Tristan", "Tristan.roupie@gmail.com",
		"rue de la libération", 35190, "Labaussaine", "yoyo", 587, 0);		
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		utilisateurDAO.addUtilisateur(newUtilisateur);
		
	Utilisateur newUtilisateur2 = new Utilisateur("pseudo6", "Roupie", "Tristan", "Tristan.roupie87@gmail.com",
				"rue de la libération", 35190, "Labaussaine", "yoyo", 587, 0);
		UtilisateurDAO utilisateurDAO2 = DAOFactory.getUtilisateurDAO();
		utilisateurDAO2.addUtilisateur(newUtilisateur2);
		System.out.println(newUtilisateur2.getNoUtilisateur());
		
		//recherche par pseudo
		UtilisateurDAO utilisateurDAO3 = DAOFactory.getUtilisateurDAO();
		Utilisateur utilisateur = utilisateurDAO3.selectUtilisateurByid(2);
		if (utilisateur==null) {
			System.out.println("l'objet n'existe pas");
		}else {
			System.out.println(utilisateur.getEmail());
		}
		Categorie categorie = new Categorie("super electro");
		ArticleVendu article =new ArticleVendu("seche linge", "lave super bien le linge",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+1000) , 15, 0, 0, utilisateur, categorie);
		ArticleVenduDAO artcileDAO = DAOFactory.getArticleVenduDAO();
		artcileDAO.addArticle(article);
		
		


	}
}
