package fr.eni.encheres.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur ajouterUtilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, int codePostal, String ville, String motDePasse) throws BusinessException {

		BusinessException businessException = new BusinessException();

		Utilisateur utilisateur = null;

		if (!businessException.hasErrors()) {
			utilisateur = new Utilisateur();
			utilisateur.setNoUtilisateur(noUtilisateur);

//			Pseudo check with jRegex external lib
//			Regex for alphanumeric caracter only
			String regex = "^[a-zA-Z0-9]*$";
			Pattern patternPseudo = Pattern.compile(regex);
//			Create matcher object which is a boolean
			Matcher matcherPseudo = patternPseudo.matcher(pseudo);
			if (matcherPseudo.matches() == true) {
				utilisateur.setPseudo(pseudo);
			} else {
				System.out.println("Pseudo non valide");
				throw businessException;
			}
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			Pattern patternEmail = Pattern.compile(regex);
//			Create matcher object which is a boolean
			Matcher matcherEmail = patternEmail.matcher(pseudo);
			if (matcherEmail.matches() == true) {
				utilisateur.setEmail(email);
			} else {
				System.out.println("Email non valide");
			}
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(motDePasse);

			this.utilisateurDAO.addUtilisateur(utilisateur);
		} else {
			throw businessException;
		}

		return utilisateur;
	}

	public Utilisateur selectById(int noUtilisateur) throws BusinessException {
		return this.utilisateurDAO.selectUtilisateurByid(noUtilisateur);
	}

	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		return this.utilisateurDAO.selectUtilisateurByPseudo(pseudo);
	}

	public Utilisateur selectByEmail(String email) throws BusinessException {
		return this.utilisateurDAO.selectUtilisateurByEmail(email);
	}

	public void supprimerUtilisateur(int noUtilisateur) throws BusinessException {
		Utilisateur utilisateur = selectById(noUtilisateur);
		BusinessException businessException = new BusinessException();
		if (utilisateur != null) {
			this.utilisateurDAO.deleteUtilisateur(utilisateur);
		} else {
			System.out.println("Cet utilisateur n'existe pas");
			throw businessException;
		}
	}

	public Utilisateur modifierUtilisateur(int noUtilisateur) throws BusinessException {
		Utilisateur utilisateur = selectById(noUtilisateur);
		// TODO implement method logic
		return utilisateur;
	}
}
