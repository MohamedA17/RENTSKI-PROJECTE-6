/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte6;



public class llogarGeneral extends llogarCursos{
   private double preuFi;
   
   public llogarGeneral(int idCurs, String dni, String data, int hores, double preu) {
        super(idCurs, dni, data, hores, preu);
    }

    public double getPreuFi() {
        return preuFi;
    }

    public void setPreuFi(double preuFi) {
        this.preuFi = preuFi;
    }

    public llogarGeneral() {
    }
}
