/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import rs.fit.metropolitan.methotel.dao.IHotelDAO;
import rs.fit.metropolitan.methotel.dao.IRezervacijaDAO;
import rs.fit.metropolitan.methotel.entities.Hotel;
import rs.fit.metropolitan.methotel.entities.Rezervacije;
import rs.fit.metropolitan.methotel.entities.Soba;

/**
 *
 * @author Milan
 */
public class RezervacijaDodavanje {
    
    @Property
    private Rezervacije rezervacija;
    @Property
    private Rezervacije rezervacijaone;
    @Property
    private Hotel hotelId;
    @Property
    private Hotel hotel;
    @Property
    private List<Rezervacije> listaRezervacija;
    @Property
    private List<Hotel> listaHotela;
    @Inject
    private IRezervacijaDAO rezervacijaDAO;  
    @Inject
    private IHotelDAO hotelDAO;
    
    //encoder
    public ValueEncoder getEncoder() {
        
        return new ValueEncoder<Hotel>() {

            @Override
            public String toClient(Hotel v) {
                return String.valueOf(v.getHotelId());
            }

            @Override
            public Hotel toValue(String string) {
                hotel = hotelDAO.getHotelById(Integer.parseInt(string));
                return hotel;
            }
        };
    }
    
    /**
     * Priprema za renderovanje na osnovu TML sadrzaja. Ucitavanje promenljivih
     * sadrzaja iz TML-a.
     */
    void onActivate() {
        if(listaRezervacija == null) {
            listaRezervacija = new ArrayList<Rezervacije>();
        }
        
        listaHotela = hotelDAO.getHotels();
        listaRezervacija = rezervacijaDAO.getListaRezervacija();
    }
    
    @CommitAfter
    Object onSuccess() {
        rezervacija.setHotelId(hotelId);
        rezervacijaDAO.addRezervacija(rezervacija);
        return this;
    }
    
    @CommitAfter
    Object onActionFromDelete(int id) {
        rezervacijaDAO.deleteRezervacija(id);
        return this;
    }
    
    public String getHotel() {
        if(rezervacijaone.getHotelId() != null) {
            return rezervacijaone.getHotelId().getHotelIme();
        } else {
            return "";
        }
    }
    
}
