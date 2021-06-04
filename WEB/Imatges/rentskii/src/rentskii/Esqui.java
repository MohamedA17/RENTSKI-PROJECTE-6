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
public class Esqui {
    private String idEsquis;
    private String marcaEsqui;
    private String tallaEsqui;
    private double preuEsqui;       

    public Esqui(String idEsquis, String marcaEsqui, String tallaEsqui, double preuEsqui) {
        this.idEsquis = idEsquis;
        this.marcaEsqui = marcaEsqui;
        this.tallaEsqui = tallaEsqui;
        this.preuEsqui = preuEsqui;
    }

    Esqui() {
        
    }


    public String getIdEsquis() {
        return idEsquis;
    }

    public void setIdEsquis(String idEsquis) {
        this.idEsquis = idEsquis;
    }

    public String getMarcaEsqui() {
        return marcaEsqui;
    }

    public void setMarcaEsqui(String marcaEsqui) {
        this.marcaEsqui = marcaEsqui;
    }

    public String getTallaEsqui() {
        return tallaEsqui;
    }

    public void setTallaEsqui(String tallaEsqui) {
        this.tallaEsqui = tallaEsqui;
    }

    public double getPreuEsqui() {
        return preuEsqui;
    }

    public void setPreuEsqui(double preuEsqui) {
        this.preuEsqui = preuEsqui;
    }

    public String toString(){
        return " IdEsqui: " + this.idEsquis + " NomEsqui: " + this.marcaEsqui + " TallaEsqui: " + this.tallaEsqui + " PreuEsqui: " + this.preuEsqui;
    }
    
}

    
