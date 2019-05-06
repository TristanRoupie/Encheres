package fr.eni.encheres.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Synchronization;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform;

import lombok.Data;
@Entity
@Table(name = "ENCHERES")
@Data
public class Enchere implements Serializable {
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="no_utilisateur")
	private Utilisateur utilisateur;
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "no_article")
	private ArticleVendu article;
	@Column(name = "date_enchere", nullable = false)
	private Date DateEnchere;
	@Column(name = "montant_enchere", length = 11, nullable = false)
	private int montantEnchere;
	

	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur utilisateur, ArticleVendu article) {
		super();
		DateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.article = article; 
	}

	public Enchere() {

	}

}
