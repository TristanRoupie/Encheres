package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;


public interface CategorieDAO {
	
	public void addCategorie(Categorie Categorie);
	public void updateCategorie(Categorie article);
	public void deleteCategorie(Categorie article);
	public List<Categorie> selectAllCategorie();
	public Categorie selectCategorieByLibelle(String libelle);

}
