package fr.eni.encheres.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur ajouterUtilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostal, String ville, String motDePasse) throws BusinessException {

		String regexAlphanumeric = "^[a-zA-Z0-9]*$";
		String regexNumeric = "^[0-9]*$";

		BusinessException businessException = new BusinessException();

		Utilisateur utilisateur = null;

		if (!businessException.hasErrors()) {
			utilisateur = new Utilisateur();
			utilisateur.setNoUtilisateur(noUtilisateur);

			// PSEUDO
			pseudo = pseudo.trim();
			Pattern patternPseudo = Pattern.compile(regexAlphanumeric);
//			Create matcher object which is a boolean
			Matcher matcherPseudo = patternPseudo.matcher(pseudo);
			if (matcherPseudo.matches() == true) {
				utilisateur.setPseudo(pseudo);
			} else {
				System.out.println("Pseudo non valide");
				throw businessException;
			}
//			NOM
			nom = nom.trim();
			if (nom.length() > 30 || nom == null || nom == "") {
				System.out.println("Champs nom invalide");
				businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_NOM_ERREUR);
			} else {
				utilisateur.setNom(nom);
			}
//			PRENOM
			prenom = prenom.trim();
			if (prenom.length() > 30 || prenom == null || prenom == "") {
				System.out.println("Champs prenom invalide");
				businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_PRENOM_ERREUR);
			} else {
				utilisateur.setPrenom(prenom);
			}
//			EMAIL
			email = email.trim();
			Pattern patternEmail = Pattern.compile(regexAlphanumeric);
//			Create matcher object which is a boolean
			Matcher matcherEmail = patternEmail.matcher(pseudo);
			if (matcherEmail.matches() == true) {
				utilisateur.setEmail(email);
			} else {
				System.out.println("Email non valide");
				businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_EMAIL_ERREUR);
			}
//			TELEPHONE
			telephone = telephone.trim();
			Pattern patternTelephone = Pattern.compile(regexNumeric);
//			Create matcher object which is a boolean
			Matcher matcherTelephone = patternTelephone.matcher(telephone);
			if (matcherTelephone.matches() == true) {
				utilisateur.setTelephone(telephone);
			} else {
				System.out.println("Telephone non valide");
				businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_TELEPHONE_ERREUR);
			}
//			RUE
			rue = rue.trim();
			if (rue.length() > 30 || rue == null) {
				System.out.println("Champs rue invalide");
				businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_RUE_ERREUR);
			} else {
				utilisateur.setRue(rue);
			}
//			CODE POSTAL
			codePostal = codePostal.trim();
			if (codePostal.length() > 5) {
				System.out.println("Champs code postal invalide");
				businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_CODEPOSTAL_ERREUR);
			} else {
				Pattern patternCodePostal = Pattern.compile(regexNumeric);
//				Create matcher object which is a boolean
				Matcher matcherCodePostal = patternCodePostal.matcher(codePostal);
				if (matcherCodePostal.matches() == true) {
					utilisateur.setCodePostal(codePostal);
				} else {
					System.out.println("Code postal non valide");
					businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_CODEPOSTAL_ERREUR);
				}
			}
//			VILLE
			ville = ville.trim();
			if (ville.length() > 30 || ville == null) {
				System.out.println("Champs ville invalide");
				businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_VILLE_ERREUR);
			} else {
				utilisateur.setVille(ville);
			}
//			MOT DE PASSE
			motDePasse = motDePasse.trim();
			if (motDePasse == null) {
				System.out.println("Le mot de passe doit contenir des caractères !");
				businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_MOTDEPASSE_ERREUR);
			} else {
				utilisateur.setMotDePasse(motDePasse);
			}

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
		pseudo = pseudo.trim();
		return this.utilisateurDAO.selectUtilisateurByPseudo(pseudo);
	}

	public Utilisateur selectByEmail(String email) throws BusinessException {
		email = email.trim();
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
	
	public void checkUtilisateur(int noUtilisateur) throws BusinessException {
		Utilisateur utilisateur = selectById(noUtilisateur);
		BusinessException businessException = new BusinessException();
		if (utilisateur == null) {
			System.out.println("Cet utilisateur n'existe pas");
			throw businessException;
		}
	}
	
	// TODO implement method logic
	public Utilisateur modifierUtilisateur(int noUtilisateur) throws BusinessException {
		Utilisateur utilisateur = selectById(noUtilisateur);
		return utilisateur;
	}
}
