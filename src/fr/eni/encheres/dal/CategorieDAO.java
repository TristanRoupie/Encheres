package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;


public interface CategorieDAO {
	
	public void addCategorie(Categorie categorie);
	public void updateCategorie(Categorie categorie);
	public void deleteCategorie(Categorie categorie);
	public List<Categorie> selectAllCategorie();
	public Categorie selectCategorieByLibelle(String libele);

}
