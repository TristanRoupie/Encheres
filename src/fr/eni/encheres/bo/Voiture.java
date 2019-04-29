package fr.eni.encheres.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Voiture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String modele;
    private int nbChevaux;

    public Voiture(String modele, int nbChevaux) {
        super();
        this.modele = modele;
        this.nbChevaux = nbChevaux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getNbChevaux() {
        return nbChevaux;
    }

    public void setNbChevaux(int nbChevaux) {
        this.nbChevaux = nbChevaux;
    }

    @Override
    public String toString() {
        return "Voiture [modele=" + modele + ", nbChevaux=" + nbChevaux + "]";
    }

}