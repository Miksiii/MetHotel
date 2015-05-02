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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;
import rs.fit.metropolitan.methotel.data.Role;

/**
 *
 * @author Milan
 */
@Entity
@Table(name = "korisnik")
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")})
public class Korisnik implements Serializable {
    @Lob
    @Enumerated(EnumType.STRING)
    @Column(name = "KORISNIK_ROLA")
    private Role korisnikRola;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KORISNIK_ID")
    private Integer korisnikId;
    @Column(name = "KORISNIK_IME")
    private String korisnikIme;
    @Column(name = "KORISNIK_EMAIL")
    private String korisnikEmail;
    @Column(name = "KORISNIK_PASSWORD")
    private String korisnikPassword;

    @Inject
    public Korisnik() {
    }

    public Korisnik(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getKorisnikIme() {
        return korisnikIme;
    }

    public void setKorisnikIme(String korisnikIme) {
        this.korisnikIme = korisnikIme;
    }

    public String getKorisnikEmail() {
        return korisnikEmail;
    }

    public void setKorisnikEmail(String korisnikEmail) {
        this.korisnikEmail = korisnikEmail;
    }

    public String getKorisnikPassword() {
        return korisnikPassword;
    }

    public void setKorisnikPassword(String korisnikPassword) {
        this.korisnikPassword = korisnikPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korisnikId != null ? korisnikId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korisnikId == null && other.korisnikId != null) || (this.korisnikId != null && !this.korisnikId.equals(other.korisnikId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fit.metropolitan.methotel.entities.Korisnik[ korisnikId=" + korisnikId + " ]";
    }

    public Role getKorisnikRola() {
        return korisnikRola;
    }

    public void setKorisnikRola(Role korisnikRola) {
        this.korisnikRola = korisnikRola;
    }
    
}
