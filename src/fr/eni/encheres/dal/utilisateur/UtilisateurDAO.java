package fr.eni.encheres.dal.utilisateur;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void addUtilisateur(Utilisateur utilisateur) throws BusinessException;
	public void updateUtilisateur(Utilisateur utilisateur) throws BusinessException;
	public void deleteUtilisateur(Utilisateur utilisateur) throws BusinessException;
	public Utilisateur selectUtilisateurByid(int noUtilisateur) throws BusinessException;
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws BusinessException;
	public Utilisateur selectUtilisateurByEmail(String email) throws BusinessException;
	public Utilisateur checkUtilisateur(String pseudo , String email, String motDePasse) throws BusinessException;
}
