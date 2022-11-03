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
public class Porudzbina  implements Serializable, OpstiDomenskiObjekat  {
    
    private int porudzbinaID;
    private String imePrezime;
    private double ukupnaCena;
    private String adresa;
    private String opis;

    public Porudzbina() {
    }

    public Porudzbina(int porudzbinaID, String imePrezime, double ukupnaCena, String adresa, String opis) {
        this.porudzbinaID = porudzbinaID;
        this.imePrezime = imePrezime;
        this.ukupnaCena = ukupnaCena;
        this.adresa = adresa;
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getPorudzbinaID() {
        return porudzbinaID;
    }

    public void setPorudzbinaID(int porudzbinaID) {
        this.porudzbinaID = porudzbinaID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Porucio:" + " " + imePrezime + " " + "Adresa:" + " " + adresa;
    }
// ---------------------
    @Override
    public String vratiNazivTabele() {
        return "porudzbina";
    }

    @Override
    public String vratiVrednostiAtributa() {
       return porudzbinaID + "," + "\"" + imePrezime + "\"" + "," + "\"" + ukupnaCena + "\"" + "," + "\"" + adresa + "\"" + "," + opis;
    }

    @Override
    public String vratiNaziveAtributa() {
        return null;
    }

    @Override
    public String vratiID() {
        return porudzbinaID+"";
    }

    @Override
    public String vratiNazivID() {
        return "PorudzbinaID";
    }

    @Override
    public String vratiUslovID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniListu(ResultSet rs) throws SQLException {
       ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
       while(rs.next()){
          
           Porudzbina p = new Porudzbina(rs.getInt("porudzbina.PorudzbinaID"), rs.getString("porudzbina.ImePrezime"), rs.getDouble("porudzbina.UkupnaCena")
                   , rs.getString("porudzbina.Adresa"), rs.getString("porudzbina.Opis"));
           
           lista.add(p);
           
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
