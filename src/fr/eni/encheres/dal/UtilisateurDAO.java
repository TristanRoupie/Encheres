package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void addUtilisateur(Utilisateur utilisateur);
	public void updateUtilisateur(Utilisateur utilisateur);
	public void DeleteUtilisateur(Utilisateur utilisateur);
	public Utilisateur GetUtilisateur(int noUtilisateur);
	//TEST
	

}