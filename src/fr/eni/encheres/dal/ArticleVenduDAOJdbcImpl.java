package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	private final String REQUETE_VENDEUR = "from ARTICLES_VENDUS a WHERE a.etatVente  = :etat ";
	private final String WHERE_ARTCILE_LIKE = "AND a.nomArticle Like :contient ";
	private final String WHERE_UTILISATEUR_IS = "AND a.utilisateur = :utilisateur";
	

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

	@Override
	public ArticleVendu selectArticleById(int noArticle) {
		Session session = ConnectionProvider.session;
		ArticleVendu article = (ArticleVendu) session.get(ArticleVendu.class, noArticle);
		return article;
	}

	@Override
	public List<ArticleVendu> selectArticleVendeur(String pseudo, int etat, String contient, Categorie categorie) {
		Session session = ConnectionProvider.session;
		Utilisateur utilisateur = new UtilisateurDAOJdbcImpl().selectUtilisateurByPseudo(pseudo);
		System.out.println(utilisateur);

		Query q = session.createQuery(
				"from ARTICLES_VENDUS a where a.etatVente  = :etat AND a.nomArticle like :contient AND a.utilisateur = :utilisateur");
		q.setParameter("contient", "%" + contient + "%");
		q.setParameter("utilisateur", utilisateur);
		q.setParameter("etat", etat);

		List<ArticleVendu> articles = q.getResultList();
		if (articles.size() == 0) {
			return null;
		} else {
			return articles;
		}

	}

	@Override
	public List<ArticleVendu> selectArticleAcheteurOuverte(String pseudo, String contient, Categorie categorie) {
		Session session = ConnectionProvider.session;
		Utilisateur utilisateur = new UtilisateurDAOJdbcImpl().selectUtilisateurByPseudo(pseudo);
		System.out.println(utilisateur);

		Query q = session.createQuery(
				"from ARTICLES_VENDUS a where a.nomArticle like :contient and  a.etatVente  = 1 AND a.utilisateur != :utilisateur");
		q.setParameter("contient", "%" + contient + "%");
		q.setParameter("utilisateur", utilisateur);

		List<ArticleVendu> articles = q.getResultList();
		if (articles.size() == 0) {
			return null;
		} else {
			return articles;
		}
	}

	@Override
	public List<ArticleVendu> selectArticleEncherEnCours(String pseudo, String contient, Categorie categorie) {
		Session session = ConnectionProvider.session;
		Utilisateur utilisateur = new UtilisateurDAOJdbcImpl().selectUtilisateurByPseudo(pseudo);

		Query q = session.createQuery(
//				select e from Employee e inner join e.team
				"SELECT a from ENCHERES e JOIN e.article a where a.etatVente  = 1 and e.utilisateur = :utilisateur");
//		q.setParameter("contient", "%" + contient + "%");
		q.setParameter("utilisateur", utilisateur);

		List<ArticleVendu> articles = q.getResultList();
		if (articles.size() == 0) {
			return null;
		} else {
			return articles;
		}

	}

	private void getCategorie(ArticleVendu article) {
		CategorieDAO categoriedao = new CategorieDAOJdbcImpl();
		if (categoriedao.selectCategorieByLibelle(article.getCategorie().getLibelle()) == null) {
			categoriedao.addCategorie(article.getCategorie());
		}
		article.setCategorie(categoriedao.selectCategorieByLibelle(article.getCategorie().getLibelle()));
	}
}
