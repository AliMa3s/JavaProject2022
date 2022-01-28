/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Accounts;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author alima
 */
public class WerknemersDAO {
        private static EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory("ProgrammeerProjectPU");
        
        public Accounts LoginMetFunctieTest(String user, String pass){
        System.out.println("LoginMetFunctieTest");
        
        EntityManager em = factory.createEntityManager();

        try{
        Query zoekUser = em.createNamedQuery("Accounts.findByUsernameAndWachtwoord");
        zoekUser.setParameter("username", user);
        zoekUser.setParameter("wachtwoord", pass);
        Accounts dbUser = (Accounts)zoekUser.getSingleResult();
        System.out.println(dbUser);
        
        return dbUser;
        }catch(Exception ex){
            return null;
        }finally{
            em.close();

        }

        
    }
     
        
}
