/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.dao;

import rs.fit.metropolitan.methotel.entities.Korisnik;

/**
 *
 * @author Milan
 */
public interface IKorisnikDAO {
    public Korisnik checkKorisnik(String email, String password);
    public Korisnik registerKorisnik(Korisnik kori);
    public boolean checkIfEmailExists(String email);
}
