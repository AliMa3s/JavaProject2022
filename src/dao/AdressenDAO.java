/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Adressen;
import db.Klanten;
import java.util.ArrayList;
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
public class AdressenDAO {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProgrammeerProjectPU");
    private static final Logger LOG = Logger.getLogger(KlantenDAO.class);

    public Adressen GetAdresById(int id) {
        LOG.trace("Get Adres By ID.");
        EntityManager em = factory.createEntityManager();
        try {
            Adressen zoekId = em.find(Adressen.class, id);
            LOG.info("Adres id gevonden : " + zoekId);
            if (zoekId != null) {
                LOG.info(zoekId + " adres bestaat");
            } else {
                LOG.info("adres bestaat niet");
            }
            return zoekId;
        } catch (Exception ex) {
            LOG.error("GetKlantByAdres mislukt");
            return null;
        } finally {
            em.close();
        }
    }

//   
    public void VerwijderAdres(int id) {
        LOG.trace("Adres Verwijderen!");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            Adressen adres = em.find(Adressen.class, id);
            System.out.println(adres);
            if (adres != null) {
                em.remove(adres);
                tr.commit();
                LOG.info("adres verwijderd met id : " + id);
            } else {
                LOG.info("adres bestaat niet!");
            }
        } catch (Exception ex) {
            LOG.error("Iets mis gegaan bij verwijderen adres");
        } finally {
            em.close();
        }
    }

    public ArrayList<Adressen> alleAdressen(int klanten) {
        LOG.trace("alleAdressen");
        ArrayList<Adressen> aa = new ArrayList<>();
        EntityManager em = factory.createEntityManager();
        Query zoekactie = em.createNamedQuery("Adressen.findAll");
        List<Adressen> adres = zoekactie.getResultList();
        String[] adresData = new String[adres.size()];
        for (int i = 0; i < adres.size(); i++) {
            adresData[i] = adres.get(i).toString();
            aa.add(adres.get(i));
        }
        em.close();
        return aa;
    }

    public List<Adressen> GetKlantById(int id) {
        LOG.trace("GetKlantByID");
        EntityManager em = factory.createEntityManager();
        List<Adressen> aa = new ArrayList<>();
        try {
            Klanten zoekactie = em.find(Klanten.class, id);
            List<Adressen> adres = zoekactie.getAdressen();
            String[] adresData = new String[adres.size()];
            for (int i = 0; i < adres.size(); i++) {
                adresData[i] = adres.get(i).toString();
                aa.add(adres.get(i));
            }
            LOG.info("Klant id gevonden : " + zoekactie);
            if (zoekactie != null) {
                LOG.info(zoekactie + " klant bestaat");
            } else {
                LOG.info("klant bestaat niet");
            }
            return aa;
        } catch (Exception ex) {
            LOG.error("GetKlantById mislukt.");
            return null;
        } finally {
            em.close();
        }
    }

}
