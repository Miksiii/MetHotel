/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.ioc.annotations.Inject;
import rs.fit.metropolitan.methotel.dao.IKorisnikDAO;
import rs.fit.metropolitan.methotel.entities.Korisnik;

/**
 *
 * @author Milan
 */
public class KorisnikLogin {
    @Property
    private Korisnik korisnik;
    @SessionState
    private Korisnik ulogovanKorisnik;
    @Inject
    private IKorisnikDAO korisnikDAO;
    @Component
    private BeanEditForm form;
    
    Object onActivate() {
        if(ulogovanKorisnik.getKorisnikEmail() != null) {
            return Index.class;
        }
        return null;
    }
    
    public String getMD5Hash(String yourString) {
        try{
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(yourString.getBytes());
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch(Exception e) {
            return "";
        }
    }
    
    Object onSuccess() {
        String password = getMD5Hash(korisnik.getKorisnikPassword());
        System.out.println("~Password" + password);
        Korisnik newKorisnik = korisnikDAO.checkKorisnik(korisnik.getKorisnikEmail(), password);
        if(newKorisnik != null) {
            ulogovanKorisnik = newKorisnik;
            System.out.println("~Ulogovan!");
            return Index.class;
        } else {
            form.recordError("Uneli ste pogresne parametre!");
            System.out.println("~Wrong params");
            return null;
        }
    }
}
