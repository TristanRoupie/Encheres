package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.ArticleVendu;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	@Override
	public void addArticle(ArticleVendu article) {
		CategorieDAO categoriedao = new CategorieJdbcImpl();
		if (categoriedao.selectCategorieByLibelle(article.getCategorie().getLibelle())==null) {
			categoriedao.addCategorie(article.getCategorie());
		}
		article.setCategorie(categoriedao.selectCategorieByLibelle(article.getCategorie().getLibelle()));
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
