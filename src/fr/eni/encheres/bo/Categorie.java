package fr.eni.encheres.bo;

import lombok.Data;

@Data
public class Categorie {
	private int noCategorie;
	private String libelle;

	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public Categorie() {

	}

}
