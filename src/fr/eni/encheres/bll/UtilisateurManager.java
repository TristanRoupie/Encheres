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
			String telephone, String rue, int codePostal, String ville, String motDePasse, int credit,
			int administrateur) {

		Utilisateur utilisateur = null;
		utilisateur = new Utilisateur();
		utilisateur.setNoUtilisateur(noUtilisateur);

//		Pseudo check with jRegex external lib
//		Regex for alphanumeric caracter only
		String regex = "^[a-zA-Z0-9]*$";
		Pattern patternPseudo = Pattern.compile(regex);
//		Create matcher object which is a boolean
		Matcher matcherPseudo = patternPseudo.matcher(pseudo);
		if (matcherPseudo.matches() == true) {
			utilisateur.setPseudo(pseudo);
		} else {
			System.out.println("Pseudo non valide");
		}
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		Pattern patternEmail = Pattern.compile(regex);
//		Create matcher object which is a boolean
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
		utilisateur.setCredit(credit);
		utilisateur.setAdministrateur(administrateur);
		
		return utilisateur;
	}
}
