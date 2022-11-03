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
public class Velicina  implements Serializable, OpstiDomenskiObjekat {
    
    private int velicinaID;
    private String univerzalne;
    private String evropske;

    public Velicina() {
    }

    public Velicina(int velicinaID, String univerzalne, String evropske) {
        this.velicinaID = velicinaID;
        this.univerzalne = univerzalne;
        this.evropske = evropske;
    }

    public String getEvropske() {
        return evropske;
    }

    public void setEvropske(String evropske) {
        this.evropske = evropske;
    }

    public int getVelicinaID() {
        return velicinaID;
    }

    public void setVelicinaID(int velicinaID) {
        this.velicinaID = velicinaID;
    }

    public String getUniverzalne() {
        return univerzalne;
    }

    public void setUniverzalne(String univerzalne) {
        this.univerzalne = univerzalne;
    }

    @Override
    public String toString() {
        return univerzalne + " " + "(" + evropske + ")";
    }
// ------------
    @Override
    public String vratiNazivTabele() {
       return "velicina";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return velicinaID + "," + univerzalne + "," + evropske;
    }

    @Override
    public String vratiNaziveAtributa() {
       return null;
    }

    @Override
    public String vratiID() {
        return velicinaID+"";
    }

    @Override
    public String vratiNazivID() {
       return "VelicinaID";
    }

    @Override
    public String vratiUslovID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
       while(rs.next()){
          
           Velicina velicina = new Velicina(rs.getInt("velicina.VelicinaID"), rs.getString("velicina.UniverzalneVelicine"), rs.getString("velicina.EvropskeVelicine"));
           System.out.println(velicina.getVelicinaID());
           lista.add(velicina);
           
       }
       return lista;
    }

    @Override
    public String vratiUslovZaUpdate() {
        return null;
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
    public String vratiJoin2Uslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoin2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
