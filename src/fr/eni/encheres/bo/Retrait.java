package fr.eni.encheres.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "RETRAITS")
@Table(name = "RETRAITS")
@Data
public class Retrait {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "no_article", length = 11, nullable = false, unique = true)
	private int noArtcile;
	@Column(name = "rue", length = 30, nullable = false)
	private String rue;
	@Column(name = "code_postal", length = 15, nullable = false)
	private int codePostal;
	@Column(name = "ville", length = 30, nullable = false)
	private String ville;

	@PrimaryKeyJoinColumn
    @OneToOne   
	private ArticleVendu artcile;

	public Retrait(String rue, int codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Retrait() {

	}

}
