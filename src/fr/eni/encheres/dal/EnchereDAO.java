package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public interface EnchereDAO {
	
	public void addEnchere(Enchere enchere);
	public void updateEnchere(Enchere enchere);
	public void deleteEnchere(Enchere enchere);
	public List<Enchere> selectAllEnchere();
	public List<Enchere> selectEnchereByArticle(ArticleVendu article);
	public List<Enchere> selectEnchereByUtilisateur(Utilisateur utilisateur );
	public Enchere selectEnchere(int noArticle, int noUtilisateur);
	
	
	

}
