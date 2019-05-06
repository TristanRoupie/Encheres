package fr.eni.encheres.bll;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {
	
	private ArticleVenduDAO articleVenduDAO;

	//Constructeur qui passe par la DAOFactory
	public ArticleManager(ArticleVenduDAO articleVenduDAO) {
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}
	
	//Methodes demandées.
	public ArticleVendu ajouterArticleVendu() {
		return null;		
	}
	
	public void supprimerArticleVendu() {		
		
	}
	
	public ArticleVendu modifierArticleVendu() {
		return null;		
	}
	
	public ArticleVendu selectByIdArticleVendu (int noArticle) {
		return this.articleVenduDAO.selectArticleById(noArticle);
		
	}

}
