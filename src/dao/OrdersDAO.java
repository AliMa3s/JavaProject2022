/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Artikelen;
import db.Orderlijnen;
import db.Orders;
import gui.LoginFrame;
import java.rmi.server.UID;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 *
 * @author alima
 */
public class OrdersDAO {

    private static EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("ProgrammeerProjectPU");
    private static final Logger LOG = Logger.getLogger(LoginFrame.class);

    public Orders GetOrderById(int id) {
        LOG.info("GetOrdersByID");
        EntityManager em = factory.createEntityManager();
        try {
            Orders zoekId = em.find(Orders.class, id);
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

    public Orders VoegOrder(Orders eenOrder) {
        LOG.info("Orders toevoegen!");

        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            Integer max = em.createNamedQuery("Orders.findMaxOrdernum", Integer.class).getSingleResult();
            if (max == null) {
                max = 1;
            } else {
                max++;
            }
            eenOrder.setOrdernummer(max);

            for (Orderlijnen ol : eenOrder.getOrderlijnenList()) {

                Artikelen at = em.find(Artikelen.class, ol.getArtikel().getId());
                at.setWinkelstock(at.getWinkelstock() - ol.getAantal());

                em.persist(at);

            }

            em.persist(eenOrder);
            tr.commit();
            LOG.info("Order id gevonden : " + eenOrder);

            return eenOrder;
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

    public void VerwijderOrder(int id) {
        LOG.info("Orders Verwijderen!");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            Orders order = em.find(Orders.class, id);

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

    public void UpdateOrder(int id, int ordernummer, int klantid, Date datum) {
        LOG.info("Orders Updaten!");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
//            OrdersDAO dao = new OrdersDAO();
            Orders orderDB = em.find(Orders.class, id);
            // orderDB.setKlantid(klantid);
            orderDB.setOrdernummer(ordernummer);
            orderDB.setDatum(datum);

            em.merge(orderDB);
            tr.commit();

            LOG.info("Order Update : " + orderDB);

        } catch (Exception ex) {
            LOG.info("Iets misgegaan! ");
        } finally {
            em.close();
        }
    }
    String name, password;

    //For Test purposes
    public static void main(String[] args) {
        OrdersDAO orderdb = new OrdersDAO();
        Date datum = new Date();
//        orderdb.VoegOrder(123, 3, datum); //Done

//        orderdb.VerwijderOrder(4); //Done
//        orderdb.UpdateOrder(6,678,5,datum);//Done
    }
}
