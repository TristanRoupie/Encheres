package fr.eni.encheres.bo;

import lombok.Data;

@Data
public class Retrait {
	private String rue;
	private int codePostal;
	private String ville;
}
