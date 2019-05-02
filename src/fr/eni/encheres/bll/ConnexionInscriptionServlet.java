package fr.eni.encheres.bll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreaCompteServlet
 */
@WebServlet("/connexionInscription")
public class ConnexionInscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATH_TO_CONNEXIONINSCRIPTION_JSP = "/WEB-INF/jsp/connexionInscription.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionInscriptionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(PATH_TO_CONNEXIONINSCRIPTION_JSP);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
