package fr.eni.jee.dal;

import fr.eni.encheres.bo.Utilisateur;


public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return  new UtilisateurJdbcImpl();
	}
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		return  new UtilisateurJdbcImpl();
	}
	

	

}
