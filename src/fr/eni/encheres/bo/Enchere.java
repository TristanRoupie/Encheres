package fr.eni.encheres.bo;

import java.util.Date;

import lombok.Data;

@Data
public class Enchere {
	private Date DateEnchere;
	private int montantEnchere;
	private int noUtilisateur;
	private int noArticle;

	public Enchere(Date dateEnchere, int montantEnchere, int noUtilisateur, int noArticle) {
		super();
		DateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle; 
	}

	public Enchere() {

	}

}
