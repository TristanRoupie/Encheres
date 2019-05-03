package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	@Override
	public void addArticle(ArticleVendu article) {
		getCategorie(article);
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(article);
		session.getTransaction().commit();

	}

	

	@Override
	public void updateArticle(ArticleVendu article) {
		getCategorie(article);
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(article);
		session.getTransaction().commit();
	}

	@Override
	public void deleteArticle(ArticleVendu article) {
		getCategorie(article);
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.delete(article);
		session.getTransaction().commit();

	}

	@Override
	public List<ArticleVendu> selectAllArticle() {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("from ARTICLES_VENDUS");
		List<ArticleVendu> articles = q.getResultList();
		if (articles.size() == 0) {
			return null;
		} else {
			return articles;
		}
	}
	
	private void getCategorie(ArticleVendu article) {
		CategorieDAO categoriedao = new CategorieDAOJdbcImpl();
		if (categoriedao.selectCategorieByLibelle(article.getCategorie().getLibelle())==null) {
			categoriedao.addCategorie(article.getCategorie());
		}
		 article.setCategorie(categoriedao.selectCategorieByLibelle(article.getCategorie().getLibelle()));
	}



	@Override
	public ArticleVendu selectArticleById(int noArticle) {
		Session session = ConnectionProvider.session;
		ArticleVendu article = (ArticleVendu) session.get(ArticleVendu.class, noArticle);
		return article ;
	}

}
