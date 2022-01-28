/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Artikelen;
import db.Klanten;
import db.Orderlijnen;
import db.Orders;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import org.testng.annotations.Test;

/**
 *
 * @author alima
 */
public class OrdersDAOTest {

    //GetorderbyidTest
    @Test
    public void GetOrderById() {
        OrdersDAO getid = new OrdersDAO();
        Orders orderId = getid.GetOrderById(1);
        assertNotNull(orderId, "Orderbestaat");
        orderId = getid.GetOrderById(5);
        assertNull(orderId);
    }

    //VoegToeTest
    @Test
    public void VoegOrder() {
        Klanten klant = new KlantenDAO().GetKlantById(1);
        Orders order = new Orders();
        order.setOrdernummer(1238886);
        order.setDatum(new Date());
        order.setKlant(klant);
        List<Orderlijnen> lijnen = new ArrayList<>();
        Artikelen artikel = new ArtikelenDAO().ArtikelOpzoeken(1);
        Orderlijnen eenLijn = new Orderlijnen();
        eenLijn.setAantal(10);
        eenLijn.setArtikel(artikel);

        order.setOrderlijnenList(lijnen);
        OrdersDAO orderdb = new OrdersDAO();
        orderdb.VoegOrder(order);
    }

    //VerwijderTest
    @Test
    public void VerwijderOrder() {
        OrdersDAO orderdb = new OrdersDAO();
        orderdb.VerwijderOrder(5);
    }
    //UpdateTest

    @Test
    public void UpdateOrder() {
        OrdersDAO orderdb = new OrdersDAO();
        Date datum = new Date();
        orderdb.UpdateOrder(6, 678, 5, datum);//Done
    }
}
