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
import dao.LivreDao;
import model.Auteur;
import model.Livre;

/**
 * Servlet implementation class ModifierLivre
 */
@WebServlet("/ModifierLivre")
public class ModifierLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LivreDao livreDao;
	private AuteurDao auteurDao;
	
	public ModifierLivre() {
        super();
        livreDao = DaoFactory.getInstance().getLivreDao();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			request.setAttribute("livre", livreDao.trouver(id));
			request.setAttribute("listeAuteurs", auteurDao.lister());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ModifierLivre.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titre = request.getParameter("titre");
		Auteur auteur;
		int nbPages = Integer.parseInt(request.getParameter("nbPages")) ;
		String categorie = request.getParameter("categorie");
		
		long id = Long.parseLong(request.getParameter("id"));
		long idAuteur = Long.parseLong(request.getParameter("idAuteur"));
		
		try {
			auteur = auteurDao.trouver(idAuteur);
			
			Livre livre = livreDao.trouver(id);
			livre.setTitre(titre);
			livre.setAuteur(auteur);
			livre.setNbPages(nbPages);
			livre.setCategorie(categorie);
			
			livreDao.modifier(livre);
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/ListeLivres");
	}
}