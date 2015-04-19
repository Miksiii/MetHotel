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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Milan
 */
@Entity
@Table(name = "soba")
@NamedQueries({
    @NamedQuery(name = "Soba.findAll", query = "SELECT s FROM Soba s")})
public class Soba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "soba_id")
    private Integer sobaId;
    @Basic(optional = false)
    @Validate("required, minLength=5, maxLength=20")
    @Column(name = "soba_ime")
    private String sobaIme;
    @Basic(optional = false)
    @Validate("required")
    @Column(name = "soba_sprat")
    private int sobaSprat;
    @Basic(optional = false)
    @Validate("none")
    @Column(name = "soba_tv")
    private boolean sobaTv;
    @Basic(optional = false)
    @Validate("none")
    @Column(name = "soba_internet")
    private boolean sobaInternet;
    @Basic(optional = false)
    @Validate("none")
    @Column(name = "soba_djakuzi")
    private boolean sobaDjakuzi;

    @Inject
    public Soba() {
    }

    public Soba(Integer sobaId) {
        this.sobaId = sobaId;
    }

    public Soba(Integer sobaId, String sobaIme, int sobaSprat, boolean sobaTv, boolean sobaInternet, boolean sobaDjakuzi) {
        this.sobaId = sobaId;
        this.sobaIme = sobaIme;
        this.sobaSprat = sobaSprat;
        this.sobaTv = sobaTv;
        this.sobaInternet = sobaInternet;
        this.sobaDjakuzi = sobaDjakuzi;
    }

    public Integer getSobaId() {
        return sobaId;
    }

    public void setSobaId(Integer sobaId) {
        this.sobaId = sobaId;
    }

    public String getSobaIme() {
        return sobaIme;
    }

    public void setSobaIme(String sobaIme) {
        this.sobaIme = sobaIme;
    }

    public int getSobaSprat() {
        return sobaSprat;
    }

    public void setSobaSprat(int sobaSprat) {
        this.sobaSprat = sobaSprat;
    }

    public boolean getSobaTv() {
        return sobaTv;
    }

    public void setSobaTv(boolean sobaTv) {
        this.sobaTv = sobaTv;
    }

    public boolean getSobaInternet() {
        return sobaInternet;
    }

    public void setSobaInternet(boolean sobaInternet) {
        this.sobaInternet = sobaInternet;
    }

    public boolean getSobaDjakuzi() {
        return sobaDjakuzi;
    }

    public void setSobaDjakuzi(boolean sobaDjakuzi) {
        this.sobaDjakuzi = sobaDjakuzi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sobaId != null ? sobaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soba)) {
            return false;
        }
        Soba other = (Soba) object;
        if ((this.sobaId == null && other.sobaId != null) || (this.sobaId != null && !this.sobaId.equals(other.sobaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fit.metropolitan.metmodel.entities.Soba[ sobaId=" + sobaId + " ]";
    }
    
}
