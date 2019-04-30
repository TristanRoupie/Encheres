package fr.eni.encheres.bo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "no_Categorie", length=11, nullable=false, unique=true)
	private int noCategorie;
	@Column(name = "libelle", length=30, nullable=false)
	private String libelle;
			
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle; 
	}

	public Categorie() {

	}

}
