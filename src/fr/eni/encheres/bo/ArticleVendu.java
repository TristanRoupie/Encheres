package fr.eni.encheres.bo;

import java.util.Date;

import lombok.Data;

@Data
public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private boolean etatVente;
	private int idAcheteur;
	private int idVendeur;
	private Retrait lieuRetrait;
	private Categorie categorie;
}
