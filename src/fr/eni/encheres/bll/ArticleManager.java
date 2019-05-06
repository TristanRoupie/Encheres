package fr.eni.encheres.bll;

import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {
	
	private ArticleVenduDAO articleVenduDAO;

	//Constructeur qui passe par la DAOFactory
	public ArticleManager(ArticleVenduDAO articleVenduDAO) {
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}
	
	//Methodes demandées.

}
