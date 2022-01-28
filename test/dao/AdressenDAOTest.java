///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import db.Adressen;
//import static org.testng.Assert.assertNotNull;
//import static org.testng.Assert.assertNull;
//import org.testng.annotations.Test;
//
///**
// *
// * @author jalma
// */
//public class AdressenDAOTest {
//    
//    //GetklantbyidTest
//    @Test
//    public void GetAdresById() {
//        AdressenDAO getid = new AdressenDAO();
//        Adressen adres = getid.GetAdresById(1);
//        assertNotNull(adres, "adres bestaat");
//        System.out.println("gevonden adres: "+adres );
//        adres = getid.GetAdresById(5);
//        assertNull(adres);
//    }
//
//    //VoegToeTest
//    @Test
//    public void VoegAdresToe() {
//        AdressenDAO adresdb = new AdressenDAO();
//        adresdb.VoegAdresToe("Teststraat 123","Testdorp","woonhuis",3);
//    }
//
//    //VerwijderTest
//    @Test
//    public void VerwijderAdres() {
//        AdressenDAO adresdb = new AdressenDAO();
//        adresdb.VerwijderAdres(5);
//    }
//    
//}
