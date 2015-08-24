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
public class Pagination {
    @Inject
    private ISobaDAO sobaDAO;
    @Property
    private List<Soba> sobaList;
    
    Object onActivate(@RequestParameter("page") int page) {
        
        int totalRooms = sobaDAO.countAllSobe();
        sobaList = sobaDAO.fetchSobeFromPage(page);
        String response = "<table class=\"pagination\"><th>Lista soba:</th>";
        
        for(Soba tmpSoba : sobaList) {
            response += "<tr><td>" + tmpSoba.getSobaIme() + "</td></tr>";
        }
        
        response += "</table>";
        
        // pagination stuff
        float ceil = (float) totalRooms / (float) 20;
        int totalPages = (int) Math.ceil(ceil);
        response += "<ul class=\"pagination\">";
        
        for(int i = 0; i < totalPages; i++) {
            if(i == page) {
                response += ("<li class=\"callservice active\"><a href=\"#\">" + i + "</a></li>");
            } else {
                response += ("<li class=\"callservice\"><a href=\"#\">" + i + "</a></li>");
            }
        }
        
        return new TextStreamResponse("text/plain", response);
    }
}
