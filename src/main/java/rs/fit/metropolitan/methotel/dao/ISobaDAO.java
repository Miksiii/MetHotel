/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.dao;

import rs.fit.metropolitan.methotel.entities.Soba;
import java.util.List;

/**
 *
 * @author Milan
 */
public interface ISobaDAO {
    public List<Soba> getListaSoba();
    public void addSobu(Soba soba);
}
