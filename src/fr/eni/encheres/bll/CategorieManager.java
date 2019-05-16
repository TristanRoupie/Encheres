package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.categorie.CategorieDAO;

public class CategorieManager {
	
	private CategorieDAO categorieDAO;

	//Constructeur
	public CategorieManager(CategorieDAO categorieDAO) {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}
	
	//MEthodes appelées.
	//Cette méthode a vérifié vu qu'elle m'indique une erreur chez moi.
	public void addCategorie(int noCategorie, String libelle) {
		Categorie categorie = null;
		categorie.setNoCategorie(noCategorie);
		categorie.setLibelle(libelle);
		this.categorieDAO.addCategorie(categorie);
		
	}
	public Categorie updateCategorie(Categorie categorie) {
		return this.updateCategorie(categorie);
		
	}
	
	public void deleteCategorie(Categorie categorie) {
		if (categorie != null) {
			this.categorieDAO.deleteCategorie(categorie);
		} else {
			System.out.println("Pas possible de supprimer cette catégorie saperlipopette !");
		}
	}
	
	public List<Categorie> selectAllCategorie() {
		return this.categorieDAO.selectAllCategorie();
	}
	
	public Categorie selectCategorieByLibelle(String libele) {
		return this.categorieDAO.selectCategorieByLibelle(libele);
	}
	

}
