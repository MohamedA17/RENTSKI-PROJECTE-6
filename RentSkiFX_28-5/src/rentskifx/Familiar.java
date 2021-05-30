/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentskifx;

import Interficie.Cursos;

/**
 *
 * @author paufb
 */
public class Familiar extends Cursos {
    
 protected int reduccio;

    public Familiar(int reduccio, int idCurs, String nomCurs, String descripcio, double preuHora) {
        super(idCurs, nomCurs, descripcio, preuHora);
        this.reduccio = reduccio;
    }

    public int getReduccio() {
        return reduccio;
    }

    public void setReduccio(int reduccio) {
        this.reduccio = reduccio;
    }

    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public String getNomCurs() {
        return nomCurs;
    }

    public void setNomCurs(String nomCurs) {
        this.nomCurs = nomCurs;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public double getPreuHora() {
        return preuHora;
    }

    public void setPreuHora(double preuHora) {
        this.preuHora = preuHora;
    }
 
 
    
}