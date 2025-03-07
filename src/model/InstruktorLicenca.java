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
public class InstruktorLicenca implements OpstiDomenskiObjekat{
    private Date datumSticanja;
    private Instruktor instruktor;
    private Licenca licenca;

    public InstruktorLicenca() {
    }

    public InstruktorLicenca(Date datumSticanja, Instruktor instruktor, Licenca licenca) {
        this.datumSticanja = datumSticanja;
        this.instruktor = instruktor;
        this.licenca = licenca;
    }

    public Date getDatumSticanja() {
        return datumSticanja;
    }

    public void setDatumSticanja(Date datumSticanja) {
        this.datumSticanja = datumSticanja;
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
    public String vratiNazivTabele() {
        
                return "instruktorlicenca";


    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "(instruktor,licenca,datumSticanja)";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "("+instruktor.getIdInstruktor()+","+licenca.getIdLicenca()+",'"+datumSticanja+"')";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "instruktor="+instruktor.getIdInstruktor()+" AND licenca="+licenca.getIdLicenca();
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "instruktor="+instruktor.getIdInstruktor()+",licenca="+licenca.getIdLicenca()+",datumSticanja='"+datumSticanja+"'";
    }

    @Override
    public String vratiUslovNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
