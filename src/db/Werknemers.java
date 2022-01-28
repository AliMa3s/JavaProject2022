/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.ELoginTypeWerknemer;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alima
 */
@Entity
@Table(name = "werknemers")
@NamedQueries({
    @NamedQuery(name = "Werknemers.findAll", query = "SELECT w FROM Werknemers w"),
    @NamedQuery(name = "Werknemers.findById", query = "SELECT w FROM Werknemers w WHERE w.id = :id"),
    @NamedQuery(name = "Werknemers.findByNaam", query = "SELECT w FROM Werknemers w WHERE w.naam = :naam"),
    @NamedQuery(name = "Werknemers.findByFunctie", query = "SELECT w FROM Werknemers w WHERE w.functie = :functie"),
    @NamedQuery(name = "Werknemers.findByGsm", query = "SELECT w FROM Werknemers w WHERE w.gsm = :gsm"),
    @NamedQuery(name = "Werknemers.findByEmail", query = "SELECT w FROM Werknemers w WHERE w.email = :email")})
public class Werknemers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "naam")
    private String naam;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "functie")
    private ELoginTypeWerknemer functie;
    @Column(name = "gsm")
    private Integer gsm;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "werknemers")
    private List<Accounts> accountsList;

    public Werknemers() {
    }


    public Werknemers(String naam, ELoginTypeWerknemer functie) {
        this.naam = naam;
        this.functie = functie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public ELoginTypeWerknemer getFunctie() {
        return functie;
    }

    public void setFunctie(ELoginTypeWerknemer functie) {
        this.functie = functie;
    }

    public Integer getGsm() {
        return gsm;
    }

    public void setGsm(Integer gsm) {
        this.gsm = gsm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Accounts> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<Accounts> accountsList) {
        this.accountsList = accountsList;
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
        if (!(object instanceof Werknemers)) {
            return false;
        }
        Werknemers other = (Werknemers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Werknemers[ id=" + id + " ]";
    }
    
}
