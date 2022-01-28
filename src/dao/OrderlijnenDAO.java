/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Artikelen;
import db.Orderlijnen;
import db.Orders;
import domain.EStatus;
import gui.LoginFrame;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author alima
 */
public class OrderlijnenDAO {

    private static EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("ProgrammeerProjectPU");
    private static final Logger LOG = Logger.getLogger(LoginFrame.class);

    public Orderlijnen GetOrdersById(int id) {
        LOG.info("GetOrdersByID");
        EntityManager em = factory.createEntityManager();
        try {
            Orderlijnen zoekId = em.find(Orderlijnen.class, id);
            LOG.info("Order id gevonden : " + zoekId);
            if (zoekId != null) {
                LOG.info(zoekId + " Orderbestaat");

            } else {
                LOG.info("order bestaat niet");
            }
            return zoekId;
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

    public Orderlijnen VoegOrderlijnen(Artikelen artikelid, int aantal, double prijs, Orders orderid, EStatus status) {
        LOG.info("Orderlijnen toevoegen!");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Orderlijnen order = new Orderlijnen();
            Orders ordId = em.find(Orders.class, orderid.getId());
            Artikelen artikel = em.find(Artikelen.class, artikelid.getId());
            order.setArtikel(artikel);
            order.setAantal(aantal);
            order.setPrijs(prijs);
            order.setOrders(ordId);
            order.setStatus(status);

            em.persist(order);
            tr.commit();

            LOG.info("Orderlijn opgeslaan : " + order.getId());

            return order;
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }
// isGeleverd 1
    public Orderlijnen VoegOrderlijnenArtikel(Artikelen artikel, EStatus status) {
        LOG.info("Orderlijnen toevoegen!");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            
            Orders ord = new Orders();         
            Orders ordId = em.find(Orders.class, ord.getId());
            
            Orderlijnen orderlijn = new Orderlijnen();
            Artikelen artikelId = em.find(Artikelen.class, artikel.getId());
            orderlijn.setArtikel(artikelId);
            orderlijn.setOrders(ordId);
            orderlijn.setStatus(status);
            ord.getOrderlijnenList().add(orderlijn);

            em.persist(orderlijn);
            tr.commit();

            LOG.info("Orderlijn opgeslaan : " + artikel.getId());

            return orderlijn;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
//    public Orderlijnen VoegOrderlijnen(int artikelid, int aantal, double prijs, Orders orderid, EStatus status) {
//        System.out.println("Orderlijnen toevoegen!");
//        EntityManager em = factory.createEntityManager();
//        EntityTransaction tr = em.getTransaction();
//        try {
//            tr.begin();
//            Orderlijnen order = new Orderlijnen();
//            Orders ordId = em.find(Orders.class, orderid);
////            order.getArtikel(artikelid);
//            order.setAantal(aantal);
//            order.setPrijs(prijs);
//            order.setOrders(ordId);
//            order.setStatus(status);
//
//            em.persist(order);
//            tr.commit();
//
//            System.out.println("Orderlijn opgeslaan : " + order.getId());
//
//            return order;
//        } catch (Exception ex) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }

    public void VerwijderOrderlijnen(int id) {
        LOG.info("Orderlijnen Verwijderen!");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            Orderlijnen order = em.find(Orderlijnen.class, id);
            if (order != null) {
                em.remove(order);
                tr.commit();
            } else {
                LOG.info("order bestaat niet!");
            }
            LOG.info("Order verwijderd met id : " + id);

        } catch (Exception ex) {
            LOG.info("Iets mis gegaan");
        } finally {
            em.close();
        }
    }

    public void UpdateOrderlijnen(int id, int artikelid, int aantal, double prijs, int orderid, EStatus status) {
        LOG.info("Orderlijnen Updaten!");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Orderlijnen orderDB = em.find(Orderlijnen.class, id);
            Orders ordId = em.find(Orders.class, orderid);

//            orderDB.setArtikelid(artikelid);
            orderDB.setAantal(aantal);
            orderDB.setPrijs(prijs);
            orderDB.setOrders(ordId);
            orderDB.setStatus(status);

            em.merge(orderDB);
            tr.commit();

            LOG.info("Orderlijnen Update : " + orderDB.getId());

        } catch (Exception ex) {
            LOG.info("Iets misgegaan! ");
        } finally {
            em.close();
        }
    }


}
