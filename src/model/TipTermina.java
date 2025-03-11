/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milan
 */
public class TipTermina implements OpstiDomenskiObjekat{

    private int idTip;
    private double cenaSata;
    private String nazivTipa;
    private double cenaOd;
    private double cenaDo;
    
    
    public TipTermina() {
    }

    public TipTermina(int idTip, double cenaSata, String nazivTipa) {
        this.idTip = idTip;
        this.cenaSata = cenaSata;
        this.nazivTipa = nazivTipa;
    }

    public int getIdTip() {
        return idTip;
    }

    public void setIdTip(int idTip) {
        this.idTip = idTip;
    }

    public double getCenaSata() {
        return cenaSata;
    }

    public void setCenaSata(double cenaSata) {
        this.cenaSata = cenaSata;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }

    public void setNazivTipa(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }
    
    public void filter(double cenaOd, double cenaDo){
        this.cenaDo=cenaDo;
        this.cenaOd=cenaOd;
    }
    

    @Override
    public String vratiNazivTabele() {
        return "tiptermina";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int idTipTermina = rs.getInt("tiptermina.idTip");
            double cenaSata = rs.getDouble("tiptermina.cenaSata");
            String nazivTipa = rs.getString("tiptermina.nazivTipa");
            TipTermina tt = new TipTermina(idTipTermina, cenaSata, nazivTipa);
            lista.add(tt);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "(cenaSata,nazivTipa)";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "("+cenaSata+",'"+nazivTipa+"')";

    }

    @Override
    public String vratiPrimarniKljuc() {
        return "tiptermina.idTip="+idTip;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "cenaSata="+cenaSata+",nazivTipa='"+nazivTipa+"'";
    }

    @Override
    public String vratiUslovNadjiSlogove() {
        StringBuilder uslov = new StringBuilder("1=1 AND "); 
        boolean previous = false;
    if (cenaOd>-1) {
        uslov.append("cenaSata >= ").append(cenaOd);
        previous=true;
    }
    if (cenaDo>-1) {
        if(previous)
            uslov.append(" AND ");
        uslov.append("cenaSata <= ").append(cenaDo);
        previous=true;
    }
    if (nazivTipa != null && !nazivTipa.isEmpty()) {
        if(previous)
            uslov.append(" AND ");
        uslov.append("nazivTipa LIKE '").append(nazivTipa).append("%'");
    }

    return uslov.toString();
    }
    
    
    
}
