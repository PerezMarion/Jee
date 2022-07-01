package dao;

import java.util.List;

import model.Auteur;

/* Intarface permettant de rendre le code plus propre et de faciliter le travail */

public interface AuteurDao {

	void         creer( Auteur auteur ) throws DaoException;

    Auteur       trouver( long id ) throws DaoException;

    List<Auteur> lister() throws DaoException;

    void         supprimer( long id ) throws DaoException;
    
    void		 modifier( Auteur auteur ) throws DaoException;

}