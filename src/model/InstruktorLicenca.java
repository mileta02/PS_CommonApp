/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milan
 */
public class InstruktorLicenca implements OpstiDomenskiObjekat{
    private int godinaSticanja;
    private Instruktor instruktor;
    private Licenca licenca;

    public InstruktorLicenca() {
    }

    public InstruktorLicenca(int godinaSticanja, Instruktor instruktor, Licenca licenca) {
        this.godinaSticanja = godinaSticanja;
        this.instruktor = instruktor;
        this.licenca = licenca;
    }

    public int getGodinaSticanja() {
        return godinaSticanja;
    }

    public void setGodinaSticanja(int godinaSticanja) {
        this.godinaSticanja = godinaSticanja;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    public Licenca getLicenca() {
        return licenca;
    }

    public void setLicenca(Licenca licenca) {
        this.licenca = licenca;
    }

    @Override
    public String toString() {
        return "InstruktorLicenca{" + "godinaSticanja=" + godinaSticanja + ", instruktor=" + instruktor + ", licenca=" + licenca + '}';
    }

    
    
    @Override
    public String vratiNazivTabele() {
        
                return "instruktorlicenca";


    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> list = new ArrayList<>();
        while(rs.next()){
            int instruktor = rs.getInt("instruktor");
            int licenca = rs.getInt("licenca");
            int godina = rs.getInt("godinaSticanja");
            Instruktor i = new Instruktor();
            i.setIdInstruktor(instruktor);
            Licenca l = new Licenca();
            l.setIdLicenca(licenca);
            InstruktorLicenca il = new InstruktorLicenca();
            il.setInstruktor(i);
            il.setLicenca(l);
            il.setGodinaSticanja(godinaSticanja);
            list.add(il);
        }
        return list;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "(instruktor,licenca,godinaSticanja)";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "("+instruktor.getIdInstruktor()+","+licenca.getIdLicenca()+","+godinaSticanja+")";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "instruktor="+instruktor.getIdInstruktor()+" AND licenca="+licenca.getIdLicenca() + " AND godinaSticanja="+godinaSticanja;
    }

    @Override
    public String vratiRazlicitPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "instruktor="+instruktor.getIdInstruktor()+",licenca="+licenca.getIdLicenca()+",godinaSticanja="+godinaSticanja;
    }

    @Override
    public String vratiFilter(List<Object> parametri) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovDaPostoji() {
        return "instruktorlicenca.instruktor="+instruktor.getIdInstruktor()+" AND instruktorlicenca.godinaSticanja="+godinaSticanja;
    }
    
    
}
