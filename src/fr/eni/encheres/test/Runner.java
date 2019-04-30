package fr.eni.encheres.test;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

class Runner {

	@Test
	void test() {
		// Ajout
//		Utilisateur newUtilisateur = new Utilisateur("pseudo", "Roupie", "Tristan", "Tristan.roupie@gmail.com",
//		"rue de la libération", 35190, "Labaussaine", "yoyo", 587, 0);
//		
//		utilisateurDAO.addUtilisateur(newUtilisateur);
//		
//		Utilisateur newUtilisateur2 = new Utilisateur("pseudo6", "Roupie", "Tristan", "Tristan.roupie87@gmail.com",
//				"rue de la libération", 35190, "Labaussaine", "yoyo", 587, 0);
//		UtilisateurDAO utilisateurDAO2 = DAOFactory.getUtilisateurDAO();
//		utilisateurDAO2.addUtilisateur(newUtilisateur2);
//		System.out.println(newUtilisateur2.getNoUtilisateur());
		
		//recherche par pseudo
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		Utilisateur u = utilisateurDAO.selectUtilisateurByEmail("Tristan.roupie7@gmail.com");
		if (u==null) {
			System.out.println("l'objet n'existe pas");
		}else {
			System.out.println(u.getNom());
		}
		


	}
}
