package dao;

import java.util.List;

import model.Livre;

public interface LivreDao {
	
	void creer(Livre livre) throws DaoException;

	Livre trouver(long id) throws DaoException;

	List<Livre> lister() throws DaoException;
	
	void supprimer(long id) throws DaoException;

	void modifier(Livre livre) throws DaoException;
	
}