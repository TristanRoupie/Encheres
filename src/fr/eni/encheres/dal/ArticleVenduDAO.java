package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {
	
	public void addArticle(ArticleVendu article);
	public void updateArticle(ArticleVendu article);
	public void deleteArticle(ArticleVendu article);
	public List<ArticleVendu> selectAllArticle();
	public ArticleVendu selectArticleById(int noArtcile);
	public List<ArticleVendu> selectArticleVendeur(String pseudo  , int etat , String contient );
	public List<ArticleVendu> selectArticleAcheteurOuverte(String pseudo , String contient );
	public List<ArticleVendu> selectArticleEncherEnCours(String pseudo , String contient );
	
	
	

}
