package fr.eni.encheres.dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class ConnectionProvider {

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public static Session getConnection() {
		return sessionFactory.openSession();
	}
}
