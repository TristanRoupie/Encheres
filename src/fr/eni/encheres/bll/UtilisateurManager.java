package fr.eni.encheres.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.exception.BusinessException;
import sun.net.TelnetInputStream;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	private final String REGEX_ALPHANUMERIC = "^[a-zA-Z0-9]*$";
	private final String REGEX_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	private final String REGEX_NUMERIC = "^[0-9]*$";

	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur ajouterUtilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostal, String ville, String motDePasse) throws BusinessException {

		BusinessException businessException = new BusinessException();

		Utilisateur utilisateur = null;

		// test pseudo
		pseudo = validPseudo(pseudo.trim(), businessException);
		// test nom
		nom = validNom(nom.trim(), businessException);
		// test Prenom
		prenom = validPrenom(prenom.trim(), businessException);
		// test Email
		email = validMail(email.trim(), businessException);
		// test Telephone
		telephone = validTelephone(telephone.trim(), businessException);
		// test Rue
		rue = validRue(rue.trim(), businessException);
		// test codepostal
		codePostal = validAdresse(codePostal.trim(), businessException);
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

		if (!businessException.hasErrors()) {
			utilisateur = new Utilisateur(pseudo, nom, prenom, email, rue, codePostal, ville, motDePasse);
			this.utilisateurDAO.addUtilisateur(utilisateur);
		} else {
			throw businessException;
		}

		return utilisateur;
	}

	/***
	 * Check pseudo
	 * 
	 * @param pseudo
	 * @param businessException
	 * @return String Pseudo
	 *         <p>
	 *         si le pseudo n'est pas valide un code erreur est ajouté pour être
	 *         remonté vers la jps
	 *         </p>
	 */
	private String validPseudo(String pseudo, BusinessException businessException) {
		Pattern patternPseudo = Pattern.compile(this.REGEX_ALPHANUMERIC);
		Matcher matcherPseudo = patternPseudo.matcher(pseudo);
		if (matcherPseudo.matches() == false || pseudo.length() > 30) {
			businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_PSEUDO_ERREUR);
			return null;
		} else {
			return pseudo;
		}
	}

	/***
	 * Check nom
	 * 
	 * @param nom
	 * @param businessException
	 * @return String nom
	 *         <p>
	 *         si le nom n'est pas valide un code erreur est ajouté pour être
	 *         remonté vers la jps
	 *         </p>
	 */
	private String validNom(String nom, BusinessException businessException) {
		if (nom == null || nom.length() > 30 || nom == "") {
			businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_NOM_ERREUR);
			return null;
		} else {
			return nom;
		}
	}

	/***
	 * Check prenom
	 * 
	 * @param prenom
	 * @param businessException
	 * @return String prenom
	 *         <p>
	 *         si le pseudo n'est pas valide un code erreur est ajouté pour être
	 *         remonté vers la jps
	 *         </p>
	 */
	private String validPrenom(String prenom, BusinessException businessException) {
		if (prenom == null || prenom.length() > 30 || prenom == "") {
			businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_PRENOM_ERREUR);
			return null;
		} else {
			return prenom;
		}
	}

	/***
	 * Check email
	 * 
	 * @param email
	 * @param businessException
	 * @return String email
	 *         <p>
	 *         si l'email n'est pas valide un code erreur est ajouté pour être
	 *         remonté vers la jps
	 *         </p>
	 */
	private String validMail(String email, BusinessException businessException) {
		Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
		Matcher matcherEmail = patternEmail.matcher(email);
		if (email == null || email.length() > 50 || email == ""|| matcherEmail.matches() == false) {
			businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_EMAIL_ERREUR);
			return null;
		} else {
			return email;
		}
	}

	/***
	 * Check telephone
	 * 
	 * @param telephone
	 * @param businessException
	 * @return String telephone
	 *         <p>
	 *         si le telephone n'est pas valide un code erreur est ajouté pour être
	 *         remonté vers la jps
	 *         </p>
	 */
	private String validTelephone(String telephone, BusinessException businessException) {
		Pattern patternTelephone = Pattern.compile(REGEX_NUMERIC);
		Matcher matcherTelephone = patternTelephone.matcher(telephone);
		if (telephone == null || telephone.length() > 30 || matcherTelephone.matches() == false) {
			businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_TELEPHONE_ERREUR);
			return null;
		} else {
			return telephone;
		}
	}

	/***
	 * Check rue
	 * 
	 * @param rue
	 * @param businessException
	 * @return String rue
	 *         <p>
	 *         si le rue n'est pas valide un code erreur est ajouté pour être
	 *         remonté vers la jps
	 *         </p>
	 */
	private String validRue(String rue, BusinessException businessException) {
		if (rue == null || rue.length() > 30) {
			businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_RUE_ERREUR);
			return null;
		} else {
			return rue;
		}
	}

	/***
	 * Check code postal
	 * 
	 * @param code              postal
	 * @param businessException
	 * @return String code postal
	 *         <p>
	 *         si le code postal n'est pas valide un code erreur est ajouté pour
	 *         être remonté vers la jps
	 *         </p>
	 */
	private String validAdresse(String codePostal, BusinessException businessException) {
		Pattern patternCodePostal = Pattern.compile(REGEX_NUMERIC);
		Matcher matcherCodePostal = patternCodePostal.matcher(codePostal);
		if ((codePostal == null) || (codePostal.length() > 5) || (matcherCodePostal.matches() == false)) {
			System.out.println("Champs code postal invalide");
			businessException.ajouterErrors(CodesResultsBLL.REGLE_INSCRIPTION_CODEPOSTAL_ERREUR);
			return null;
		} else {
			return codePostal;
		}
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
