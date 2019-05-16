package fr.eni.encheres.bll;

import java.util.Date;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.enchere.EnchereDAO;

public class EnchereManager {
	private EnchereDAO enchereDAO;

	//Constructeur qui passe par la DAOFactory
	public EnchereManager(EnchereDAO enchereDAO) {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}

	//Methode demandé :
	//Methode selectByIdEnchere a revoir car elle bug
	public Enchere selectEnchere(int noArticle, int noUtilisateur) {
		return this.enchereDAO.selectEnchere(noArticle, noUtilisateur);
	}
	
	public void  supprimerEnchere(int noArticle, int noUtilisateur) {
		Enchere enchere = selectEnchere(noArticle, noUtilisateur);
			if(enchere != null) {
				this.enchereDAO.deleteEnchere(enchere);
			} else {
				System.out.println("Le Maitre du Donjon décrète que ton enchère n'existe pas mouahahaha");
			}		
	}
	
	public Enchere ajouterEnchere(Date dateEnchere, int montantEnchere, Utilisateur utilisateur, ArticleVendu article) {
		
		Enchere enchere = null;
		
			enchere = new Enchere();
			enchere.setDateEnchere(dateEnchere);
			enchere.setMontantEnchere(montantEnchere);
			enchere.setUtilisateur(utilisateur);
			enchere.setArticle(article);
			
			this.enchereDAO.addEnchere(enchere);
	
		return enchere;		
	}
	
	public Enchere modifierEnchere(int noArticle, int noUtilisateur) {
		Enchere enchere = selectEnchere(noArticle, noUtilisateur);
		return this.modifierEnchere(noArticle, noUtilisateur);
		
	}
}
