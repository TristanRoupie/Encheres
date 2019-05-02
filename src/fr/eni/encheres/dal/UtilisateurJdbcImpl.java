package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.Utilisateur;

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
		Session session = ConnectionProvider.session;
		Utilisateur utilisateur = (Utilisateur) session.get(Utilisateur.class, noUtilisateur);
		return utilisateur;
	}

	@Override
	public Utilisateur selectUtilisateurByPseudo(String pseudo) {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("from UTILISATEURS u where u.pseudo = :pseudo").setParameter("pseudo", pseudo);
		List<Utilisateur> utilisateurs = q.getResultList();
		if (utilisateurs.size() == 0) {
			return null;
		} else {
			return (Utilisateur) q.getSingleResult();
		}

	}

	@Override
	public Utilisateur selectUtilisateurByEmail(String email) {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("from UTILISATEURS u where u.email = :email").setParameter("email", email);
		List<Utilisateur> utilisateurs = q.getResultList();
		if (utilisateurs.size() == 0) {
			return null;
		} else {
			return (Utilisateur) q.getSingleResult();
		}
	}

}
