package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuteurDao;
import dao.DaoException;
import dao.DaoFactory;

/* Servlet implementation class detailsAuteur */
@WebServlet("/DetailsAuteur")
public class DetailsAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
		
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			request.setAttribute("auteur", auteurDao.trouver(id));
		}catch (DaoException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/DetailsAuteur.jsp").forward(request, response);
	}
}	