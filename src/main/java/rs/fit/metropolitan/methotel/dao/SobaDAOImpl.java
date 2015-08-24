/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.dao;

import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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

    @Override
    public int countAllSobe() {
        Long counter = (Long) session.createCriteria(Soba.class).setProjection(Projections.rowCount()).uniqueResult();
        return counter.intValue();
    }

    @Override
    public List<Soba> fetchSobeFromPage(int pageNum) {
        int page = (pageNum - 1) * 20;
        List<Soba> sobaList = session.createCriteria(Soba.class).setFirstResult(page).setMaxResults(20).addOrder(Order.asc("id")).setResultTransformer(
                Criteria.DISTINCT_ROOT_ENTITY).list();
        return sobaList;
    }

    @Override
    public List<Soba> findByName(String name) {
        List<Soba> sobaList = session.createCriteria(Soba.class).add(Restrictions.ilike("sobaIme", name + "%")).list();
        return sobaList;
    }
    
}
