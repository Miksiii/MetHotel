/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.entities;

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
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Milan
 */
@Entity
@Table(name = "rezervacije")
@NamedQueries({
    @NamedQuery(name = "Rezervacije.findAll", query = "SELECT r FROM Rezervacije r")})
public class Rezervacije implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REZERVACIJA_ID")
    private Integer rezervacijaId;
    @Column(name = "REZERVACIJA_OD")
    private String rezervacijaOd;
    @Column(name = "REZERVACIJA_DO")
    private String rezervacijaDo;
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID")
    @ManyToOne
    private Hotel hotelId;

    @Inject
    public Rezervacije() {
    }

    public Rezervacije(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public Integer getRezervacijaId() {
        return rezervacijaId;
    }

    public void setRezervacijaId(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public String getRezervacijaOd() {
        return rezervacijaOd;
    }

    public void setRezervacijaOd(String rezervacijaOd) {
        this.rezervacijaOd = rezervacijaOd;
    }

    public String getRezervacijaDo() {
        return rezervacijaDo;
    }

    public void setRezervacijaDo(String rezervacijaDo) {
        this.rezervacijaDo = rezervacijaDo;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rezervacijaId != null ? rezervacijaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervacije)) {
            return false;
        }
        Rezervacije other = (Rezervacije) object;
        if ((this.rezervacijaId == null && other.rezervacijaId != null) || (this.rezervacijaId != null && !this.rezervacijaId.equals(other.rezervacijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fit.metropolitan.methotel.entities.Rezervacije[ rezervacijaId=" + rezervacijaId + " ]";
    }
    
}
