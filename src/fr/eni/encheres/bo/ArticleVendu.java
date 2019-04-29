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
	private byte etatVente; // 0 or 1 because Lombok bugs with boolean
	private int idAcheteur;
	private int idVendeur;
	private Retrait lieuRetrait;
	private Categorie categorie;

	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente, byte etatVente, int idAcheteur, int idVendeur,
			Retrait lieuRetrait, Categorie categorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.idAcheteur = idAcheteur;
		this.idVendeur = idVendeur;
		this.lieuRetrait = lieuRetrait;
		this.categorie = categorie;
	}

	public ArticleVendu() {

	}

}
