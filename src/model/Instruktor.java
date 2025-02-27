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
public class Instruktor implements OpstiDomenskiObjekat {
    
    private int idInstruktor;
    private String ime;
    private String prezime;
    private String kontakt;
    private String korisnickoIme;
    private String sifra;

    public Instruktor() {
    }

    public Instruktor(int idInstruktor, String ime, String prezime, String kontakt, String korisnickoIme, String sifra) {
        this.idInstruktor = idInstruktor;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt = kontakt;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public Instruktor(String korisnickoIme, String sifra) {
        this.korisnickoIme=korisnickoIme;
        this.sifra=sifra;
    }
    

    public int getIdInstruktor() {
        return idInstruktor;
    }

    public void setIdInstruktor(int idInstruktor) {
        this.idInstruktor = idInstruktor;
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

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {        
        return ime + " " + prezime;      
    }

    @Override
    public String vratiNazivTabele() {
        
        return "instruktor";

    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int idInstruktor = rs.getInt("instruktor.idInstruktor");
            String ime = rs.getString("instruktor.ime");
            String prezime = rs.getString("instruktor.prezime");
            String kontakt = rs.getString("instruktor.kontakt");
            String korisnickoIme = rs.getString("instruktor.korisnickoIme");
            String sifra = rs.getString("instruktor.sifra");
            Instruktor i = new Instruktor(idInstruktor, ime, prezime, kontakt, korisnickoIme, sifra);
            lista.add(i);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "(ime,prezime,kontakt,korisnickoIme,sifra)";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
            
        return "('"+ime+"','"+prezime+"','"+kontakt+"','"+korisnickoIme+"','"+sifra+"')";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "instruktor.idInstruktor="+idInstruktor;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "ime='"+ime+"',prezime='"+prezime+"',kontakt='"+kontakt+"',korisnickoIme='"+korisnickoIme+"',sifra='"+sifra+"'";
    }
    
    
    
    
}
