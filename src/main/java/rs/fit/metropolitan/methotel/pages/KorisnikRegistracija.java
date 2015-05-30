/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.pages;

import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import rs.fit.metropolitan.methotel.dao.IKorisnikDAO;
import rs.fit.metropolitan.methotel.data.Role;
import rs.fit.metropolitan.methotel.entities.Korisnik;
import rs.fit.metropolitan.methotel.services.ProtectedPage;

@ProtectedPage
@RolesAllowed(value={"Korisnik"})
public class KorisnikRegistracija {
    @Property
    private Korisnik korisnik;
    @SessionState
    private Korisnik ulogovanKorisnik;
    @Inject
    private IKorisnikDAO korisnikDAO;
    @Component
    private BeanEditForm form;
    
    public String getMD5Hash(String yourString) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(yourString.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
    
    @CommitAfter
    Object onSuccess() {
        if(!korisnikDAO.checkIfEmailExists(korisnik.getKorisnikEmail())) {
            String unhashedPassword = korisnik.getKorisnikPassword();
            korisnik.setKorisnikPassword(getMD5Hash(unhashedPassword));
            korisnik.setKorisnikRola(Role.Korisnik);
            Korisnik newKorisnik = korisnikDAO.registerKorisnik(korisnik);
            ulogovanKorisnik = newKorisnik;
            return Index.class;
        } else {
            form.recordError("Email exists");
            return null;
        }
    }
}
