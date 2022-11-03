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
public class StavkaPorudzbine implements Serializable, OpstiDomenskiObjekat{
    
   
    private Jakna jakna;
    private Porudzbina porudzbina;
    private int RB;

    public StavkaPorudzbine() {
    }

    public StavkaPorudzbine(Jakna jakna, Porudzbina porudzbina, int RB) {
        
        this.jakna = jakna;
        this.porudzbina = porudzbina;
        this.RB = RB;
    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }

    public int getRB() {
        return RB;
    }

    public void setRB(int RB) {
        this.RB = RB;
    }

    public Jakna getJakna() {
        return jakna;
    }

    public void setJakna(Jakna jakna) {
        this.jakna = jakna;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaporudzbine";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return jakna.getJaknaID() + "," + porudzbina.getPorudzbinaID() + "," + RB;
    }

    @Override
    public String vratiNaziveAtributa() {
        return "";
    }

    @Override
    public String vratiID() {
        return "";
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
          
           int rbStavke = rs.getInt("stavkaporudzbine.RB");
           
           Jakna j = new Jakna(rs.getInt("jakna.JaknaID"), null, null, 0, null, null);
           
           Porudzbina p = new Porudzbina(rs.getInt("porudzbina.PorudzbinaID"), null, 0, null, null);
           
           
           StavkaPorudzbine stavka = new StavkaPorudzbine(j,p,rbStavke);
  
           lista.add(stavka);
       }
       return lista;
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "PorudzbinaID = " + porudzbina.getPorudzbinaID();
    }

    @Override
    public String vratiJoin1() {
        return "jakna";
    }

    @Override
    public String vratiJoin1Uslov() {
        return "stavkaporudzbine.JaknaID = jakna.JaknaID";
    }

    @Override
    public String vratiJoin2() {
         return "porudzbina";
    }

    @Override
    public String vratiJoin2Uslov() {
        return "stavkaporudzbine.PorudzbinaID = porudzbina.PorudzbinaID";
    }
    
    
}
