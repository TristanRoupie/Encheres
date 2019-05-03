package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {
	
	public void addArticle(ArticleVendu article);
	public void updateArticle(ArticleVendu article);
	public void deleteArticle(ArticleVendu article);
	public List<ArticleVendu> selectAllArticle();
	public ArticleVendu selectArticleById(int noArtcile);
	public List<ArticleVendu> selectArticleBy(String pseudo , int achatVente , int etat , String contient );
	//select * from ARTICLES_VENDUS where nom_article like'%seche%' and utilisateur_no_utilisateur != 1 AND  GETDATE() < date_fin_encheres AND  GETDATE() < date_debut_encheres
	
	

}
