package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	private final String REQUETE_VENDEUR = "FROM ArticleVendu a WHERE a.etatVente =:etatVente ";
	private final String WHERE_ARTCILE_LIKE = "AND a.nomArticle LIKE :nomArticle";
	private final String WHERE_UTILISATEUR_IS = "AND a.utilisateur.pseudo = :pseudo";
	private final String WHERE_CATEGORIE_IS = "AND a.categorie.noCategorie = :noCategorie";
	

	@Override
	public void addArticle(ArticleVendu article) {
		getCategorie(article);
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.save(article);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateArticle(ArticleVendu article) {
		getCategorie(article);
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.saveOrUpdate(article);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteArticle(ArticleVendu article) {
		getCategorie(article);
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.delete(article);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<ArticleVendu> selectAllArticle() {
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery("from ARTICLES_VENDUS");
		List<ArticleVendu> articles = q.getResultList();
		session.close();
		if (articles.size() == 0) {
			return null;
		} else {
			return articles;
		}
		
	}

	@Override
	public ArticleVendu selectArticleById(int noArticle) {
		Session session = ConnectionProvider.getConnection();
		ArticleVendu article = (ArticleVendu) session.get(ArticleVendu.class, noArticle);
		session.close();
		return article;
	}

	@Override
	public List<ArticleVendu> selectArticleVendeur(String pseudo, int etat, String contient, int noCategorie) {
		StringBuilder reqSQL = new StringBuilder();
		// preparation de la requete sql en fonction des parametres envoyé
		reqSQL.append(REQUETE_VENDEUR);
		reqSQL.append(etat);
		System.out.println(reqSQL);
		if (contient.length()!=0) {
			reqSQL.append(WHERE_ARTCILE_LIKE);
			reqSQL.append("%" + contient + "%");
			System.out.println(reqSQL);
		}
		if (noCategorie!=-1) {
			reqSQL.append(WHERE_CATEGORIE_IS);
			reqSQL.append(noCategorie);
			System.out.println(reqSQL);
		}
		if (pseudo.length()!=0) {
			reqSQL.append(WHERE_UTILISATEUR_IS);
			reqSQL.append(pseudo);
			System.out.println(reqSQL);
		}		
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery(reqSQL.toString());
				List<ArticleVendu> articles = q.getResultList();
				
				
		session.close();
		if (articles.size() == 0) {
			return null;
		} else {
			return articles;
		}
	}

	@Override
	public List<ArticleVendu> selectArticleAcheteurOuverte(String pseudo, String contient, int noCategorie) {
		Session session = ConnectionProvider.getConnection();
		Utilisateur utilisateur = new UtilisateurDAOJdbcImpl().selectUtilisateurByPseudo(pseudo);
		System.out.println(utilisateur);
		Query q = session.createQuery(
				"from ARTICLES_VENDUS a where a.nomArticle like :contient and  a.etatVente  = 1 AND a.utilisateur != :utilisateur");
		q.setParameter("contient", "%" + contient + "%");
		q.setParameter("utilisateur", utilisateur);
		List<ArticleVendu> articles = q.getResultList();
		session.close();
		if (articles.size() == 0) {
			return null;
		} else {
			return articles;
		}
	}

	@Override
	public List<ArticleVendu> selectArticleEncherEnCours(String pseudo, String contient, int noCategorie) {
		Session session = ConnectionProvider.getConnection();
		Utilisateur utilisateur = new UtilisateurDAOJdbcImpl().selectUtilisateurByPseudo(pseudo);
		Query q = session.createQuery(
				"SELECT a from ENCHERES e JOIN e.article a where a.etatVente  = 1 and e.utilisateur = :utilisateur");
		q.setParameter("utilisateur", utilisateur);
		List<ArticleVendu> articles = q.getResultList();
		session.close();
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
