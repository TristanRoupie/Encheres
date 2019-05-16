package fr.eni.encheres.dal.retrait;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.ConnectionProvider;

public class RetraitDAOJdbcImpl implements RetraitDAO {

	@Override
	public void addRetrait(Retrait retrait) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.save(retrait);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void updateRetrait(Retrait retrait) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.saveOrUpdate(retrait);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteRetrait(Retrait retrait) {
		Session session = ConnectionProvider.getConnection();
		session.beginTransaction();
		session.delete(retrait);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Retrait> selectAllRetrait() {
		Session session = ConnectionProvider.getConnection();
		Query q = session.createQuery("from RETRAITS");
		List<Retrait> retraits = q.getResultList();
		session.close();
		if (retraits.size() == 0) {
			return null;
		} else {
			return retraits;
		}
	}

	@Override
	public Retrait selectRetraitByIdArticle(int noArticle) {
		Session session = ConnectionProvider.getConnection();
		Retrait retrait = (Retrait) session.get(Retrait.class, noArticle);
		session.close();
		return retrait;

	}

}
