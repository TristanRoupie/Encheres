package fr.eni.encheres.dal.utilisateur;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.RollbackException;

import org.hibernate.Session;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.exception.BusinessException;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	@Override
	/***
	 * @see UtilisateurDAO
	 */
	public void addUtilisateur(Utilisateur utilisateur) throws BusinessException {
		// test si l'utilisateur est null
		if (utilisateur == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErrors(CodesResultatDAL.INSERT_USER_NULL);
			throw businessException;
		}
		// essai d'obtention de connexion
		try (Session session = ConnectionProvider.getConnection()) {
			// essai d'enregistrement de l'utilisateur dans la basse de donnée
			try {
				session.beginTransaction();
				session.save(utilisateur);
				session.getTransaction().commit();
				// si defaut creation d'une businessException
				// où je rajoute les code erreur pour les afficher
			} catch (IllegalStateException | RollbackException e) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErrors(CodesResultatDAL.FAULT_ADD_USER);
				throw businessException;
			}
		} catch (SQLException e) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErrors(CodesResultatDAL.FAULT_GET_CONNECTION);
			throw businessException;
		}
	}

	@Override
	/***
	 * @see UtilisateurDAO
	 */
	public void updateUtilisateur(Utilisateur utilisateur) throws BusinessException {
		// test si l'utilisateur est null
		if (utilisateur == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErrors(CodesResultatDAL.UPDATE_USER_NULL);
			throw businessException;
		}
		// essai d'obtention de connexion
		try (Session session = ConnectionProvider.getConnection()) {
			// essai de modification de l'utilisateur dans la basse de donnée
			try {
				session.beginTransaction();
				session.saveOrUpdate(utilisateur);
				session.getTransaction().commit();
				// si defaut creation d'une businessException
				// où je rajoute les code erreur pour les afficher
			} catch (IllegalStateException | RollbackException e) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErrors(CodesResultatDAL.FAULT_UPDATE_USER);
				throw businessException;
			}
		} catch (SQLException e) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErrors(CodesResultatDAL.FAULT_GET_CONNECTION);
			throw businessException;
		}
	}

	///////////////////////////////////////////////////// propre

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) throws BusinessException {
		try (Session session = ConnectionProvider.getConnection()) {
			session.beginTransaction();
			session.delete(utilisateur);
			session.getTransaction().commit();
		} catch (SQLException e) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErrors(CodesResultatDAL.FAULT_GET_CONNECTION);
			throw businessException;
		}
	}

	@Override
	public Utilisateur selectUtilisateurByid(int noUtilisateur) throws BusinessException {
		try (Session session = ConnectionProvider.getConnection()) {
			Utilisateur utilisateur = (Utilisateur) session.get(Utilisateur.class, noUtilisateur);
			return utilisateur;
		} catch (SQLException e) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErrors(CodesResultatDAL.FAULT_GET_CONNECTION);
			throw businessException;
		}
	}

	@Override
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws BusinessException {
		try (Session session = ConnectionProvider.getConnection()) {
			Query q = session.createQuery("FROM Utilisateur u WHERE u.pseudo = :pseudo");
			q.setParameter("pseudo", pseudo);
			List<Utilisateur> utilisateurs = q.getResultList();
			if (utilisateurs.size() == 0) {
				session.close();
				return null;
			} else {
				Utilisateur utilisateur = (Utilisateur) q.getSingleResult();
				session.close();
				return utilisateur;
			}
		} catch (SQLException e) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErrors(CodesResultatDAL.FAULT_GET_CONNECTION);
			throw businessException;
		}
	}

	@Override
	public Utilisateur selectUtilisateurByEmail(String email) throws BusinessException {
		try (Session session = ConnectionProvider.getConnection()) {
			Query q = session.createQuery("FROM Utilisateur u WHERE u.email = :email");
			q.setParameter("email", email);
			List<Utilisateur> utilisateurs = q.getResultList();
			if (utilisateurs.size() == 0) {
				session.close();
				return null;
			} else {
				Utilisateur utilisateur = (Utilisateur) q.getSingleResult();
				session.close();
				return utilisateur;
			}
		} catch (SQLException e) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErrors(CodesResultatDAL.FAULT_GET_CONNECTION);
			throw businessException;
		}
	}

}
