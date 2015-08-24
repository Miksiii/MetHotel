/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.pages.services;

import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.RequestParameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.TextStreamResponse;
import rs.fit.metropolitan.methotel.dao.ISobaDAO;
import rs.fit.metropolitan.methotel.entities.Soba;

/**
 *
 * @author Milan
 */
public class RoomFinder {
    @Inject
    private ISobaDAO sobaDAO;
    @Property
    private List<Soba> sobaList;
    
    Object onActivate(@RequestParameter("name") String name) {
        System.out.println("~onactivate caleld.");
        if(sobaList == null) {
            sobaList = new ArrayList<Soba>();
        }
        sobaList = sobaDAO.findByName(name);
        
        String response = "<table class=\"navigation\"> <th>ime grada</th>\n";
        for(Soba tmpSoba : sobaList) {
            response += "<tr><td>" + tmpSoba.getSobaIme() + "</tr></td>";
        }
        response += "</table>";
        
        return new TextStreamResponse("text/plain", response);
    }
}
