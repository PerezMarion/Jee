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
import dao.AuteurDao;
import model.Auteur;
import model.Livre;

/* Servlet implementation class AjouterAuteur */
@WebServlet("/AjouterLivre")
public class AjouterLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private LivreDao livreDao;
	private AuteurDao auteurDao;
	
	public AjouterLivre() {
        super();
        livreDao = DaoFactory.getInstance().getLivreDao();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("listeAuteurs", auteurDao.lister());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterLivre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titre = request.getParameter("titre");
		Auteur auteur;
		int nbPages = Integer.parseInt(request.getParameter("nbPages")) ;
		String categorie = request.getParameter("categorie");
		
		long id = Long.parseLong(request.getParameter("idAuteur"));
		
		try {
			auteur = auteurDao.trouver(id);
			
			Livre livre = new Livre();
			livre.setTitre(titre);
			livre.setAuteur(auteur);
			livre.setNbPages(nbPages);
			livre.setCategorie(categorie);
			
			livreDao.creer(livre);
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/ListeLivres");
	}
}