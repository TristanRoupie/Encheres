package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void addUtilisateur(Utilisateur utilisateur);
	public void updateUtilisateur(Utilisateur utilisateur);
	public void deleteUtilisateur(Utilisateur utilisateur);
	public Utilisateur selectUtilisateurByid(int noUtilisateur);
	public Utilisateur selectUtilisateurByPseudo(String pseudo);
	public Utilisateur selectUtilisateurByEmail(String email);
	public Utilisateur checkUtilisateurByPseudo(String pseudo , String password);
	public Utilisateur checkUtilisateurByEmail(String email , String password);
	
}
