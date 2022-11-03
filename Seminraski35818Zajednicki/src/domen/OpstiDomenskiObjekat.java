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
public interface OpstiDomenskiObjekat extends Serializable {
    
    public abstract String vratiNazivTabele();
    public abstract String vratiVrednostiAtributa();
    public abstract String vratiNaziveAtributa();
    
    public abstract String vratiID();
    public abstract String vratiNazivID();
    public abstract String vratiUslovID();
    
    
    public abstract String vratiJoin1();
    public abstract String vratiJoin1Uslov();
    public abstract String vratiJoin2();
    public abstract String vratiJoin2Uslov();
    
    
    public ArrayList<OpstiDomenskiObjekat> napuniListu(ResultSet rs) throws SQLException;
    
    public abstract String vratiUslovZaUpdate();
    
    
    
}
