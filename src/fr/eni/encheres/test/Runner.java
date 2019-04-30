package fr.eni.encheres.test;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.bo.Voiture;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

class Runner {

	@Test
	void test() {
		// Ajout

//    	Voiture voitureAajoutee = new Voiture("Alfa Romeo", 7);
//        Session session = ConnectionProvider.session;
//        session.beginTransaction();
//        session.save(voitureAajoutee);
//        session.getTransaction().commit();

		Utilisateur newUtilisateur = new Utilisateur("pseudo", "Roupie", "Tristan", "Tristan.roupie@gmail.com",
				"rue de la libération", 35190, "Labaussaine", "yoyo", 587, 0);

//        Session session = ConnectionProvider.session;
//        <session class="beginTransaction"></session>;
//        session.save(newUtilisateur);
//        session.getTransaction().commit();
//        

		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		utilisateurDAO.addUtilisateur(newUtilisateur);
		System.out.println(newUtilisateur.getNoUtilisateur());
		 newUtilisateur = new Utilisateur("pseudot", "Roupie", "Tristan", "Tristan.roupie@gmail.com",
				"rue de la libération", 35190, "Labaussaine", "yoyo", 587, 0);
		utilisateurDAO.addUtilisateur(newUtilisateur);
		System.out.println(newUtilisateur.getNoUtilisateur());

		// Suppression
//         Long id = 1L;
//         Voiture voitureAsupprimee = (Voiture) session.get(Voiture.class, id);
//         session.beginTransaction();
//         session.delete(voitureAsupprimee);
//         session.getTransaction().commit();
//
//         // Ajout
//         Voiture voitureAajoutee02 = new Voiture("Peugeot", 7);
//         session.beginTransaction();
//         session.save(voitureAajoutee02);
//         session.getTransaction().commit();
//
//         // Modification
//         Long id2 = 2L;
//         Voiture voitureAmodifiee = (Voiture) session.get(Voiture.class, id2);
//         voitureAmodifiee.setNbChevaux(25);
//         session.beginTransaction();
//         session.saveOrUpdate(voitureAmodifiee);
//         session.getTransaction().commit();
//
//         // Selection
//         Query q = session.createQuery("from Voiture");
//         List<Voiture> voitures = q.getResultList();
//         for (Voiture v : voitures) {
//         System.out.println(v.getModele());
//         }
	}
}
