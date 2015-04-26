/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.dao;

import java.util.List;
import rs.fit.metropolitan.methotel.entities.Rezervacije;

/**
 *
 * @author Milan
 */
public interface IRezervacijaDAO {
    public void addRezervacija(Rezervacije rezervacija);
    public List<Rezervacije> getListaRezervacija();
    public void deleteRezervacija(Integer id);
}
