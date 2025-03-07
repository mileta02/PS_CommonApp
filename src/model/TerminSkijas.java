/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author milan
 */
public class TerminSkijas implements OpstiDomenskiObjekat{
    private Skijas skijas;
    private Termin termin;
    private Date datumPrijave;

    public TerminSkijas() {
    }

    public TerminSkijas(Skijas skijas, Termin termin, Date datumPrijave) {
        this.skijas = skijas;
        this.termin = termin;
        this.datumPrijave = datumPrijave;
    }

    public Skijas getSkijas() {
        return skijas;
    }

    public void setSkijas(Skijas skijas) {
        this.skijas = skijas;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    @Override
    public String vratiNazivTabele() {
        return "terminskijas";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "(termin,skijas,datumPrijave)";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "("+termin.getIdTermin()+","+skijas.getIdSkijas()+",'"+datumPrijave+"')";

        
    }

    @Override
    public String vratiPrimarniKljuc() {
                return "termin="+termin.getIdTermin()+" AND skijas="+skijas.getIdSkijas();

    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "termin="+termin.getIdTermin()+",skijas="+skijas.getIdSkijas()+",datumPrijave='"+datumPrijave+"'";
    }

    @Override
    public String vratiUslovNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
