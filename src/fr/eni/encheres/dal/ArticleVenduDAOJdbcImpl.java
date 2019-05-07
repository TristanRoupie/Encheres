package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	private final String REQUETE_VENDEUR = "FROM ArticleVendu a WHERE a.etatVente = :etatVente ";
	private final String REQUETE_ACHETEUR = "SELECT e.article FROM Enchere e WHERE e.article.etatVente = :etatVente ";

	private final String WHERE_ARTICLE_LIKE = "AND a.nomArticle LIKE :contient ";
	private final String WHERE_ARTICLE_LIKE_ACHETEUR = "AND e.article.nomArticle LIKE :contient ";

	private final String WHERE_CATEGORIE_IS = "AND a.categorie.noCategorie = :noCategorie ";
	private final String WHERE_CATEGORIE_IS_ACHETEUR = "AND e.article.categorie.noCategorie = :noCategorie ";

	private final String WHERE_UTILISATEUR_IS = "AND a.utilisateur.pseudo = :pseudo ";
	private final String WHERE_UTILISATEUR_IS_NOT = "AND a.utilisateur.pseudo != :pseudo ";
	private final String WHERE_ACHETEUR_IS = "AND e.utilisateur.pseudo = :pseudo ";
	
	private final String WHERE_MONTANT_ENCHERE = "AND e.montantEnchere = e.article.prixVente ";
	

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
		System.out.println(reqSQL);

		if (contient.length() != 0) {
			reqSQL.append(WHERE_ARTICLE_LIKE);
			System.out.println(reqSQL);
		}
		if (noCategorie != -1) {
			reqSQL.append(WHERE_CATEGORIE_IS);
			System.out.println(reqSQL);
		}
		if (pseudo.length() != 0) {
			reqSQL.append(WHERE_UTILISATEUR_IS);
			System.out.println(reqSQL);
		}

		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery(reqSQL.toString());
		q.setParameter("etatVente", etat);

		if (contient.length() != 0) {
			q.setParameter("contient", "%" + contient + "%");
		}
		if (noCategorie != -1) {
			q.setParameter("noCategorie", noCategorie);
		}
		if (pseudo.length() != 0) {
			q.setParameter("pseudo", pseudo);
		}
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
		StringBuilder reqSQL = new StringBuilder();
		// preparation de la requete sql en fonction des parametres envoyé
		reqSQL.append(REQUETE_VENDEUR);
		System.out.println(reqSQL);

		if (contient.length() != 0) {
			reqSQL.append(WHERE_ARTICLE_LIKE);
			System.out.println(reqSQL);
		}
		if (noCategorie != -1) {
			reqSQL.append(WHERE_CATEGORIE_IS);
			System.out.println(reqSQL);
		}
		if (pseudo.length() != 0) {
			reqSQL.append(WHERE_UTILISATEUR_IS_NOT);
			System.out.println(reqSQL);
		}
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery(reqSQL.toString());
		q.setParameter("etatVente", 1);

		if (contient.length() != 0) {
			q.setParameter("contient", "%" + contient + "%");
		}
		if (noCategorie != -1) {
			q.setParameter("noCategorie", noCategorie);
		}
		if (pseudo.length() != 0) {
			q.setParameter("pseudo", pseudo);
		}
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
		StringBuilder reqSQL = new StringBuilder();
		// preparation de la requete sql en fonction des parametres envoyé
		reqSQL.append(REQUETE_ACHETEUR);
		System.out.println(reqSQL);

		if (contient.length() != 0) {
			reqSQL.append(WHERE_ARTICLE_LIKE_ACHETEUR);
			System.out.println(reqSQL);
		}
		if (noCategorie != -1) {
			reqSQL.append(WHERE_CATEGORIE_IS_ACHETEUR);
			System.out.println(reqSQL);
		}
		if (pseudo.length() != 0) {
			reqSQL.append(WHERE_ACHETEUR_IS);
			System.out.println(reqSQL);
		}
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery(reqSQL.toString());

		q.setParameter("etatVente", 1);

		if (contient.length() != 0) {
			q.setParameter("contient", "%" + contient + "%");
		}
		if (noCategorie != -1) {
			q.setParameter("noCategorie", noCategorie);
		}
		if (pseudo.length() != 0) {
			q.setParameter("pseudo", pseudo);
		}

		List<ArticleVendu> articles = q.getResultList();
		session.close();
		if (articles.size() == 0) {
			return null;
		} else {
			return articles;
		}

	}

	@Override
	public List<ArticleVendu> selectArticleEncherRemporte(String pseudo, String contient, int noCategorie) {
		StringBuilder reqSQL = new StringBuilder();
		// preparation de la requete sql en fonction des parametres envoyé
		reqSQL.append(REQUETE_ACHETEUR);
		reqSQL.append(WHERE_MONTANT_ENCHERE);
		System.out.println(reqSQL);

		if (contient.length() != 0) {
			reqSQL.append(WHERE_ARTICLE_LIKE_ACHETEUR);
			System.out.println(reqSQL);
		}
		if (noCategorie != -1) {
			reqSQL.append(WHERE_CATEGORIE_IS_ACHETEUR);
			System.out.println(reqSQL);
		}
		if (pseudo.length() != 0) {
			reqSQL.append(WHERE_ACHETEUR_IS);
			System.out.println(reqSQL);
		}
		
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery(reqSQL.toString());

		q.setParameter("etatVente", 2);

		if (contient.length() != 0) {
			q.setParameter("contient", "%" + contient + "%");
		}
		if (noCategorie != -1) {
			q.setParameter("noCategorie", noCategorie);
		}
		if (pseudo.length() != 0) {
			q.setParameter("pseudo", pseudo);
		}
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
