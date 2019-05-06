package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	@Override
	public void addUtilisateur(Utilisateur utilisateur) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.save(utilisateur);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.saveOrUpdate(utilisateur);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.delete(utilisateur);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Utilisateur selectUtilisateurByid(int noUtilisateur) {
		Session session = ConnectionProvider.getConnection();
		Utilisateur utilisateur = (Utilisateur) session.get(Utilisateur.class, noUtilisateur);
		session.close();
		return utilisateur;
	}
	
	@Override
	public Utilisateur selectUtilisateurByPseudo(String pseudo) {
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery("from Utilisateur u where u.pseudo = :pseudo").setParameter("pseudo", pseudo);
		List<Utilisateur> utilisateurs = q.getResultList();
		if (utilisateurs.size() == 0) {
			session.close();
			return null;
		} else {
			Utilisateur utilisateur = (Utilisateur) q.getSingleResult();
			session.close();
			return utilisateur;
		}

	}

	@Override
	public Utilisateur selectUtilisateurByEmail(String email) {
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery("from Utilisateur u where u.email = :email").setParameter("email", email);
		List<Utilisateur> utilisateurs = q.getResultList();
		if (utilisateurs.size() == 0) {
			session.close();
			return null;
		} else {
			Utilisateur utilisateur = (Utilisateur) q.getSingleResult();
			session.close();
			return utilisateur;
		}
	}


	@Override
	public Utilisateur checkUtilisateurByPseudo(String pseudo, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur checkUtilisateurByEmail(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
