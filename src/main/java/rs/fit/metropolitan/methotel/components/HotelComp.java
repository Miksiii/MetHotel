/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.components;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

/**
 *
 * @author Milan
 */
public class HotelComp {
    
    @Parameter(required = true)
    @Property
    private int adults;
    @Parameter(required = true)
    @Property
    private int children;
    @Parameter(required = true)
    @Property
    private int rooms;
    @Property
    private double price;
    
    public String getEstimatePrice(){ 
        price = (adults * 50) + (children * 20) * rooms;
        return "Estimated price for " + adults + " adults and " + children + ""
                + "children with " + rooms + " room is about " + price + " USD.";
    }

}
