/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alima
 */
@Entity
@Table(name = "orders")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByOrdernummer", query = "SELECT o FROM Orders o WHERE o.ordernummer = :ordernummer"),
    @NamedQuery(name = "Orders.findByKlantid", query = "SELECT o FROM Orders o WHERE o.klant = :klant"),
    @NamedQuery(name = "Orders.findMaxOrdernum", query = "SELECT MAX(o.ordernummer) FROM Orders o"),
    @NamedQuery(name = "Orders.findByDatum", query = "SELECT o FROM Orders o WHERE o.datum = :datum")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ordernummer")
    private int ordernummer;
     @JoinColumn(name = "klantid", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Klanten klant;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private List<Orderlijnen> orderlijnenList;

    public Orders() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrdernummer() {
        return ordernummer;
    }

    public void setOrdernummer(int ordernummer) {
        this.ordernummer = ordernummer;
    }

    public Klanten getKlant() {
        return klant;
    }

    public void setKlant(Klanten klant) {
        this.klant = klant;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public List<Orderlijnen> getOrderlijnenList() {
        if(orderlijnenList == null){
            orderlijnenList = new ArrayList<Orderlijnen>();
        }
        return orderlijnenList;
    }

    public void setOrderlijnenList(List<Orderlijnen> orderlijnenList) {
        this.orderlijnenList = orderlijnenList;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orders{" + "id=" + id + ", ordernummer=" + ordernummer + ", klant=" + klant + ", datum=" + datum + '}';
    }



}
