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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jalma
 */
@Entity
@Table(name = "adressen", catalog = "winkeldb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adressen.findAll", query = "SELECT a FROM Adressen a"),
    @NamedQuery(name = "Adressen.findById", query = "SELECT a FROM Adressen a WHERE a.id = :id"),
    @NamedQuery(name = "Adressen.findByStraat", query = "SELECT a FROM Adressen a WHERE a.straat = :straat"),
    @NamedQuery(name = "Adressen.findByStad", query = "SELECT a FROM Adressen a WHERE a.stad = :stad"),
    @NamedQuery(name = "Adressen.findByType", query = "SELECT a FROM Adressen a WHERE a.type = :type"), 
    @NamedQuery(name = "Adressen.findByKlanten", query = "SELECT a FROM Adressen a WHERE a.klanten = :klanten"),   
})

public class Adressen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "straat")
    private String straat;
    @Basic(optional = false)
    @Column(name = "stad")
    private String stad;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "klanten_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Klanten klanten;

    public Adressen() {
    }

    public Adressen(Integer id) {
        this.id = id;
    }

    public Adressen(Integer id, String straat, String stad, String type) {
        this.id = id;
        this.straat = straat;
        this.stad = stad;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Klanten getKlanten() {
        return klanten;
    }

    public void setKlanten(Klanten klanten) {
        this.klanten = klanten;
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
        if (!(object instanceof Adressen)) {
            return false;
        }
        Adressen other = (Adressen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return straat + ", " + stad + ", type: " + type + ".";
    }



}
