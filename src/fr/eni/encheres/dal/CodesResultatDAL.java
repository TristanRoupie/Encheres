package fr.eni.encheres.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	

	/**
	 * Echec de d'obtention de connexion
	 */
	public static final int FAULT_GET_CONNECTION=10000;
	
	/**
	 * Echec tentative d'ajout d'un utilisateur null
	 */
	public static final int INSERT_USER_NULL=10001;
	

	/**
	 * Echec de d'ajout d'un utilisateur dans la base de données
	 */
	public static final int FAULT_ADD_USER=10002;

	/**
	 * Echec tentative de modification d'un utilisateur null
	 */
	public static final int UPDATE_USER_NULL=10003;
	

	/**
	 * Echec de modification d'un utilisateur dans la base de données
	 */
	public static final int FAULT_UPDATE_USER=10004;
	
	
}