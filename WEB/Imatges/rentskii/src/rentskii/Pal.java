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
public class Pal {
    private String idPals;
    private String marcaPals;
    private String tallaPals;
    private double preuPals; 

    public Pal(String idPals, String marcaPals, String tallaPals, double preuPals) {
        this.idPals = idPals;
        this.marcaPals = marcaPals;
        this.tallaPals = tallaPals;
        this.preuPals = preuPals;
    }

    Pal() {
    
    }

    public String getIdPals() {
        return idPals;
    }

    public void setIdPals(String idPals) {
        this.idPals = idPals;
    }

    public String getMarcaPals() {
        return marcaPals;
    }

    public void setMarcaPals(String marcaPals) {
        this.marcaPals = marcaPals;
    }

    public String getTallaPals() {
        return tallaPals;
    }

    public void setTallaPals(String tallaPals) {
        this.tallaPals = tallaPals;
    }

    public double getPreuPals() {
        return preuPals;
    }

    public void setPreuPals(double preuPals) {
        this.preuPals = preuPals;
    }
    
    public String toString(){
        return " IdPals: " + this.idPals + " NomPals: " + this.marcaPals + " TallaPals: " + this.tallaPals + " PreuPals: " + this.preuPals;
    }

}

 