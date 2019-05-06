package fr.eni.encheres.bll;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitDAO;

public class RetraitManager {
	
	private RetraitDAO retraitDao;

	//Constructeur
	public RetraitManager(RetraitDAO retraitDao) {
		this.retraitDao = DAOFactory.getRetraitDAO();
	}
	
	//Methodes appelées
	public void addRetrait(int noArticle, String rue, String codePostal, String ville, ArticleVendu article) {
		Retrait retrait = null;
		
		retrait = new Retrait();
		retrait.setNoarticle(noArticle);
		retrait.setRue(rue);
		retrait.setCodePostal(codePostal);
		retrait.setVille(ville);
		retrait.setArticle(article);
		
		this.retraitDao.addRetrait(retrait);
	}
	
	public Retrait updateRetrait(Retrait retrait) {
		return this.updateRetrait(retrait);
		
		
	}
	
	public void deleteRetrait (Retrait retrait) {
	
			if (retrait !=null) {
				this.retraitDao.deleteRetrait(retrait);
			} else {
				System.out.println("Echec critique sur ton lancer de dé, tu ne peux pas supprimer ce point de retrait");
			}
	}

}
