package fr.eni.encheres.dal;


public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return  new UtilisateurDAOJdbcImpl();
	}
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		return  new ArticleVenduDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO() {
		return  new RetraitDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		return  new CategorieDAOJdbcImpl();
	}
	

	

}
