package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	@Override
	public void addEnchere(Enchere enchere) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.save(enchere);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void updateEnchere(Enchere enchere) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.saveOrUpdate(enchere);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void deleteEnchere(Enchere enchere) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.delete(enchere);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Enchere> selectAllEnchere() {
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery("from ENCHERES");
		List<Enchere> encheres = q.getResultList();
		session.close();
		if (encheres.size() == 0) {
			return null;
		} else {
			return encheres;
		}
	}

	@Override
	public List<Enchere> selectEnchereByArtcile(ArticleVendu article) {
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery(
				"from ENCHERES e where e.article = :article");
		q.setParameter("article", article);
		List<Enchere> encheres = q.getResultList();
		session.close();
		if (encheres.size() == 0) {
			return null;
		} else {
			return encheres;
		}

	}

	@Override
	public List<Enchere> selectEnchereByUtilisateur(Utilisateur utilisateur) {
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery(
				"from ENCHERES e where e.utilisateur = :utilisateur");
		q.setParameter("utilisateur", utilisateur);
		List<Enchere> encheres = q.getResultList();
		session.close();
		if (encheres.size() == 0) {
			return null;
		} else {
			return encheres;
		}
	}

	@Override
	public Enchere selectEnchere(ArticleVendu article, Utilisateur utilisateur) {
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery(
				"from ENCHERES e where e.utilisateur = :utilisateur and e.article = :article");
		q.setParameter("utilisateur", utilisateur);
		q.setParameter("article", article);
		List<Enchere> encheres = q.getResultList();
		if (encheres.size() == 0) {
			session.close();
			return null;
		} else {
			Enchere enchere =(Enchere) q.getSingleResult();
			session.close();
			return enchere;
		}
	}

}
