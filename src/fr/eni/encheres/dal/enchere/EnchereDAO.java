package fr.eni.encheres.dal.enchere;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public interface EnchereDAO {
	
	public void addEnchere(Enchere enchere);
	public void updateEnchere(Enchere enchere);
	public void deleteEnchere(Enchere enchere);
	public List<Enchere> selectAllEnchere();
	public List<Enchere> selectEnchereByArticle(int noArticle);
	public List<Enchere> selectEnchereByUtilisateur(int noUtilisateur );
	public Enchere selectEnchere(int noArticle, int noUtilisateur);
	
	
	

}
