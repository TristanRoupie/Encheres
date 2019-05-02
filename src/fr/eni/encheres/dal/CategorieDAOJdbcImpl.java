package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;


import fr.eni.encheres.bo.Categorie;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	@Override
	public void addCategorie(Categorie categorie) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(categorie);
		session.getTransaction().commit();
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(categorie);
		session.getTransaction().commit();
	}

	@Override
	public void deleteCategorie(Categorie categorie) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.delete(categorie);
		session.getTransaction().commit();
	}

	@Override
	public List<Categorie> selectAllCategorie() {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("from CATEGORIES");
		List<Categorie> categories = q.getResultList();
		if (categories.size() == 0) {
			return null;
		} else {
			return categories;
		}
	}

	@Override
	public Categorie selectCategorieByLibelle(String libelle) {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("from CATEGORIES c where c.libelle = :libelle").setParameter("libelle", libelle);
		List<Categorie> categories = q.getResultList();
		if (categories.size() == 0) {
			return null;
		} else {
			return (Categorie) q.getSingleResult();
		}
	}
}
