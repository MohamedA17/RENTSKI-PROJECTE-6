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
public class llogarCompeticio extends llogarCursos{
    private String carnetFederacioC;

    public llogarCompeticio(String carnetFederacioC, int idCurs, String dni, String data, int hores, double preu) {
        super(idCurs, dni, data, hores, preu);
        this.carnetFederacioC = carnetFederacioC;
    }

    llogarCompeticio() {

    }

    public String getCarnetFederacioC() {
        return carnetFederacioC;
    }

    public void setCarnetFederacioC(String carnetFederacioC) {
        this.carnetFederacioC = carnetFederacioC;
    }

    
    @Override
    public String toString() {
        return "llogarCompeticio" + "carnetFederacioC=" + carnetFederacioC;
    }
    
}
