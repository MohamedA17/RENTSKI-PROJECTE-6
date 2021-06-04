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

    public llogarFamiliar(String carnetFamiliar, int idCurs, String dni, String data, int hores, double preu) {
        super(idCurs, dni, data, hores, preu);
        this.carnetFamiliar = carnetFamiliar;
    }

    public String getCarnetFamiliar() {
        return carnetFamiliar;
    }

    public void setCarnetFamiliar(String carnetFamiliar) {
        this.carnetFamiliar = carnetFamiliar;
    }
    
    public llogarFamiliar (){
    
    }
    
    public void descompteFF(int hores, double preu){
        llogarCursos ll = new llogarFamiliar();
        llogarFamiliar lo = (llogarFamiliar) ll;
        double preufi = ll.getPreu();
        
        double preuFami = (preufi*40) / 100;
        
        double preuSi = preuFami + preufi;
        lo.setPreu(preuSi);
        
        
    }

    @Override
    public String toString() {
        return "llogarFamiliar{" + "carnetFamiliar=" + carnetFamiliar + '}';
    }

    private void setPreu(double preuFami) {

    }

    
}
