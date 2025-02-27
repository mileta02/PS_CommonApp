/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author milan
 */
public class Skijas implements OpstiDomenskiObjekat{
    private int idSkijas;
    private String ime;
    private String prezime;
    private String brojTelefona;
    private NivoSkijanja nivoSkijanja;

    public Skijas() {
    }

    public Skijas(int idSkijas, String ime, String prezime, String brojTelefona, NivoSkijanja nivoSkijanja) {
        this.idSkijas = idSkijas;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.nivoSkijanja = nivoSkijanja;
    }

    public int getIdSkijas() {
        return idSkijas;
    }

    public void setIdSkijas(int idSkijas) {
        this.idSkijas = idSkijas;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public NivoSkijanja getNivoSkijanja() {
        return nivoSkijanja;
    }

    public void setNivoSkijanja(NivoSkijanja nivoSkijanja) {
        this.nivoSkijanja = nivoSkijanja;
    }

    @Override
    public String vratiNazivTabele() {
        return "skijas";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "(ime,prezime,brojTelefona,nivoSkijanja)";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "('"+ime+"','"+prezime+"','"+brojTelefona+"',"+nivoSkijanja.getIdNivoSkijanja()+")";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "skijas.idSkijas="+idSkijas;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "ime='"+ime+"',prezime='"+prezime+"',brojTelefona='"+brojTelefona+"',nivoSkijanja="+nivoSkijanja.getIdNivoSkijanja();
    }
    
    
}
