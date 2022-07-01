package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LivreDao;
import dao.DaoException;
import dao.DaoFactory;

/* Servlet implementation class ListeLivres */
@WebServlet("/ListeLivres")
public class ListeLivres extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LivreDao livreDao = DaoFactory.getInstance().getLivreDao();
		
		try {
			request.setAttribute("listeLivres", livreDao.lister());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeLivres.jsp").forward(request, response);
	}
}