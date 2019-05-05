package fr.eni.encheres.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "ARTICLES_VENDUS")
@Table(name = "ARTICLES_VENDUS")
@Data
public class ArticleVendu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "no_article", length = 11, nullable = false, unique = true)
	private int noArticle;
	@Column(name = "nom_article", length = 30, nullable = false)
	private String nomArticle;
	@Column(name = "description", length = 300, nullable = false)
	private String description;
	@Column(name = "date_debut_encheres", nullable = false)
	private Date dateDebutEncheres;
	@Column(name = "date_fin_encheres", nullable = false)
	private Date dateFinEncheres;
	@Column(name = "prix_initial", length = 11, nullable = true)
	private int miseAPrix;
	@Column(name = "prix_vente", length = 11, nullable = true)
	private int prixVente;
	@Column(name = "etat_vente", length = 1, nullable = false, columnDefinition = "int default 0")
	private int etatVente; // 0 or 1 because Lombok bugs with boolean
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "no_utilisateur")
	private Utilisateur utilisateur;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "no_categorie")
	private Categorie categorie;

	public ArticleVendu() {

	}

	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente, int etatVente, Utilisateur utilisateur,
			Categorie categorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;

	}

	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int miseAPrix, int prixVente, int etatVente, Utilisateur utilisateur, Categorie categorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;

	}

	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int miseAPrix, int etatVente, Utilisateur utilisateur, Categorie categorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.etatVente = etatVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}

}
