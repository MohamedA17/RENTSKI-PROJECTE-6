/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte6;

/**
 *
 * @author dam1m
 */
public class competicio extends Curs{
    private int nivellFederacio;

    public competicio(int idCurs, String nomCurs, String descripcio, double preuHora) {
        super(idCurs, nomCurs, descripcio, preuHora);
    }

    public competicio() {
    }

    public int getNivellFederacio() {
        return nivellFederacio;
    }

    public void setNivellFederacio(int nivellFederacio) {
        this.nivellFederacio = nivellFederacio;
    }
    
}
