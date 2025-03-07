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
public class NivoSkijanja implements OpstiDomenskiObjekat{
    private int idNivoSkijanja;
    private String nazivNivoa;

    public NivoSkijanja() {
    }

    public NivoSkijanja(int idNivoSkijanja, String nazivNivoa) {
        this.idNivoSkijanja = idNivoSkijanja;
        this.nazivNivoa = nazivNivoa;
    }

    public int getIdNivoSkijanja() {
        return idNivoSkijanja;
    }

    public void setIdNivoSkijanja(int idNivoSkijanja) {
        this.idNivoSkijanja = idNivoSkijanja;
    }

    public String getNazivNivoa() {
        return nazivNivoa;
    }

    public void setNazivNivoa(String nazivNivoa) {
        this.nazivNivoa = nazivNivoa;
    }

    @Override
    public String vratiNazivTabele() {
        
        return "nivoskijanja";


    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int idNivoSkijanja = rs.getInt("nivoskijanja.idNivoSkijanja");
            String nazivNivoa = rs.getString("nivoskijanja.nazivNivoa");
            NivoSkijanja ns = new NivoSkijanja(idNivoSkijanja, nazivNivoa);
            lista.add(ns);
        }
        return lista;       }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "(nazivNivoa)";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
                return "('"+nazivNivoa+"')";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "nivoskijanja.idNivoSkijanja="+idNivoSkijanja;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
                return "nazivNivoa='"+nazivNivoa+"'";
    }

    @Override
    public String vratiUslovNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
