package fr.eni.encheres.exception;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author asylvain2019
 * 
 * This class is to list all possible errors of the application, whichever layer it's from
 *
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	private List<Integer> listeCodesErrors;

	public BusinessException() {
		super();
		this.listeCodesErrors = new ArrayList<>();
	}

	/**
	 * 
	 * @param code (Error code) Must have mapped message in properties file
	 */
	public void ajouterErrors(int code) {
		if (!this.listeCodesErrors.contains(code)) {
			this.listeCodesErrors.add(code);
		}
	}

	public boolean hasErrors() {
		return this.listeCodesErrors.size() > 0;
	}

	public List<Integer> getlisteCodesErrors() {
		return this.listeCodesErrors;
	}
}
