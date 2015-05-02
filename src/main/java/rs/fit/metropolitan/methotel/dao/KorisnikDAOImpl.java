/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.dao;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import rs.fit.metropolitan.methotel.entities.Korisnik;

/**
 *
 * @author Milan
 */
public class KorisnikDAOImpl implements IKorisnikDAO {
    @Inject
    Session session;

    @Override
    public Korisnik checkKorisnik(String email, String password) {
        try {
            Korisnik k = (Korisnik) session.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikEmail", email)).add(Restrictions.eq("korisnikPassword", password)).uniqueResult();
            if(k != null) {
                return k;
            }
            return null;
        } catch(NullPointerException npe) {
            return null;
        }
    }

    @Override
    public Korisnik registerKorisnik(Korisnik kori) {
        return (Korisnik) session.merge(kori);
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        Long rows = (Long) session.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikEmail", email)).setProjection(Projections.rowCount()).uniqueResult();
        return (rows == 0) ? false : true;
    }
    
    
}
