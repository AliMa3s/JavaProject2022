/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import db.Accounts;

/**
 *
 * @author jalma
 */
public class Login {

    private Accounts ok;
    private Accounts fout;
    
    
    
    public Login() {
        ok = new Accounts();
        ok.setUsername("a");
        ok.setWachtwoord("a");

        fout = new Accounts();
        fout.setUsername("b");
        fout.setWachtwoord("b");
    }
    
    public boolean valideer(String username, String password){
        if (ok.getUsername().equals(username) && ok.getWachtwoord().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    
  

}
