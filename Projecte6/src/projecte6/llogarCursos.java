/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte6;

import java.sql.Connection;
import static projecte6.Connect.obtenir_connexio_BD;

/**
 *
 * @author DAM
 */
public abstract class llogarCursos {
    private int idCurs;
    private String dni;
    private String data;
    private int hores;
    private double preu;

    public llogarCursos(int idCurs, String dni, String data, int hores, double preu) {
        this.idCurs = idCurs;
        this.dni = dni;
        this.data = data;
        this.hores = hores;
        this.preu = preu;
    }
    
    public void descompteGeneral(int horas, double preu) {
        Pantalla pantalla = new Pantalla();
        Connect conGet = new Connect();
        
        double resultat = preu*horas;
        double Percentatge20 = (resultat * 20) / 100;
        double Percentatge30 = (resultat * 30) / 100;
        double Percentatge50 = (resultat * 50) / 100;
        
        double preuFinal = 0.0;
            if(horas <= 2){
               // 20%
                preuFinal = resultat - Percentatge20;
            }else if(horas >=3 && horas <=5){
                // 30%
                preuFinal = resultat - Percentatge30;
            }else if (horas >= 6){
                // 50 %
                preuFinal = resultat - Percentatge50;   
            }
            
            this.preu = preuFinal;   
            System.out.println("preuFinal"  +preuFinal);
    }
    
    public void papichulo(){
        
    }

    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String DNI) {
        this.dni = DNI;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }

    public double getPreu() {
        return preu;
    }

    /*public void setPreu(double preu) {
        this.preu = preu;
    }*/
    
    public llogarCursos (){
    
    }
    

    @Override
    public String toString() {
        return "llogarCursos" + "idCurs=" + idCurs + ", DNI=" + dni + ", data=" + data + ", hores=" + hores + ", preu=" + preu ;
    }
    
    
}
