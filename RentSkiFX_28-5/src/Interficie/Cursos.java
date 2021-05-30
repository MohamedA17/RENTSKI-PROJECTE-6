/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

import static interficie.Pantalla.obtenir_connexio_BD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public  class Cursos {
    protected int idCurs;
    protected String nomCurs;
    protected String descripcio;
    protected double preuHora;

    public Cursos(int idCurs, String nomCurs, String descripcio, double preuHora) {
        this.idCurs = idCurs;
        this.nomCurs = nomCurs;
        this.descripcio = descripcio;
        this.preuHora = preuHora;
    }

   public Cursos() {
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
