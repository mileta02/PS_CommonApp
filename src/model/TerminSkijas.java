/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author milan
 */
public class TerminSkijas implements OpstiDomenskiObjekat{
    private Skijas skijas;
    private Termin termin;
    private LocalDate datumPrijave;

    public TerminSkijas() {
    }

    public TerminSkijas(Skijas skijas, Termin termin, LocalDate datumPrijave) {
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

    public LocalDate getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(LocalDate datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    @Override
    public String toString() {
        return "TerminSkijas{" + "skijas=" + skijas.getIdSkijas() + ", termin=" + termin.getIdTermin() + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "terminskijas";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> list = new ArrayList<>();
        while(rs.next()){
            int termin = rs.getInt("termin");
            int skijas = rs.getInt("skijas");
            Termin t = new Termin();
            t.setIdTermin(termin);
            Skijas s = new Skijas();
            s.setIdSkijas(skijas);
            TerminSkijas ts = new TerminSkijas();
            ts.setSkijas(s);
            ts.setTermin(t);
            list.add(ts);
        }
        return list;
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
    public String vratiFilter(List<Object> parametri) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovDaPostoji() {
        return "terminskijas.termin="+termin.getIdTermin()+" AND terminskijas.skijas="+skijas.getIdSkijas();
    }

    @Override
    public String vratiRazlicitPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TerminSkijas that = (TerminSkijas) o;
        return termin.getIdTermin() == that.termin.getIdTermin() && skijas.getIdSkijas() == that.skijas.getIdSkijas();
    }

    @Override
    public int hashCode() {
        return Objects.hash(termin.getIdTermin(), skijas.getIdSkijas());
}
    
}
