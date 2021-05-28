/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte6;

/**
 *
 * @author DAM
 */
public abstract class llogarCursos {
    private int idCurs;
    private String DNI;
    private String data;
    private int hores;
    private double preu;

    public llogarCursos(int idCurs, String DNI, String data, int hores, double preu) {
        this.idCurs = idCurs;
        this.DNI = DNI;
        this.data = data;
        this.hores = hores;
        this.preu = preu;
    }

    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public void setPreu(double preu) {
        this.preu = preu;
    }
    
}
