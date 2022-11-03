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
public class Materijal implements Serializable, OpstiDomenskiObjekat {
    private int materijalID;
    private String nazivMaterijala;

    public Materijal() {
    }

    public Materijal(int mterijalID, String nazivMaterijala) {
        this.materijalID = mterijalID;
        this.nazivMaterijala = nazivMaterijala;
    }

    public String getNazivMaterijala() {
        return nazivMaterijala;
    }

    public void setNazivMaterijala(String nazivMaterijala) {
        this.nazivMaterijala = nazivMaterijala;
    }

    public int getMaterijalID() {
        return materijalID;
    }

    public void setMaterijalID(int materijalID) {
        this.materijalID = materijalID;
    }

    @Override
    public String toString() {
        return nazivMaterijala;
    }
//--------------------------------------
    @Override
    public String vratiNazivTabele() {
        return "materijal";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return materijalID + "," + "\"" + nazivMaterijala + "\"" ;
    }

    @Override
    public String vratiNaziveAtributa() {
       return "NazivMaterijala = " + nazivMaterijala;
    }

    @Override
    public String vratiID() {
        return materijalID+"";
    }

    @Override
    public String vratiNazivID() {
        return "MaterijalID";
    }

    @Override
    public String vratiUslovID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
       while(rs.next()){
          
           Materijal materijal  = new Materijal(rs.getInt("MaterijalID"), rs.getString("NazivMaterijala"));
           
           lista.add(materijal);
           
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
