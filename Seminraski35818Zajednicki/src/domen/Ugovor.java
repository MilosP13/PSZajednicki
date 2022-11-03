/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MILOS
 */
public class Ugovor implements Serializable, OpstiDomenskiObjekat{
    
    
    
    private Jakna jakna;
    private Brend brend;
    private Date datumUgovora;

    public Ugovor() {
    }

    public Ugovor(Jakna jakna, Brend brend, Date datumUgovora) {
        
        this.jakna = jakna;
        this.brend = brend;
        this.datumUgovora = datumUgovora;
    }

    public Brend getBrend() {
        return brend;
    }

    public void setBrend(Brend brend) {
        this.brend = brend;
    }

    public Date getDatumUgovora() {
        return datumUgovora;
    }

    public void setDatumUgovora(Date datumUgovora) {
        this.datumUgovora = datumUgovora;
    }

    public Jakna getJakna() {
        return jakna;
    }

    public void setJakna(Jakna jakna) {
        this.jakna = jakna;
    }
// --------------------------------
    @Override
    public String vratiNazivTabele() {
        return "ugovor";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return jakna.getJaknaID() + "," + brend.getBrendID() + "," + "\"" + datumUgovora + "\"";
    }

    @Override
    public String vratiNaziveAtributa() {
       return "";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniListu(ResultSet rs) throws SQLException {
      ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
       while(rs.next()){

           Jakna j = new Jakna(rs.getInt("jakna.JaknaID"), null, null, 0, null, null);
           
           Brend b = new Brend(rs.getInt("brend.BrendID"), null, null);
           
           Timestamp timestamp = rs.getTimestamp("DatumUgovora");
           Date datum = new Date(timestamp.getTime());
           
           
           Ugovor ugovor = new Ugovor(j, b, datum);
  
           lista.add(ugovor);
       }
       return lista;
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "JaknaID = " + jakna.getJaknaID();
    }

    @Override
    public String vratiJoin1() {
        return "jakna";
    }

    @Override
    public String vratiJoin1Uslov() {
        return "ugovor.JaknaID = jakna.JaknaID";
    }

    @Override
    public String vratiJoin2Uslov() {
        return "brend";
    }

    @Override
    public String vratiJoin2() {
       return "ugovor.BrendID = brend.BrendID";
    }
   
    
    
    
}
