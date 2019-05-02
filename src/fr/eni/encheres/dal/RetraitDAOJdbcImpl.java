package fr.eni.encheres.dal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retrait;

public class RetraitDAOJdbcImpl implements RetraitDAO {

	@Override
	public void addRetrait(Retrait retrait) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(retrait);
		session.getTransaction().commit();

	}

	@Override
	public void updateRetrait(Retrait retrait) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(retrait);
		session.getTransaction().commit();

	}

	@Override
	public void deleteRetrait(Retrait retrait) {
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.delete(retrait);
		session.getTransaction().commit();

	}

	@Override
	public List<Retrait> selectAllRetrait() {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("from RETRAITS");
		List<Retrait> retraits = q.getResultList();
		if (retraits.size() == 0) {
			return null;
		} else {
			return retraits;
		}
	}

	@Override
	public Retrait selectRetraitById(int noArticle) {
		Session session = ConnectionProvider.session;
		Retrait retrait = (Retrait) session.get(Retrait.class, noArticle);
		return retrait;

	}

}
