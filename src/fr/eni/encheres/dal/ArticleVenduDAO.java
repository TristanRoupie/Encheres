package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;

public interface ArticleVenduDAO {
	
	public void addArticle(ArticleVendu article);
	public void updateArticle(ArticleVendu article);
	public void deleteArticle(ArticleVendu article);
	public List<ArticleVendu> selectAllArticle();
	public ArticleVendu selectArticleById(int noArticle);
	public List<ArticleVendu> selectArticleVendeur(String pseudo  , int etat , String contient,int noCategorie );
	public List<ArticleVendu> selectArticleAcheteurOuverte(String pseudo , String contient ,int noCategorie );
	public List<ArticleVendu> selectArticleEncherEnCours(String pseudo , String contient,int noCategorie  );
	public List<ArticleVendu> selectArticleEncherRemporte(String pseudo, String contient, int noCategorie);
	
	
	

}
