/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rosev
 */
@Entity
@Table(name = "artikelen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artikelen.findAll", query = "SELECT a FROM Artikelen a"),
    @NamedQuery(name = "Artikelen.findById", query = "SELECT a FROM Artikelen a WHERE a.id = :id"),
    @NamedQuery(name = "Artikelen.findByNaam", query = "SELECT a FROM Artikelen a WHERE a.naam = :naam"),
    @NamedQuery(name = "Artikelen.findByCategorie", query = "SELECT a FROM Artikelen a WHERE a.categorie = :categorie"),
    @NamedQuery(name = "Artikelen.findByWinkelstock", query = "SELECT a FROM Artikelen a WHERE a.winkelstock = :winkelstock"),
    @NamedQuery(name = "Artikelen.findByCategorieLike", query = "SELECT a FROM Artikelen a WHERE a.categorie LIKE CONCAT('%', :cat, '%')"),
    @NamedQuery(name = "Artikelen.findByPrijs", query = "SELECT a FROM Artikelen a WHERE a.prijs = :prijs")})
public class Artikelen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "categorie")
    private String categorie;
    @Column(name = "winkelstock")
    private int winkelstock;
    @Column(name = "prijs")
    private Double prijs;

    public Artikelen() {
    }

    public Artikelen(Integer id) {
        this.id = id;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getWinkelstock() {
        return winkelstock;
    }

    public void setWinkelstock(int winkelstock) {
        this.winkelstock = winkelstock;
    }

    public Double getPrijs() {
        return prijs;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
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
        if (!(object instanceof Artikelen)) {
            return false;
        }
        Artikelen other = (Artikelen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id: " + id +" Naam: " + naam +" Cat: " + categorie +" Stock: " + winkelstock  +" Prijs: " + prijs ;
    }


    
}
