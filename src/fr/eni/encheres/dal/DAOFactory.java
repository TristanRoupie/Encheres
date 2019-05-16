package fr.eni.encheres.dal;

import fr.eni.encheres.dal.articlevendu.ArticleVenduDAO;
import fr.eni.encheres.dal.articlevendu.ArticleVenduDAOJdbcImpl;
import fr.eni.encheres.dal.categorie.CategorieDAO;
import fr.eni.encheres.dal.categorie.CategorieDAOJdbcImpl;
import fr.eni.encheres.dal.enchere.EnchereDAO;
import fr.eni.encheres.dal.enchere.EnchereDAOJdbcImpl;
import fr.eni.encheres.dal.retrait.RetraitDAO;
import fr.eni.encheres.dal.retrait.RetraitDAOJdbcImpl;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAOJdbcImpl;

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
	
	public static EnchereDAO getEnchereDAO() {
		return  new EnchereDAOJdbcImpl();
	}

	

}
