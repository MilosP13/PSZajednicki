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
public class Brend  implements Serializable, OpstiDomenskiObjekat {
    
    private int brendID;
    private String nazivBrenda;
    private String namena;

    public Brend() {
    }

    public Brend(int brendID, String nazivBrenda, String namena) {
        this.brendID = brendID;
        this.nazivBrenda = nazivBrenda;
        this.namena = namena;
    }

    public String getNamena() {
        return namena;
    }

    public void setNamena(String namena) {
        this.namena = namena;
    }

    public int getBrendID() {
        return brendID;
    }

    public void setBrendID(int brendID) {
        this.brendID = brendID;
    }

    public String getNazivBrenda() {
        return nazivBrenda;
    }

    public void setNazivBrenda(String nazivBrenda) {
        this.nazivBrenda = nazivBrenda;
    }

    @Override
    public String toString() {
        return nazivBrenda + " ( " + namena +" )" ;
    }
// --------------------
    @Override
    public String vratiNazivTabele() {
        return "brend";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return brendID + "," + "\"" + nazivBrenda + "\"" + "," + "\"" + namena + "\"";
    }

    @Override
    public String vratiNaziveAtributa() {
        String s = "NazivBrenda = " + nazivBrenda + "," + "Namena = " + namena;
        return s;
    }

    @Override
    public String vratiID() {
        return brendID+"";
    }

    @Override
    public String vratiNazivID() {
        return "BrendID";
    }

    @Override
    public String vratiUslovID() {
        return null;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
       while(rs.next()){
          
           Brend brend  = new Brend(rs.getInt("brend.BrendID"), rs.getString("brend.NazivBrenda"), rs.getString("brend.Namena"));
           
           lista.add(brend);
           
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
