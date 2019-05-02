package fr.eni.encheres.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "CATEGORIES")
@Table(name = "CATEGORIES")
@Data
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "no_categorie", length=11, nullable=false, unique=true)
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

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	
	
	
	
	

}
