package fr.eni.encheres.dal;


public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return  new UtilisateurJdbcImpl();
	}
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		return  new ArticleVenduDAOJdbcImpl();
	}
	

	

}
