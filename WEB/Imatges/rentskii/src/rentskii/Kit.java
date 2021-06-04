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
public class Kit {
    private int idKit;
    private Pal pal;
    private Esqui esqui;
    private Bota bota; 
    
    private double preuKit;

    public Kit(int idKit, Pal pal, Esqui esqui, Bota bota, double preuKit) {
        this.idKit = idKit;
        this.pal = pal;
        this.esqui = esqui;
        this.bota = bota;
        this.preuKit = pal.getPreuPals() + bota.getPreuBotes() + esqui.getPreuEsqui();
    }

    Kit() {

    }

    public int getIdKit() {
        return idKit;
    }

    public void setIdKit(int idKit) {
        this.idKit = idKit;
    }

    public Pal getPal() {
        return pal;
    }

    public void setPal(Pal pal) {
        this.pal = pal;
    }

    public Esqui getEsqui() {
        return esqui;
    }

    public void setEsqui(Esqui esqui) {
        this.esqui = esqui;
    }

    public Bota getBota() {
        return bota;
    }

    public void setBota(Bota bota) {
        this.bota = bota;
    }

    public double getPreuKit() {
        return preuKit;
    }

    public void setPreuKit(double preuKit) {
        this.preuKit = this.esqui.getPreuEsqui() + this.bota.getPreuBotes() + this.pal.getPreuPals();
    }
    
    public String toString(){
        return " IdKit: " + this.idKit + " preuKit: " + this.preuKit + " " + this.bota + " " + this.pal + "" + this.esqui;
    }    
            
}
