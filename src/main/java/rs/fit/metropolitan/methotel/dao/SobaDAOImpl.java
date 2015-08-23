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
import rs.fit.metropolitan.methotel.entities.Soba;

/**
 *
 * @author Milan
 */
public class SobaDAOImpl implements ISobaDAO {

    @Inject
    private Session session;
    
    @Override
    public List<Soba> getListaSoba() {
        return session.createCriteria(Soba.class).list();
    }

    @Override
    public void addSobu(Soba soba) {
        session.persist(soba);
    }

    @Override
    public Soba getSobaById(Integer id) {
        return (Soba) session.createCriteria(Soba.class).add(Restrictions.eq("sobaId", id)).uniqueResult();
    }

    @Override
    public void deleteSoba(Integer id) {
        Soba soba = (Soba) session.createCriteria(Soba.class).add(Restrictions.eq("sobaId", id)).uniqueResult();
        session.delete(soba);
    }

    @Override
    public Soba addOrUpdate(Soba soba) {
        return (Soba) session.merge(soba);
    }
    
}
