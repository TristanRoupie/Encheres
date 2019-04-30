package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.javaee.hibernate.bo.Voiture;


public class UtilisateurJdbcImpl implements UtilisateurDAO {

	@Override
	public void addUtilisateur(Utilisateur utilisateur) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(utilisateur);
		session.getTransaction().commit();

	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(utilisateur);
		session.getTransaction().commit();

	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.delete(utilisateur);
		session.getTransaction().commit();

	}

	@Override
	public Utilisateur selectUtilisateurByid(int noUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Utilisateur selectUtilisateurByPseudo(String pseudo) {
		 Query q = session.createQuery("from Utilistaeurs");
         List<Voiture> voitures = q.getResultList();
         for (Voiture v : voitures) {
         System.out.println(v.getModele());
         }
		return null;
	}
	
	@Override
	public Utilisateur selectUtilisateurByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
