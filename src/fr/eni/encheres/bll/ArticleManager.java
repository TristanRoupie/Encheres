package fr.eni.encheres.bll;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.articlevendu.ArticleVenduDAO;
import fr.eni.encheres.exception.BusinessException;

public class ArticleManager {
	
	private ArticleVenduDAO articleVenduDAO;

	//Constructeur qui passe par la DAOFactory
	public ArticleManager(ArticleVenduDAO articleVenduDAO) {
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}
	
	//Methodes demandées.
	public ArticleVendu ajouterArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int etatVente, Utilisateur utilisateur,
			Categorie categorie) throws BusinessException {
		
		BusinessException businessException = new BusinessException();
		ArticleVendu articleVendu = null;
		//EtatVente etatvente = null;
		
		if (!businessException.hasErrors()) {
			articleVendu = new ArticleVendu();
			articleVendu.setNoArticle(noArticle);

			//ArticleVendu check with jRegex external lib
			//Regex for alphanumeric caracter only
			String regex = "^[a-zA-Z0-9]*$";
			Pattern patternNomArticle = Pattern.compile(regex);
			//Create matcher object which is a boolean
			Matcher matcherNomArticle = patternNomArticle.matcher(nomArticle);
			if (matcherNomArticle.matches() == true) {
				articleVendu.setNomArticle(nomArticle);;
			} else {
				System.out.println("Nom non valide");
				throw businessException;
			}
			articleVendu.setNomArticle(nomArticle);
			articleVendu.setDescription(description);
			articleVendu.setDateDebutEncheres(dateDebutEncheres);
			articleVendu.setDateFinEncheres(dateFinEncheres);
			articleVendu.setMiseAPrix(miseAPrix);
			articleVendu.setEtatVente(etatVente);
			articleVendu.setUtilisateur(utilisateur);

			this.articleVenduDAO.addArticle(articleVendu);
		} else {
			throw businessException;
		}

		return articleVendu;
	}		
	
	
	public void supprimerArticleVendu(int noArticle) {
		ArticleVendu articleVendu = selectByIdArticleVendu(noArticle);
		if (articleVendu != null) {
			this.articleVenduDAO.deleteArticle(articleVendu); }
			else {
				System.out.println("L'article n'existe pas");
			}
		}	
	
	public ArticleVendu modifierArticleVendu(int noArticle) {
		ArticleVendu articlevendu = selectByIdArticleVendu(noArticle);
		return this.modifierArticleVendu(noArticle);		
	}
	
	public ArticleVendu selectByIdArticleVendu (int noArticle) {
		return this.articleVenduDAO.selectArticleById(noArticle);
		
	}

}
