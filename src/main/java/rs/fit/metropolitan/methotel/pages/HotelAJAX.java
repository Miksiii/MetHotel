/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.pages;

import java.util.List;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.got5.tapestry5.jquery.components.InPlaceEditor;
import rs.fit.metropolitan.methotel.dao.IHotelDAO;
import rs.fit.metropolitan.methotel.entities.Hotel;

/**
 *
 * @author Milan
 */
public class HotelAJAX {
    @Property
    @Persist
    private Hotel newHotel;
    @Property
    private Hotel selectedHotel;
    @Property
    private List<Hotel> hotelList;
    @Inject
    private IHotelDAO hotelDAO;
    @Inject
    private Request req;
    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;
    @InjectComponent
    private Zone zoneForm;
    @InjectComponent
    private Zone zoneGrid;
    @Inject
    private ComponentResources _componentResources;
    
    void onActivate() {
        hotelList = hotelDAO.getHotels();
    }
    
    @CommitAfter
    Object onSuccess() {
        hotelDAO.addOrUpdate(newHotel);
        hotelList = hotelDAO.getHotels();
        newHotel = new Hotel();
        
        if(req.isXHR()) {
            ajaxResponseRenderer.addRender(zoneForm).addRender(zoneGrid);
        }
        
        return req.isXHR() ? zoneGrid.getBody() : null;
    }
    
    @CommitAfter
    Object onActionFromDelete(int id) {
        hotelDAO.deleteDrzava(id);
        hotelList = hotelDAO.getHotels();
        return req.isXHR() ? zoneGrid.getBody() : null;
    }
    
    @CommitAfter
    Object onActionFromEdit(Hotel hotel) {
        newHotel = hotel;
        return req.isXHR() ? zoneForm.getBody() : null;
    }
    
    @CommitAfter
    @OnEvent(component = "hotelIme", value = InPlaceEditor.SAVE_EVENT)
    void setHotelIme(Long id, String val) {
        Hotel activeHotel = (Hotel) hotelDAO.getHotelById(id.intValue());
        activeHotel.setHotelIme(val);
        hotelDAO.addOrUpdate(activeHotel);
    }
    
    @CommitAfter
    @OnEvent(component = "hotelBrojSoba", value = InPlaceEditor.SAVE_EVENT)
    void setBrojSoba(Long id, int val) {
        Hotel activeHotel = (Hotel) hotelDAO.getHotelById(id.intValue());
        activeHotel.setHotelBrojSoba(val);
        hotelDAO.addOrUpdate(activeHotel);
    }
}
