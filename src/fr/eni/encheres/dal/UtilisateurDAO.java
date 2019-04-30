package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void addUtilisateur(Utilisateur utilisateur);
	public void updateUtilisateur(Utilisateur utilisateur);
	public void deleteUtilisateur(Utilisateur utilisateur);
	public Utilisateur selectUtilisateur(int noUtilisateur);
	//TEST
	

}
