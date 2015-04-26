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
import rs.fit.metropolitan.methotel.entities.Hotel;

/**
 *
 * @author Milan
 */
public class HotelDAOImpl implements IHotelDAO{

    @Inject
    private Session session;
    @Override
    public Hotel getHotelById(Integer id) {
        return (Hotel) session.createCriteria(Hotel.class).add(Restrictions.eq("hotelId", id)).uniqueResult();
    }

    @Override
    public List<Hotel> getHotels() {
        return session.createCriteria(Hotel.class).list();
    }
    
}
