package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {
	
	public void addArticle(ArticleVendu article);
	public void updateArticle(ArticleVendu article);
	public void deleteArticle(ArticleVendu article);
	public List<ArticleVendu> selectAllArticle();
	public ArticleVendu selectArticleById(int noArtcile);
	
	

}
