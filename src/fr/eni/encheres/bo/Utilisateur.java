package fr.eni.encheres.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//credit INTEGER NOT NULL,administrateur bit NOT NULL)

@Entity
@Table(name = "UTILISATEUR")
@Data
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "no_utilisateur", length=11, nullable=false, unique=true)
	private int noUtilisateur;
	@Column(name = "pseudo", length=30, nullable=false)
	private String pseudo;
	@Column(name = "nom", length=30, nullable=false)
	private String nom;
	@Column(name = "prenom", length=30, nullable=false)
	private String prenom;
	@Column(name = "email", length=50, nullable=false)
	private String email;
	@Column(name = "telephone", length=15, nullable=true)
	private String telephone;
	@Column(name = "rue", length=30, nullable=false)
	private String rue;
	@Column(name = "code_postal", length=10, nullable=false)
	private int codePostal;
	@Column(name = "ville", length=30, nullable=false)
	private String ville;
	@Column(name = "mot_de_passe", length=30, nullable=false)
	private String motDePasse;
	@Column(name = "credit", length=11, nullable=false, columnDefinition = "int default 0")
	private int credit;
	@Column(name = "administrateur", length=1, nullable=false, columnDefinition = "int default 0")
	private int administrateur; // 0 or 1 because Lombok bugs with boolean

	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, int codePostal, String ville, String motDePasse, int credit, int administrateur) {
		super();
		this.setNoUtilisateur(noUtilisateur);
		this.setPseudo (pseudo);
		this.setNom (nom);
		this.setPrenom (prenom);
		this.setEmail (email);
		this.setTelephone (telephone);
		this.setRue (rue);
		this.setCodePostal(codePostal);
		this.setVille (ville);
		this.setMotDePasse (motDePasse);
		this.setCredit (credit);
		this.setAdministrateur (administrateur);
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String rue, int codePostal, String ville,
			String motDePasse, int credit, int administrateur) {
		super();
		this.setPseudo (pseudo);
		this.setNom (nom);
		this.setPrenom (prenom);
		this.setEmail (email);
		this.setRue (rue);
		this.setCodePostal (codePostal);
		this.setVille (ville);
		this.setMotDePasse ( motDePasse);
		this.setCredit (credit);
		this.setAdministrateur(administrateur);
	}
	
	public Utilisateur() {

	}

}
