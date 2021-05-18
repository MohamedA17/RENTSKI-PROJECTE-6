/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentskii;

/**
 *
 * @author DAM
 */
public class Bota {
    private String idBotes;
    private String marcaBotes;
    private String tallaBotes;
    private double preuBotes; 

    public Bota(String idBotes, String marcaBotes, String tallaBotes, double preuBotes) {
        this.idBotes = idBotes;
        this.marcaBotes = marcaBotes;
        this.tallaBotes = tallaBotes;
        this.preuBotes = preuBotes;
    }

    Bota() {
      
    }

    public String getIdBotes() {
        return idBotes;
    }

    public void setIdBotes(String idBotes) {
        this.idBotes = idBotes;
    }

    public String getMarcaBotes() {
        return marcaBotes;
    }

    public void setMarcaBotes(String marcaBotes) {
        this.marcaBotes = marcaBotes;
    }

    public String getTallaBotes() {
        return tallaBotes;
    }

    public void setTallaBotes(String tallaBotes) {
        this.tallaBotes = tallaBotes;
    }

    public double getPreuBotes() {
        return preuBotes;
    }

    public void setPreuBotes(double preuBotes) {
        this.preuBotes = preuBotes;
    }
    
    public String toString(){
        return " IdBotes: " + this.idBotes + " NomBota: " + this.marcaBotes + " TallaBota: " + this.tallaBotes + " PreuBota: " + this.preuBotes;
    }

}
