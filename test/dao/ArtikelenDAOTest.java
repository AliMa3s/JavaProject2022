/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Artikelen;
import org.testng.annotations.Test;

/**
 *
 * @author Kevin
 */
public class ArtikelenDAOTest {
      

    @Test
    public void VoegArtikelToe() {
        ArtikelenDAO artikeldb = new ArtikelenDAO();
        artikeldb.VoegArtikelToe("Oplader Type-Lightning","Accesoires",4,9.99);
    }

   @Test
   public void ArtikelOpzoeken(){
       
   }
   
    
    
}
