package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
 
	 private String url;
	 private String username;
	 private String passwd;
	 private Connection con = null;
	
	 private static DaoFactory instanceSingleton = null;
 
	 /* Constructeur privé  dont l'usage est limité à la classe elle même
	  * (Utilisation dans la méthode "getInstance()") */
	 
	 private DaoFactory(String url, String username, String passwd) {
		this.url = url;
		this.username = username;
		this.passwd = passwd;
	}
	
	 /* Méthode permettant de vérifier si l'instance DaoFactory est déjà instanciée car il ne peut en avoir qu'une seule (singleton) */
	 
	public static DaoFactory getInstance() {
		if ( DaoFactory.instanceSingleton == null ) {
			try {
			      Class.forName("org.postgresql.Driver");
			      DaoFactory.instanceSingleton = new DaoFactory("jdbc:postgresql://localhost/biblio2","postgres","marion");
		  } catch(ClassNotFoundException e) {
			  e.printStackTrace();
		  }
		}
		return DaoFactory.instanceSingleton;
	}
	
	/* Méthodes permettant de retourner un AuteurDaoImpl/LivreDaoImpl
	 * Utilisée dans le launcher lorsque l'on créer un nouvel objet AuteurDaoImpl/LivreDaoImpl
	 * Fournisseur de Dao (centralisation de la création) */
	
	public AuteurDao getAuteurDao() {
		return new AuteurDaoImpl( this );
	}
	
	public LivreDao getLivreDao() {
		return new LivreDaoImpl( this );
	}
	
	/* Méthode permettant d'effectuer la connexion à la base de données */

	Connection getConnection() throws SQLException {
		if ( this.con == null ) {
	      this.con = DriverManager.getConnection(url,username,passwd);
		}
		return this.con;
	}
	
	/* Méthode permettant de prendre une connexion en parametre
	 * en presagent que l'on pourrait en utiliser plusieurs mais par construction, 
	 * actuellement la seule connection existante est stockee dans "this.con" */
	
	void releaseConnection( Connection connectionRendue ) {
		if (this.con==null) {
			return;
		}
		try {
			if ( ! this.con.isValid(10) ) {
				this.con.close();
				this.con = null;
			}
		} catch (SQLException e) {
			this.con = null;
		}
	}
}