package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;

public class CategorieManager {
	
	private CategorieDAO categorieDAO;

	//Constructeur
	public CategorieManager(CategorieDAO categorieDAO) {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}
	
	//MEthodes appelées.
	public void addCategorie(int noCategorie, String libelle) {
		Categorie categorie = null;
		categorie.setNoCategorie(noCategorie);
		categorie.setLibelle(libelle);
		this.categorieDAO.addCategorie(categorie);
		
	}
	public void updateCategorie(Categorie categorie) {
	}
	
	public void deleteCategorie(Categorie categorie) {
	}
	
	public List<Categorie> selectAllCategorie() {
		return null;
	}
	
	public Categorie selectCategorieByLibelle(String libele) {
		return null;
	}
	

}
