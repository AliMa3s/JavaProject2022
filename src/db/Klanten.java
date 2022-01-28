/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jalma
 */
@Entity
@Table(name = "klanten")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klanten.findAll", query = "SELECT k FROM Klanten k"),
    @NamedQuery(name = "Klanten.findById", query = "SELECT k FROM Klanten k WHERE k.id = :id"),
    @NamedQuery(name = "Klanten.findByNaam", query = "SELECT k FROM Klanten k WHERE k.naam = :naam"),
    @NamedQuery(name = "Klanten.findByNaamLike", query = "SELECT a FROM Klanten a WHERE a.naam LIKE CONCAT('%', :naam, '%')"),
    @NamedQuery(name = "Klanten.findByGsm", query = "SELECT k FROM Klanten k WHERE k.gsm = :gsm"),
    @NamedQuery(name = "Klanten.findByEmail", query = "SELECT k FROM Klanten k WHERE k.email = :email"),
    @NamedQuery(name = "Klanten.findByGsmLike", query = "SELECT a FROM Klanten a WHERE a.gsm LIKE CONCAT('%', :gsm, '%')"),
    @NamedQuery(name = "Klanten.findByEmailLike", query = "SELECT a FROM Klanten a WHERE a.email LIKE CONCAT('%', :email, '%')")})
public class Klanten implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "naam")
    private String naam;
    @Column(name = "GSM")
    private String gsm;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klanten")
    private List<Adressen> adressen;

    public Klanten() {
    }

    public Klanten(Integer id) {
        this.id = id;
    }

    public Klanten(Integer id, String naam) {
        this.id = id;
        this.naam = naam;
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

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Adressen> getAdressen() {
        if (adressen == null) {
            adressen = new ArrayList<>();
        }
        return adressen;
    }

    public void setAdressen(List<Adressen> adressen) {
        this.adressen = adressen;
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
        if (!(object instanceof Klanten)) {
            return false;
        }
        Klanten other = (Klanten) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naam + ", " + gsm + ", " + email + ".";
    }

}
