package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;


import fr.eni.encheres.bo.Categorie;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	@Override
	public void addCategorie(Categorie categorie) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.save(categorie);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.saveOrUpdate(categorie);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteCategorie(Categorie categorie) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.delete(categorie);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Categorie> selectAllCategorie() {
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery("from Categorie");
		List<Categorie> categories = q.getResultList();
		session.close();
		if (categories.size() == 0) {
			return null;
		} else {
			return categories;
		}
	}

	@Override
	public Categorie selectCategorieByLibelle(String libelle) {
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery("from Categorie c where c.libelle = :libelle").setParameter("libelle", libelle);
		List<Categorie> categories = q.getResultList();
		if (categories.size() == 0) {
			session.close();
			return null;
		} else {
			Categorie categorie = (Categorie) q.getSingleResult();
			session.close();
			return categorie;
		}
	}
}
