/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Artikelen;
import gui.LoginFrame;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Kevin
 */
public class ArtikelenDAO {

    private static EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("ProgrammeerProjectPU");
    private static final Logger LOG = Logger.getLogger(LoginFrame.class);

    public Artikelen VoegArtikelToe(String naam, String categorie, int winkelstock, double prijs) {
        LOG.info("Artikel toegevoegen");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            Artikelen artikel = new Artikelen();
            artikel.setNaam(naam);
            artikel.setCategorie(categorie);
            artikel.setWinkelstock(winkelstock);
            artikel.setPrijs(prijs);

            em.persist(artikel);
            tr.commit();
            LOG.info("creatie gelukt van artikelnummer " + artikel);

            return artikel;
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

    public Artikelen ArtikelOpzoeken(int id, String naam, String categorie) {
        LOG.info("Artikel opzoeken");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            Artikelen artikel = new Artikelen();

            artikel.getId();
            artikel.getNaam();
            artikel.getCategorie();

            em.persist(artikel);

            tr.commit();
            LOG.info("Artikelnummer " + artikel.getId().toString() + " met naam " + artikel.getNaam() + ", uit categorie" + artikel.getCategorie() + ".");

            return artikel;

        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

    public Artikelen ArtikelOpzoeken(int id) {
        LOG.info("Artikel opzoeken");
        EntityManager em = factory.createEntityManager();
        try {

            Query query = em.createNamedQuery("Artikelen.findById");
            query.setParameter("id", id);
            LOG.info("artikel gevonden" + id);
            return (Artikelen) query.getSingleResult();

        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public List<Artikelen> ArtikelOpzoeken(String zoekArt) {
    LOG.info("Artikel opzoeken");
    EntityManager em = factory.createEntityManager();
    try {

        Query query = em.createNamedQuery("Artikelen.findByCategorieLike");
        query.setParameter("cat", zoekArt);

        return (List<Artikelen>) query.getResultList();
    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    } finally {
        em.close();
    }
    }
    

}
