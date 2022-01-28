/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import dao.WerknemersDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author alima
 */
public class AccountsNGTest {
    
    public AccountsNGTest() {
        
    }

        @Test
        public void LoginMetFunctieTest(){
            WerknemersDAO test = new WerknemersDAO();
            Accounts user = test.LoginMetFunctieTest("rose", "rose");
            assertNotNull(user);
            user = test.LoginMetFunctieTest("sdf", "sdf");
            assertNull(user);
    }
    
}
