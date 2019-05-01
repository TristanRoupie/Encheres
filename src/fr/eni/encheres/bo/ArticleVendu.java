package fr.eni.encheres.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "ARTICLES_VENDUS")
@Table(name = "ARTICLES_VENDUS")
@Data
public class ArticleVendu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "no_article", length=11, nullable=false, unique=true)
	private int noArticle;
	@Column(name = "nom_article", length=30, nullable=false)
	private String nomArticle;
	@Column(name = "description", length=300, nullable=false)
	private String description;
	@Column(name = "date_debut_encheres", nullable=false)
	private Date dateDebutEncheres;
	@Column(name = "date_fin_encheres", nullable=false)
	private Date dateFinEncheres;
	@Column(name = "prix_initial", length=11, nullable=true )
	private int miseAPrix;
	@Column(name = "prix_vente", length=11, nullable=true )
	private int prixVente;
	@Column(name = "etat_vente", length=1, nullable=false ,columnDefinition = "int default 0" )
	private int etatVente; // 0 or 1 because Lombok bugs with boolean
	@ManyToOne
	private Utilisateur utilisateur;
	@ManyToOne
	private Categorie categorie;
	
	//@one INTEGER NOT NULL
	//private Retrait lieuRetrait;



	public ArticleVendu() {

	}

}
