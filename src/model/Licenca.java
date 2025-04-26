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
public class Licenca implements OpstiDomenskiObjekat{
    private int idLicenca;
    private String zvanjeInstruktora;
    private String nazivLicence;

    public Licenca() {
    }

    public Licenca(int idLicenca, String zvanjeInstruktora, String nazivLicence) {
        this.idLicenca = idLicenca;
        this.zvanjeInstruktora = zvanjeInstruktora;
        this.nazivLicence = nazivLicence;
    }

    @Override
    public String toString() {        
        return nazivLicence +"- "+zvanjeInstruktora;      
    }

    public int getIdLicenca() {
        return idLicenca;
    }

    public void setIdLicenca(int idLicence) {
        this.idLicenca = idLicence;
    }

    public String getZvanjeInstruktora() {
        return zvanjeInstruktora;
    }

    public void setZvanjeInstruktora(String zvanjeInstruktora) {
        this.zvanjeInstruktora = zvanjeInstruktora;
    }

    public String getNazivLicence() {
        return nazivLicence;
    }

    public void setNazivLicence(String nazivLicence) {
        this.nazivLicence = nazivLicence;
    }
    
    

    @Override
    public String vratiNazivTabele() {
        return "licenca";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int idLicence = rs.getInt("licenca.idLicenca");
            String zvanjeInstruktora = rs.getString("licenca.zvanjeInstruktora");
            String nazivLicence = rs.getString("licenca.nazivLicence");
            Licenca l = new Licenca(idLicence, zvanjeInstruktora, nazivLicence);
            lista.add(l);
        }
        return lista;    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "(zvanjeInstruktora,nazivLicence)";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "('"+zvanjeInstruktora+"','"+nazivLicence+"')";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "licenca.idLicenca="+idLicenca;
    }

    @Override
    public String vratiRazlicitPrimarniKljuc() {
        return "licenca.idLicenca!="+idLicenca;
    }
    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        int idLicence = rs.getInt("licenca.idLicenca");
        String zvanjeInstruktora = rs.getString("licenca.zvanjeInstruktora");
        String nazivLicence = rs.getString("licenca.nazivLicence");
        Licenca l = new Licenca(idLicence, zvanjeInstruktora, nazivLicence);
        
        return l;
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "zvanjeInstruktora='"+zvanjeInstruktora+"',nazivLicence='"+nazivLicence+"'";
    }

    @Override
    public String vratiFilter(List<Object> parametri) {
        StringBuilder sb = new StringBuilder("1=1");
        if(!nazivLicence.isEmpty()){
            sb.append(" AND nazivLicence LIKE ?");
            parametri.add(nazivLicence+"%");
        }
        if(!zvanjeInstruktora.isEmpty()){
            sb.append(" AND zvanjeInstruktora LIKE ?");
            parametri.add(zvanjeInstruktora+"%");
        }
        
        return sb.toString();
    }

    @Override
    public String vratiUslovDaPostoji() {
        return "licenca.nazivLicence='"+nazivLicence+"' AND licenca.zvanjeInstruktora='"+zvanjeInstruktora+"'";
    }
    
    
    
}
