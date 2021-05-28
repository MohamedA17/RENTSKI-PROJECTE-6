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
public class Familiar extends Curs{
    private int Reduccio;

    public Familiar(int Reduccio, int idCurs, String nomCurs, String descripcio, double preuHora) {
        super(idCurs, nomCurs, descripcio, preuHora);
        this.Reduccio = Reduccio;
    }

    public int getReduccio() {
        return Reduccio;
    }

    public void setReduccio(int Reduccio) {
        this.Reduccio = Reduccio;
    }
     
}
