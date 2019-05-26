package fr.eni.encheres.bll;

public abstract class CodesResultsBLL {
	
	
	/**
	 * Echec quand le nom saisi ne respecte pas la règle définie
	 */
	public static final int REGLE_INSCRIPTION_NOM_ERREUR = 20000;
	
	/**
	 * Echec quand le prenom saisi ne respecte pas la règle définie
	 */
	public static final int REGLE_INSCRIPTION_PRENOM_ERREUR = 20001;

	/**
	 * Echec quand l'email saisi pour l'inscription existe deja en BDD (contrainte d'unicité)
	 */
	public static final int REGLE_INSCRIPTION_EMAIL_ERREUR = 20002;
	
	/**
	 * Echec quand le telephone de l'inscription ne respecte pas la règle définie
	 */
	public static final int REGLE_INSCRIPTION_TELEPHONE_ERREUR = 20003;
	
	/**
	 * Echec quand la rue saisie pour l'inscription ne respecte pas la règle définie
	 */
	public static final int REGLE_INSCRIPTION_RUE_ERREUR = 20004;
	
	/**
	 * Echec quand le code postal saisi pour l'inscription ne respecte pas la règle définie
	 */
	public static final int REGLE_INSCRIPTION_CODEPOSTAL_ERREUR = 20005;
	
	/**
	 * Echec quand le code postal saisi pour l'inscription ne respecte pas la règle définie
	 */
	public static final int REGLE_INSCRIPTION_VILLE_ERREUR = 20006;
	
	/**
	 * Echec quand le code postal saisi pour l'inscription ne respecte pas la règle définie
	 */
	public static final int REGLE_INSCRIPTION_MOTDEPASSE_ERREUR = 20007;
	
	
	/**
	 * Echec quand le pseudo pour l'inscription ne respecte pas la règle définie
	 */
	public static final int REGLE_INSCRIPTION_PSEUDO_ERREUR = 20008;
	
	/**
	 * Echec quand le pseuod ou le mot de passe déja utilisé
	 */
	public static final int PSEUDO_EMAIL_DEJA_UTILISE = 20009;
	

}
