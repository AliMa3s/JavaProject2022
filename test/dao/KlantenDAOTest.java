/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Adressen;
import db.Klanten;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import org.testng.annotations.Test;

/**
 *
 * @author jalma
 */
public class KlantenDAOTest {

    //GetklantbyidTest
    @Test
    public void GetKlantById() {
        KlantenDAO getid = new KlantenDAO();
        Klanten klantId = getid.GetKlantById(1);
        assertNotNull(klantId, "klant bestaat");
        klantId = getid.GetKlantById(5);
        assertNull(klantId);
    }

    //VoegToeTest
    @Test
    public void VoegKlantToe() {
        Klanten klant = new Klanten();
        Adressen adres = new Adressen();
        klant.setNaam("Wilfried");
        klant.setGsm("4654");
        klant.setEmail("wilfried@wilfried.be");
        adres.setKlanten(klant);
        adres.setStraat("Wilfriedstraat 135");
        adres.setStad("Wilfstad");
        adres.setType("factuuradres");
        
        
        KlantenDAO klantdb = new KlantenDAO();
        klantdb.VoegKlantToe(klant, adres);
//        AdressenDAO adresdb = new AdressenDAO();
//        adresdb.VoegAdresToe(adres);
//        
        
    }

    //VerwijderTest
    @Test
    public void VerwijderKlant() {
        KlantenDAO klantdb = new KlantenDAO();
        klantdb.VerwijderKlant(5);
    }
    
    @Test
    public void GetKlantByNaam() {
        KlantenDAO getNaam = new KlantenDAO();
        Klanten klantNaam = getNaam.zoekKlant("Huub");
        assertNotNull(klantNaam, "klant bestaat");
        klantNaam = getNaam.zoekKlant("k");
        assertNull(klantNaam);
    }

}
