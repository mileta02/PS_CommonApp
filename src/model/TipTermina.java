/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public String toString() {
        return nazivTipa;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj==null || getClass()!=obj.getClass()) 
            return false;
        
        TipTermina that = (TipTermina) obj;
        return Objects.equals(this.getNazivTipa(), that.getNazivTipa()) &&
                Objects.equals(this.getCenaSata(), that.getCenaSata());
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
    public String vratiRazlicitPrimarniKljuc() {
        return "tiptermina.idTip!="+idTip;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
         int idTipTermina = rs.getInt("tiptermina.idTip");
            double cenaSata = rs.getDouble("tiptermina.cenaSata");
            String nazivTipa = rs.getString("tiptermina.nazivTipa");
            TipTermina tt = new TipTermina(idTipTermina, cenaSata, nazivTipa);
            return tt;
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "cenaSata="+cenaSata+",nazivTipa='"+nazivTipa+"'";
    }

    @Override
    public String vratiFilter(List<Object> parametri) {
        StringBuilder sb = new StringBuilder("1=1 "); 
    if (cenaOd>-1) {
        sb.append(" AND cenaSata >= ?");
        parametri.add(cenaOd);
    }
    if (cenaDo>-1) {
        sb.append(" AND cenaSata <= ?");
        parametri.add(cenaDo);
    }
    if (nazivTipa != null && !nazivTipa.isEmpty()) {
        sb.append(" AND nazivTipa LIKE ?");
        parametri.add(nazivTipa+"%");
    }

    return sb.toString();
    }

    @Override
    public String vratiUslovDaPostoji() {
        return "tiptermina.nazivTipa='"+nazivTipa+"' AND tiptermina.cenaSata="+cenaSata;
    }
    
    
    
}
