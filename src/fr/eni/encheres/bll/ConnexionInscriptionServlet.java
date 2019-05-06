package fr.eni.encheres.bll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class CreaCompteServlet
 */
@WebServlet("/connexionInscription")
public class ConnexionInscriptionServlet extends HttpServlet {
	private static final String PATH_TO_INDEX_JSP = "/WEB-INF/jsp/index.jsp";
	private static final long serialVersionUID = 1L;
	private static final String PATH_TO_CONNEXIONINSCRIPTION_JSP = "/WEB-INF/jsp/connexionInscription.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionInscriptionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(PATH_TO_CONNEXIONINSCRIPTION_JSP);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Parameters initialisation
		int noUtilisateur = 0;
		String pseudo = null;
		String nom = null;
		String prenom = null;
		String email = null;
		String telephone = null;
		String rue = null;
		String codePostal = null;
		String ville = null;
		String motDePasse = null;

		try {
//			Parameter input fetch
			pseudo = request.getParameter("pseudo");
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			email = request.getParameter("email");
			telephone = request.getParameter("telephone");
			rue = request.getParameter("rue");
			codePostal = request.getParameter("codepostal");
			ville = request.getParameter("ville");
			motDePasse = request.getParameter("mdpnow");

			UtilisateurManager utilisateurManager = new UtilisateurManager();
			Utilisateur utilisateur = utilisateurManager.ajouterUtilisateur(noUtilisateur, pseudo, nom, prenom, email,
					telephone, rue, codePostal, ville, motDePasse);
			request.setAttribute("utilisateur", utilisateur);
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getlisteCodesErrors());
		}
		RequestDispatcher rd = request.getRequestDispatcher(PATH_TO_INDEX_JSP);
		rd.forward(request, response);
	}

}
