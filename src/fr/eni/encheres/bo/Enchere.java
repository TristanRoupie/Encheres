package fr.eni.encheres.bo;

import java.util.Date;

import lombok.Data;

@Data
public class Enchere {
	private Date DateEnchere;
	private int montantEnchere;
	private int noUtilisateur;
	private int noArticle;
}
