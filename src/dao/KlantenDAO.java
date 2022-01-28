/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Adressen;
import db.Klanten;
import domain.PDFKlantenKaart;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author jalma
 */
public class KlantenDAO {

    private static EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("ProgrammeerProjectPU");
    private static final Logger LOG = Logger.getLogger(KlantenDAO.class);

    public Klanten GetKlantById(int id) {
        LOG.trace("GetKlantByID");
        EntityManager em = factory.createEntityManager();
        try {
            Klanten zoekId = em.find(Klanten.class, id);
            if (zoekId != null) {
                LOG.info("Klant" + zoekId.getNaam() + " gevonden");
            } else {
                LOG.info("klant bestaat niet");
            }
            return zoekId;
        } catch (Exception ex) {
            LOG.error("GetKlantById mislukt");
            return null;
        } finally {
            em.close();
        }
    }

    public Klanten VoegKlantToe(Klanten eenKlant, Adressen eenAdres) {
        LOG.info("voegKlantToe naam: " + eenKlant.getNaam());
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        Klanten klantId = zoekKlant(eenKlant.getNaam());
        System.out.println(klantId);
        try {
            tr.begin();
            if (klantId == null) {
                em.persist(eenKlant);
                em.persist(eenAdres);
                LOG.info("Klant " + eenKlant.getNaam() + " is aangemaakt");
            } else {
                em.merge(eenKlant);
                em.merge(eenAdres);
                LOG.info("Klant " + eenKlant.getNaam() + " is bijgewerkt");
            }
            tr.commit();
            LOG.info("Klant gemaakt: " + eenKlant + " met adres: " + eenKlant.getAdressen());
            PDFKlantenKaart k = new PDFKlantenKaart();
            k.klantenKaart(eenKlant, eenAdres);

            return eenKlant;
        } catch (Exception ex) {
            LOG.error("VoegKlantToe mislukt");
            return null;
        } finally {
            em.close();
        }
    }

    public void VerwijderKlant(int id) {
        LOG.trace("verwijderKlant");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            Klanten klant = em.find(Klanten.class, id);
            System.out.println(klant);
            if (klant != null) {
                em.remove(klant);
                tr.commit();
            } else {
                LOG.info("klant bestaat niet!");
            }
            LOG.info("klant verwijderd met id : " + id);

        } catch (Exception ex) {
            LOG.error("VerwijderKlant mislukt");
        } finally {
            em.close();
        }
    }

    public Klanten zoekKlant(String naam) {
        EntityManager em = factory.createEntityManager();
        LOG.trace("zoekKlant");

        try {
            Query query = em.createNamedQuery("Klanten.findByNaam");

            query.setParameter("naam", naam);
            Klanten gevondenklant = (Klanten) query.getSingleResult();
            LOG.info("klant gevonden");
            return gevondenklant;

        } catch (Exception ex) {
            LOG.error("klant niet gevonden");
            return null;
        } finally {
            em.close();
        }
    }

    public List<Klanten> zoekKlanten(String naam) {
        LOG.trace("zoekKlanten");
        EntityManager em = factory.createEntityManager();
        try {
            Query zoekklant = em.createNamedQuery("Klanten.findByNaamLike");
            zoekklant.setParameter("naam", naam);
            List<Klanten> klantLijst = zoekklant.getResultList();
            LOG.info("zoekKlanten gelukt " + klantLijst);
            return klantLijst;
        } catch (Exception ex) {
            LOG.error("zoekKlanten mislukt", ex);
            return null;
        } finally {
            em.close();
        }
    }

    public List<Klanten> zoekKlantenOpGsm(String gsm) {
        EntityManager em = factory.createEntityManager();
        LOG.trace("zoekKlantOpGsm");
        try {
            Query zoekklant = em.createNamedQuery("Klanten.findByGsmLike");
            zoekklant.setParameter("gsm", gsm);
            List<Klanten> klantLijst = zoekklant.getResultList();
            LOG.info("zoekKlantOpGsm gelukt");
            return klantLijst;
        } catch (Exception ex) {
            LOG.error("zoekKlantOpGsm mislukt");
            return null;
        } finally {
            em.close();
        }
    }

    public List<Klanten> zoekKlantenOpEmail(String email) {
        LOG.trace("zoekKlantOpEmail");
        EntityManager em = factory.createEntityManager();
        try {
            Query zoekklant = em.createNamedQuery("Klanten.findByEmailLike");
            zoekklant.setParameter("email", email);
            List<Klanten> klantLijst = zoekklant.getResultList();
            LOG.info("zoekKlantOpEmail gelukt");
            return klantLijst;
        } catch (Exception ex) {
            LOG.error("zoekKlantOpEmail mislukt");

            return null;
        } finally {
            em.close();
        }
    }

    public List<Klanten> alleKlanten() {
        EntityManager em = factory.createEntityManager();
        List<Klanten> klant;
        LOG.trace("alleKlanten");
        try {
            em = factory.createEntityManager();
            Query zoekactie = em.createNamedQuery("Klanten.findAll");
            klant = zoekactie.getResultList();
            return klant;
        } catch (Exception e) {
            LOG.error("alleKlanten mislukt");
            return null;

        } finally {
            em.close();
        }

    }

}
