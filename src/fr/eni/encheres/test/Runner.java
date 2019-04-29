package fr.eni.encheres.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import fr.eni.encheres.bo.Utilisateur;



class Runner {

    @Test
    void test() {
        // Ajout
        Utilisateur newUtilisateur = new Utilisateur());
        
       
         // Suppression
//         Long id = 1L;
//         Voiture voitureAsupprimee = (Voiture) session.get(Voiture.class, id);
//         session.beginTransaction();
//         session.delete(voitureAsupprimee);
//         session.getTransaction().commit();
//
//         // Ajout
//         Voiture voitureAajoutee02 = new Voiture("Peugeot", 7);
//         session.beginTransaction();
//         session.save(voitureAajoutee02);
//         session.getTransaction().commit();
//
//         // Modification
//         Long id2 = 2L;
//         Voiture voitureAmodifiee = (Voiture) session.get(Voiture.class, id2);
//         voitureAmodifiee.setNbChevaux(25);
//         session.beginTransaction();
//         session.saveOrUpdate(voitureAmodifiee);
//         session.getTransaction().commit();
//
//         // Selection
//         Query q = session.createQuery("from Voiture");
//         List<Voiture> voitures = q.getResultList();
//         for (Voiture v : voitures) {
//         System.out.println(v.getModele());
//         }
    }
}
