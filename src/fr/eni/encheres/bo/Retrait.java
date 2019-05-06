package fr.eni.encheres.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "RETRAITS")
@Data
public class Retrait {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "no_article", length = 11, nullable = false, unique = true)
	private int noarticle;
	@Column(name = "rue", length = 30, nullable = false)
	private String rue;
	@Column(name = "code_postal", length = 15, nullable = false)
	private String codePostal;
	@Column(name = "ville", length = 30, nullable = false)
	private String ville;

	@PrimaryKeyJoinColumn
    @OneToOne   
	private ArticleVendu article;

	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Retrait() {

	}

	public Retrait(int noarticle, String rue, String codePostal, String ville, ArticleVendu article) {
		super();
		this.noarticle = noarticle;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.article = article;
	}
	
	

}
