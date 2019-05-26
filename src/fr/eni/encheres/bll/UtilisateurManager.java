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
		pseudo = validString(pseudo, 30, this.REGEX_ALPHANUMERIC, businessException,
				CodesResultsBLL.REGLE_INSCRIPTION_PSEUDO_ERREUR);
		if (this.utilisateurDAO.selectUtilisateurByPseudo(pseudo)!=null) {
			businessException.ajouterErrors(CodesResultsBLL.PSEUDO_EMAIL_DEJA_UTILISE);
		};
		// test nom
		nom = validString(nom, 30, null, businessException, CodesResultsBLL.REGLE_INSCRIPTION_NOM_ERREUR);
		// test Prenom
		prenom = validString(prenom, 30, null, businessException, CodesResultsBLL.REGLE_INSCRIPTION_PRENOM_ERREUR);
		// test Email
		email = validString(email, 50, this.REGEX_EMAIL, businessException,
				CodesResultsBLL.REGLE_INSCRIPTION_EMAIL_ERREUR);
		if (this.utilisateurDAO.selectUtilisateurByEmail(email)!=null) {
			businessException.ajouterErrors(CodesResultsBLL.PSEUDO_EMAIL_DEJA_UTILISE);
		};
		// test Telephone
		telephone = validString(telephone, 15, this.REGEX_NUMERIC, businessException,
				CodesResultsBLL.REGLE_INSCRIPTION_TELEPHONE_ERREUR);
		// test Rue
		rue = validString(rue, 30, null, businessException, CodesResultsBLL.REGLE_INSCRIPTION_RUE_ERREUR);
		// test codepostal
		codePostal = validString(codePostal, 5, this.REGEX_NUMERIC, businessException,
				CodesResultsBLL.REGLE_INSCRIPTION_CODEPOSTAL_ERREUR);
		// test ville
		ville = validString(ville, 30, null, businessException, CodesResultsBLL.REGLE_INSCRIPTION_VILLE_ERREUR);
		// test mot de passe
		motDePasse = validString(motDePasse, 30, null, businessException,
				CodesResultsBLL.REGLE_INSCRIPTION_MOTDEPASSE_ERREUR);

		if (!businessException.hasErrors()) {
			utilisateur = new Utilisateur(pseudo, nom, prenom, email, rue, codePostal, ville, motDePasse);
			this.utilisateurDAO.addUtilisateur(utilisateur);
		} else {
			throw businessException;
		}

		return utilisateur;
	}

	/***
	 * Check string
	 * 
	 * @param string
	 * @param businessException
	 * @return String string
	 *         <p>
	 * test si la chaine envoyé est null respect la longueur maximal et minimal
	 * et ensuite test une regex
	 *         </p>
	 */
	private String validString(String string, int lenght, String pattern, BusinessException businessException,
			int faultNumber) {
		string = string.trim();
		if (string == null || string.length() > lenght || string == "") {
			businessException.ajouterErrors(faultNumber);
			return null;
		} else {
			string = validPattern(string, pattern, businessException, faultNumber);
			return string;
		}
	}

	private String validPattern(String string, String checkPattern, BusinessException businessException,
			int faultNumber) {
		if ((checkPattern != null) && (checkPattern.length() > 0)) {
			Pattern pattern = Pattern.compile(checkPattern);
			Matcher matcher = pattern.matcher(string);
			if (matcher.matches() == false) {
				businessException.ajouterErrors(faultNumber);
				return null;
			} else {
				return string;
			}
		} else {
			return string;
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
