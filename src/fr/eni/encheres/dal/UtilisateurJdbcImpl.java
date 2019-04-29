package fr.eni.encheres.dal;

import org.hibernate.Session;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.javaee.hibernate.bo.Voiture;
import fr.eni.javaee.hibernate.dal.ConnectionProvider;

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
	public void DeleteUtilisateur(Utilisateur utilisateur) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.delete(utilisateur);
		session.getTransaction().commit();

	}

	@Override
	public Utilisateur GetUtilisateur(int noUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

}
