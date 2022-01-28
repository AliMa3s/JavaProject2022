///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import db.Orderlijnen;
//import domain.EStatus;
//import static org.testng.Assert.*;
//import org.testng.annotations.Test;
//
///**
// *
// * @author alima
// */
//public class OrderlijnenDAONGTest {
//
//    public OrderlijnenDAONGTest() {
//    }
//
//    @Test
//    public void GetOrdersById() {
//        OrderlijnenDAO getid = new OrderlijnenDAO();
//        Orderlijnen orderId = getid.GetOrdersById(1);
//        assertNotNull(orderId, "Orderbestaat");
//        orderId = getid.GetOrdersById(5);
//        assertNull(orderId);
//    }
//    //VoegToeTest
//
//    @Test
//    public void Orderlijnen() {
//        OrderlijnenDAO orderdb = new OrderlijnenDAO();
//        orderdb.VoegOrderlijnen(3, 2, 7, 7, EStatus.nietgeleverd); //Done
//    }
//
//    //VerwijderTest
//    @Test
//    public void VerwijderOrder() {
//        OrderlijnenDAO orderdb = new OrderlijnenDAO();
//        orderdb.VerwijderOrderlijnen(4); //Done
//    }
//    //UpdateTest
//
//    @Test
//    public void UpdateOrder() {
//        OrderlijnenDAO orderdb = new OrderlijnenDAO();
//        orderdb.UpdateOrderlijnen(5, 4, 4, 7, 7, EStatus.geleverd);//Done
//    }
//}
