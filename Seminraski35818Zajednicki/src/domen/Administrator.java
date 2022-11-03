/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MILOS
 */
public class Administrator implements Serializable, OpstiDomenskiObjekat{
    
    private String korisicnoIme;
    private String lozinka;

    public Administrator() {
    }

    public Administrator(String korisicnoIme, String lozinka) {
        this.korisicnoIme = korisicnoIme;
        this.lozinka = lozinka;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getKorisicnoIme() {
        return korisicnoIme;
    }

    public void setKorisicnoIme(String korisicnoIme) {
        this.korisicnoIme = korisicnoIme;
    }

    @Override
    public String toString() {
        return korisicnoIme;
    }
// -------------------
    @Override
    public String vratiNazivTabele() {
        return "administrator";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return korisicnoIme + "," + lozinka;
    }

    @Override
    public String vratiNaziveAtributa() {
        return null;
    }

    @Override
    public String vratiID() {
        return null;
    }

    @Override
    public String vratiNazivID() {
         return null;
    }

    @Override
    public String vratiUslovID() {
         return null;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniListu(ResultSet rs) throws SQLException {
       ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
       while(rs.next()){
           Administrator admin = new Administrator(rs.getString("administrator.KorisnickoIme"), rs.getString("administrator.Lozinka"));
           
           lista.add(admin);
           
       }
       return lista;
    
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "";
    }

    @Override
    public String vratiJoin1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoin1Uslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoin2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoin2Uslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
