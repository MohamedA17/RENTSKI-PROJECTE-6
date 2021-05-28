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
public class llogarFamiliar extends llogarCursos{
   private String carnetFamiliar; 

    public llogarFamiliar(String carnetFamiliar, int idCurs, String DNI, String data, int hores, double preu) {
        super(idCurs, DNI, data, hores, preu);
        this.carnetFamiliar = carnetFamiliar;
    }

    public String getCarnetFamiliar() {
        return carnetFamiliar;
    }

    public void setCarnetFamiliar(String carnetFamiliar) {
        this.carnetFamiliar = carnetFamiliar;
    }
    
}
