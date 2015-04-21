/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import rs.fit.metropolitan.methotel.dao.ISobaDAO;
import rs.fit.metropolitan.methotel.entities.Soba;

/**
 *
 * @author Milan
 */
public class SobaDodavanje {
    
    @Property
    private Soba soba;
    @Property
    private List<Soba> listaSoba;
    @Inject 
    private ISobaDAO sobaDAO;
    
    
    /**
     * Priprema za renderovanje na osnovu TML sadrzaja. Ucitavanje promenljivih
     * sadrzaja iz TML-a.
     */
    void onActivate() {
        if(listaSoba == null) {
            listaSoba = new ArrayList<Soba>();
        }
        
        // selektuj sve sobe i smesti ih uz listu
        listaSoba = sobaDAO.getListaSoba();
    }
    
    /**
     * Validacija je uspesno zavrsena
     * @return 
     */
    @CommitAfter
    Object onSuccess() {
        sobaDAO.addSobu(soba);
        return this;
    }
}
