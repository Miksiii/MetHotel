/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.pages;

import java.util.ArrayList;
import org.apache.tapestry5.annotations.PageLoaded;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import rs.fit.metropolitan.methotel.dao.ISobaDAO;
import rs.fit.metropolitan.methotel.entities.Soba;

/**
 *
 * @author Milan
 */
public class SobaFancy {
    @Inject
    private ISobaDAO sobaDAO;
    @Persist
    @Property
    private Soba newSoba;
    @Property
    private Soba selectedSoba;
    @Property
    private ArrayList<Soba> sobaList;
    
    @PageLoaded
    void getSveSobe() {
        if(sobaList == null) {
            sobaList = new ArrayList<Soba>();
        }
        sobaList = (ArrayList<Soba>) sobaDAO.getListaSoba();
    }
    
    @CommitAfter
    Object onSuccess() {
        listAdd(sobaDAO.addOrUpdate(newSoba));
        newSoba = new Soba();
        return this;
    }
    
    /* Handle added/merged object to list */
    public void listAdd(Soba soba) {
        boolean isDuplicate = false;
        
        for(Soba tmpSoba : sobaList) {
            /* Merge deo */
            if(tmpSoba.getSobaId().equals(soba.getSobaId())) {
                isDuplicate = true;
                sobaList.remove(tmpSoba);
                sobaList.add(soba);
                break;
            }
        }
        
        /* if merge wasn't detected */
        if(!isDuplicate) {
            sobaList.add(soba);
        }
    }
    
    @CommitAfter
    Object onActionFromDelete(int id) {
        sobaList.remove(sobaDAO.getSobaById(id));
        sobaDAO.deleteSoba(id);
        return this;
    }
    
    @CommitAfter
    Object onActionFromEdit(Soba soba) {
        newSoba = soba;
        return this;
    }
    
     public JSONObject getOptions() {
        JSONObject json = new JSONObject();
        json.put("bJQueryUI", "true");
        json.put("bStateSave", true);
        json.put("bAutoWidth", true);
        return json;
     }

    
}
