/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.dao;

import java.util.List;
import rs.fit.metropolitan.methotel.entities.Hotel;

/**
 *
 * @author Milan
 */
public interface IHotelDAO {
    public Hotel getHotelById(Integer id);
    public List<Hotel> getHotels();
}
