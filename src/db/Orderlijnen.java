/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.EStatus;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "orderlijnen")
@NamedQueries({
    @NamedQuery(name = "Orderlijnen.findAll", query = "SELECT o FROM Orderlijnen o"),
    @NamedQuery(name = "Orderlijnen.findById", query = "SELECT o FROM Orderlijnen o WHERE o.id = :id")
})
public class Orderlijnen implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "aantal")
    private int aantal;
    @Basic(optional = false)
    @Column(name = "prijs")
    private double prijs;
    @JoinColumn(name = "artikelid", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Artikelen artikel;
    @JoinColumn(name = "orderid", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Orders orders;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EStatus status;

    public Orderlijnen() {
    }

    public Orderlijnen(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Artikelen getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikelen artikel) {
        this.artikel = artikel;
    }

 
    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }


    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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
        if (!(object instanceof Orderlijnen)) {
            return false;
        }
        Orderlijnen other = (Orderlijnen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Orderlijnen[ id=" + id + " ]";
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }
    
}
