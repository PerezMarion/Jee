package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DaoException;
import dao.DaoFactory;
import dao.LivreDao;

/* Servlet implementation class DetailsLivre */
@WebServlet("/DetailsLivre")
public class DetailsLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LivreDao livreDao = DaoFactory.getInstance().getLivreDao();
		
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			request.setAttribute("livre", livreDao.trouver(id));
		}catch (DaoException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/DetailsLivre.jsp").forward(request, response);
	}
}