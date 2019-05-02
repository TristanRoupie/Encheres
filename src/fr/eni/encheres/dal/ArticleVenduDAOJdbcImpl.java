package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	@Override
	public void addArticle(ArticleVendu article) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(article);
		session.getTransaction().commit();

	}

	@Override
	public void updateArticle(ArticleVendu article) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(article);
		session.getTransaction().commit();
	}

	@Override
	public void deleteArticle(ArticleVendu article) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.delete(article);
		session.getTransaction().commit();

	}

	@Override
	public List<ArticleVendu> selectAllArticle() {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("from ArtcileVendu");
		List<ArticleVendu> articles = q.getResultList();
		if (articles.size() == 0) {
			return null;
		} else {
			return articles;
		}
	}

}
