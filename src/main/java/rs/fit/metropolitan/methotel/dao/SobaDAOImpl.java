/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.dao;

import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
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
    
}
