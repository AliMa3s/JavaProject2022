/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alima
 */
@Entity
@Table(name = "accounts")
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findById", query = "SELECT a FROM Accounts a WHERE a.id = :id"),
    @NamedQuery(name = "Accounts.findByUsernameAndWachtwoord", query = "SELECT a FROM Accounts a WHERE a.username = :username AND a.wachtwoord = :wachtwoord"),
    @NamedQuery(name = "Accounts.findByWachtwoord", query = "SELECT a FROM Accounts a WHERE a.wachtwoord = :wachtwoord")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "wachtwoord")
    private String wachtwoord;
    @JoinColumn(name = "werknemerid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Werknemers werknemers;

    public Accounts() {
    }

    public Accounts(Integer id) {
        this.id = id;
    }

    public Accounts(Integer id, String username, String wachtwoord) {
        this.id = id;
        this.username = username;
        this.wachtwoord = wachtwoord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Werknemers getWerknemers() {
        return werknemers;
    }

    public void setWerknemers(Werknemers werknemers) {
        this.werknemers = werknemers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de gebruiker is (" + id + ") met username (" + username + ") met wachtwoord (" + wachtwoord + ").";
    }
    
}
