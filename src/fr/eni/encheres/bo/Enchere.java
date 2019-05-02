package fr.eni.encheres.bo;

import java.util.Date;

import lombok.Data;

@Data
public class Enchere {
	private Date DateEnchere;
	private int montantEnchere;
	private Utilisateur utilisateur;
	private ArticleVendu article;

	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur utilisateur, ArticleVendu article) {
		super();
		DateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.article = article; 
	}

	public Enchere() {

	}

}
