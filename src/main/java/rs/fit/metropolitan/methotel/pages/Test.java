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
import rs.fit.metropolitan.methotel.dao.ISobaDAO;
import rs.fit.metropolitan.methotel.entities.Soba;

/**
 *
 * @author Milan
 */
public class Test {
    @Property
    private Soba soba;
    @Property
    private Soba onesoba;
    @Property
    private List<Soba> listaSoba;
    @Inject 
    private ISobaDAO sobaDAO;
    
    void onActivate() {
        if(listaSoba == null) {
            listaSoba = new ArrayList<Soba>();
        }
        
        listaSoba = sobaDAO.getListaSoba();
    }
    
    @CommitAfter
    Object onSuccess() {
        //sobaDAO.addSobu(soba);
        soba = sobaDAO.getSobaById(soba.getSobaId());
        System.out.println("~ALALLALALALALLAL" + soba.getSobaIme());
        return this;
    }
    
}
