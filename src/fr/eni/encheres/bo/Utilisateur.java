package fr.eni.encheres.bo;

import lombok.Data;

@Data
public class Utilisateur {
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private int codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private byte administrateur; // 0 or 1 because Lombok bugs with boolean
}
