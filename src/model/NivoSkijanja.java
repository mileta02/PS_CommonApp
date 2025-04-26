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
    public String toString() {
        return nazivNivoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final NivoSkijanja other = (NivoSkijanja) obj;
        return this.idNivoSkijanja == other.idNivoSkijanja;
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
    public String vratiRazlicitPrimarniKljuc() {
        return "nivoskijanja.idNivoSkijanja!="+idNivoSkijanja;
    }
    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        int idNivoSkijanja = rs.getInt("nivoskijanja.idNivoSkijanja");
        String nazivNivoa = rs.getString("nivoskijanja.nazivNivoa");
        NivoSkijanja ns = new  NivoSkijanja(idNivoSkijanja, nazivNivoa);
        System.out.println(ns);
        return ns;
    }

    @Override
    public String vratiVrednostZaIzmenu() {
                return "nazivNivoa='"+nazivNivoa+"'";
    }

    @Override
    public String vratiFilter(List<Object> parametri) {
        StringBuilder sb = new StringBuilder("1=1");
        if(!nazivNivoa.isEmpty()){
            sb.append(" AND nazivNivoa LIKE ?");
            parametri.add(nazivNivoa+"%");
        }
        return sb.toString();
    }

    @Override
    public String vratiUslovDaPostoji() {
        return "nivoskijanja.nazivNivoa='"+nazivNivoa+"'";
    }
    
}
