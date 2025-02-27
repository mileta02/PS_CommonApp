/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author milan
 */
public class Termin implements OpstiDomenskiObjekat {
    private int idTermin;
    private LocalDate vremeOd;
    private LocalDate vremeDo;
    private Date datum;
    private int maxBrojSkijasa;
    private double ukupanIznos;
    private int brojSati;
    private TipTermina tip;
    private Instruktor instruktor;

    public Termin() {
    }

    public Termin(int idTermin, LocalDate vremeOd, LocalDate vremeDo, Date datum, int maxBrojSkijasa, double ukupanIznos, int brojSati, TipTermina tipTermina, Instruktor instruktor) {
        this.idTermin = idTermin;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.datum = datum;
        this.maxBrojSkijasa = maxBrojSkijasa;
        this.ukupanIznos = ukupanIznos;
        this.brojSati = brojSati;
        this.tip = tipTermina;
        this.instruktor = instruktor;
    }

    public int getIdTermin() {
        return idTermin;
    }

    public void setIdTermin(int idTermin) {
        this.idTermin = idTermin;
    }

    public LocalDate getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalDate vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalDate getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalDate vremeDo) {
        this.vremeDo = vremeDo;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getMaxBrojSkijasa() {
        return maxBrojSkijasa;
    }

    public void setMaxBrojSkijasa(int maxBrojSkijasa) {
        this.maxBrojSkijasa = maxBrojSkijasa;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public int getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(int brojSati) {
        this.brojSati = brojSati;
    }

    public TipTermina getTipTermina() {
        return tip;
    }

    public void setTipTermina(TipTermina tipTermina) {
        this.tip = tipTermina;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    @Override
    public String vratiNazivTabele() {
        return "termin";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "(ukupanIznos,vremeOd,vremeDo,brojSati,maxBrojSkijasa,datum,tip,instruktor)";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "("+ukupanIznos+",'"+vremeOd+"','"+vremeDo+"',"+brojSati+","+maxBrojSkijasa+",'"+datum+"',"+tip.getIdTip()+","+instruktor.getIdInstruktor()+")";

    }

    @Override
    public String vratiPrimarniKljuc() {
        return "termin.idTermin="+idTermin;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "ukupanIznos="+ukupanIznos+",vremeOd='"+vremeOd+"',vremeDo='"+vremeDo+"',brojSati="+brojSati+",maxBrojSkijasa="+maxBrojSkijasa+",datum='"+datum+"',tip="+tip.getIdTip()+",instruktor="+instruktor.getIdInstruktor();
    }
    
}
