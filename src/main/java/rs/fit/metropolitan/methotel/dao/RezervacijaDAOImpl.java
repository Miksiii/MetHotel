/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.dao;

import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import rs.fit.metropolitan.methotel.entities.Rezervacije;

/**
 *
 * @author Milan
 */
public class RezervacijaDAOImpl implements IRezervacijaDAO {

    @Inject
    private Session session;
    
    @Override
    public void addRezervacija(Rezervacije rezervacija) {
        session.persist(rezervacija);
    }

    @Override
    public List<Rezervacije> getListaRezervacija() {
        return session.createCriteria(Rezervacije.class).list();
    }

    @Override
    public void deleteRezervacija(Integer id) {
        Rezervacije rez = (Rezervacije) session.createCriteria(Rezervacije.class).add(Restrictions.eq("rezervacijaId", id)).uniqueResult();
        session.delete(rez);    
    }
}
