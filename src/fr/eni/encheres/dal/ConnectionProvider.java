package fr.eni.encheres.dal;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fr.eni.encheres.bll.BusinessException;


/**
 * Au chargement de la classe, la DataSource est recherchée dans l'arbre JNDI
 */
public abstract class ConnectionProvider  {

	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");		
		} 		
	}

	/**
	 * Cette méthode retourne une connection opérationnelle issue du pool de connexion
	 * vers la base de données. 
	 * @return Session
	 * @throws SQLException
	 */
	public static Session getConnection() {
		return sessionFactory.openSession();
	}
}
