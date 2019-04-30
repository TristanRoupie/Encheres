package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;


public interface ArticleVenduDAO {
	
	public void addArticle(ArticleVendu artilce);
	public void updateArticle(ArticleVendu artilce);
	public void deleteArticle(ArticleVendu artilce);
	public List<ArticleVendu> selectAllArticle();
	
	

}
