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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MILOS
 */
public class Jakna implements Serializable, OpstiDomenskiObjekat{
    
    private int jaknaID;
    private String naziv;
    private String pol;
    private double cena;
    private Materijal materijal;
    private Velicina velicina;

    public Jakna() {
    }

    public Jakna(int jaknaID, String naziv, String pol, double cena, Materijal materijal, Velicina velicina) {
        this.jaknaID = jaknaID;
        this.naziv = naziv;
        this.pol = pol;
        this.cena = cena;
        this.materijal = materijal;
        this.velicina = velicina;
    }

    public Velicina getVelicina() {
        return velicina;
    }

    public void setVelicina(Velicina velicina) {
        this.velicina = velicina;
    }

    public int getJaknaID() {
        return jaknaID;
    }

    public void setJaknaID(int jaknaID) {
        this.jaknaID = jaknaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Materijal getMaterijal() {
        return materijal;
    }

    public void setMaterijal(Materijal materijal) {
        this.materijal = materijal;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.jaknaID;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jakna other = (Jakna) obj;
        if (this.jaknaID != other.jaknaID) {
            return false;
        }
        return true;
    }

    
    
    
    
    
// -------------------------------------------------------------------
    @Override
    public String vratiNazivTabele() {
        return "jakna";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return jaknaID + "," + "\"" + naziv + "\"" + "," + "\"" + pol + "\"" +  "," + "\"" + cena + "\"" + "," + "\"" + materijal.getMaterijalID() + "\"" + "," + "\"" + velicina.getVelicinaID() + "\"";
    }

    @Override
    public String vratiNaziveAtributa() {
        return "Naziv = " + "\"" + naziv + "\"" + ",Pol = " + "\"" + pol + "\"" + ",Cena = " + cena + ",MaterijalID = " + materijal.getNazivMaterijala()+ ",VelicinaID = " + velicina.toString();
    }

    @Override
    public String vratiID() {
        return jaknaID+"";
    }

    @Override
    public String vratiNazivID() {
        return "JaknaID";
    }

    @Override
    public String vratiUslovID() {
        return "MaterijalID = " + materijal.getMaterijalID() + "VelicinaID = " + velicina.getVelicinaID(); //ne treba mi ?
    }

   

    @Override
    public String vratiUslovZaUpdate() {
        return "JaknaID = " + jaknaID;
    }

    
    
    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniListu(ResultSet rs) throws SQLException {
       ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
       while(rs.next()){
           int jaknaID = rs.getInt("jakna.JaknaID");
           String naziv = rs.getString("jakna.Naziv");
           String pol = rs.getString("jakna.Pol");
           double cena = rs.getDouble("jakna.Cena");
           
//           
//           Materijal mat = new Materijal(rs.getInt("jakna.MaterijalID"), null);
//           Velicina v = new Velicina(rs.getInt("jakna.VelicinaID"), null, null);
           
           int materijalID = rs.getInt("materijal.MaterijalID");
           String nazivMaterijala = rs.getString("materijal.NazivMaterijala");
           Materijal materijal = new Materijal(materijalID, nazivMaterijala);
           
           int velicinaID = rs.getInt("velicina.VelicinaID");
           String univerzalneVelicine = rs.getString("velicina.UniverzalneVelicine");
           String evorpskeVelicine = rs.getString("velicina.EvropskeVelicine");
           Velicina velicina = new Velicina(velicinaID, univerzalneVelicine, evorpskeVelicine);
           
           Jakna jakna = new Jakna(jaknaID, naziv, pol, cena, materijal, velicina);
           lista.add(jakna);
           
       }
       return lista;
    }

    @Override
    public String vratiJoin1() {
        return "materijal";
    }

    @Override
    public String vratiJoin1Uslov() {
        return "jakna.MaterijalID = materijal.MaterijalID";
    }

    @Override
    public String vratiJoin2() {
         return "velicina";
    }

    @Override
    public String vratiJoin2Uslov() {
         return "jakna.VelicinaID = velicina.VelicinaID";
    }
    
    
    
    
}
