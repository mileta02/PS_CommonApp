/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author milan
 */
public class Termin implements OpstiDomenskiObjekat {
    private int idTermin;
    private LocalTime vremeOd;
    private LocalTime vremeDo;
    private LocalDate datum;
    private int maxBrojSkijasa;
    private double ukupanIznos;
    private int brojSati;
    private TipTermina tip;
    private Instruktor instruktor;

    public Termin() {
    }

    public Termin(int idTermin, LocalTime vremeOd, LocalTime vremeDo, LocalDate datum, int maxBrojSkijasa, double ukupanIznos, int brojSati, TipTermina tipTermina, Instruktor instruktor) {
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

    public LocalTime getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalTime vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalTime getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalTime vremeDo) {
        this.vremeDo = vremeDo;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
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
        int idTermin = rs.getInt("termin.idTermin");
        LocalTime vremeOd = rs.getTime("vremeOd").toLocalTime();
        LocalTime vremeDo = rs.getTime("vremeDo").toLocalTime();
        LocalDate datum = rs.getDate("datum").toLocalDate(); 
        int maxBrojSkijasa = rs.getInt("maxBrojSkijasa");
        double ukupanIznos = rs.getDouble("ukupanIznos");
        int brojSati = rs.getInt("brojSati");
        
        
        Termin t = new Termin(idTermin, vremeOd, vremeDo, datum, maxBrojSkijasa, ukupanIznos, brojSati, tip, instruktor);
        
        return t;
    }   

    @Override
    public String vratiVrednostZaIzmenu() {
        return "ukupanIznos="+ukupanIznos+",vremeOd='"+vremeOd+"',vremeDo='"+vremeDo+"',brojSati="+brojSati+",maxBrojSkijasa="+maxBrojSkijasa+",datum='"+datum+"',tip="+tip.getIdTip()+",instruktor="+instruktor.getIdInstruktor();
    }

    @Override
    public String vratiUslovNadjiSlogove() {
        StringBuilder sb = new StringBuilder("1=1");
        if(instruktor!=null)
            sb.append(" AND instruktor.idInstruktor="+instruktor.getIdInstruktor());
        
        if(tip!=null)
            sb.append(" AND tiptermina.idTip="+tip.getIdTip());
        
        if(maxBrojSkijasa>0)
            sb.append(" AND termin.maxBrojSkijasa="+maxBrojSkijasa);
        
        if (datum != null) 
             sb.append(" AND termin.datum >= CURDATE()");
//sb.append(" AND termin.datum = '").append(Date.valueOf(datum)).append("'");

        return sb.toString();
    }
    
}
