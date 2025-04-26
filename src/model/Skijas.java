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
    public String toString() {
        return idSkijas+" "+ime+" "+prezime;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Skijas other = (Skijas) obj;
        return this.idSkijas == other.idSkijas;
    }
    
    

    @Override
    public String vratiNazivTabele() {
        return "skijas";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> list = new ArrayList<>();
        while(rs.next()){
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String brojTelefona = rs.getString("brojTelefona");
            int id = rs.getInt("idSkijas");
            Skijas s = new Skijas(idSkijas, ime, prezime, brojTelefona, nivoSkijanja);
        }
        return list;
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
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String brojTelefona = rs.getString("brojTelefona");
            int id = rs.getInt("idSkijas");            
            return new Skijas(id, ime, prezime, brojTelefona, nivoSkijanja);
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "ime='"+ime+"',prezime='"+prezime+"',brojTelefona='"+brojTelefona+"',nivoSkijanja="+nivoSkijanja.getIdNivoSkijanja();
    }

    @Override
    public String vratiFilter(List<Object> parametri) {
        StringBuilder sb  = new StringBuilder("1=1");
        if(!ime.isEmpty()){
            sb.append(" AND ime like ?");
            parametri.add(ime+"%");
        }
        if(!prezime.isEmpty()){
            sb.append(" AND prezime like ?");
            parametri.add(prezime+"%");
        }
        if(nivoSkijanja!=null){
            sb.append(" AND nazivNivoa like ?");
            parametri.add(nivoSkijanja.getNazivNivoa());
        }
        return sb.toString();
    }

    @Override
    public String vratiUslovDaPostoji() {
        return "skijas.ime='"+ime+"' AND skijas.prezime='"+prezime+"' AND skijas.brojTelefona='"+brojTelefona+"'";
    }

    @Override
    public String vratiRazlicitPrimarniKljuc() {
        return "skijas.idSkijas!="+idSkijas;
    }
    
    
}
