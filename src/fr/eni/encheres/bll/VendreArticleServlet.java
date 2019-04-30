package fr.eni.encheres.bll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VendreArticleServlet
 */
@WebServlet("/vendreArticle")
public class VendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATH_TO_VENDREARTICLE_JSP = "/WEB-INF/jsp/vendreArticle.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendreArticleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(PATH_TO_VENDREARTICLE_JSP);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
