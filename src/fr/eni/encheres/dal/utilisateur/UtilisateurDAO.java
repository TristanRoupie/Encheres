package fr.eni.encheres.dal.utilisateur;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.exception.BusinessException;

public interface UtilisateurDAO {
	
	/***
	 * ajoute un utilisateur dans la base de données
	 * @param Utilisateur Without numeroUtilisateur
	 * @throws BusinessExcception 
	 *    
	 *<p> Note: - Exception transformé IllegalStateException|RollbackException Exception</p>
	 *<p>Créée BusinessException si Utilisateur null</p>
	 *                            
	 * @author Tristan Roupie     
	 * 
	 */
	public void addUtilisateur(Utilisateur utilisateur) throws BusinessException;
	
	/***
	 * modification d un utilisateur dans la base de données
	 * @param Utilisateur Without numeroUtilisateur
	 * @throws BusinessExcception 
	 *    
	 *<p> Note: - Exception transformé IllegalStateException|RollbackException Exception</p>
	 *<p>Créée BusinessException si Utilisateur null</p>
	 *                            
	 * @author Tristan Roupie     
	 * 
	 */
	public void updateUtilisateur(Utilisateur utilisateur) throws BusinessException;
	public void deleteUtilisateur(Utilisateur utilisateur) throws BusinessException;
	public Utilisateur selectUtilisateurByid(int noUtilisateur) throws BusinessException;
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws BusinessException;
	public Utilisateur selectUtilisateurByEmail(String email) throws BusinessException;

}
