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
public class Competicio extends Cursos {
    protected String nivellFederacio;

    public Competicio(String nivellFederacio, int idCurs, String nomCurs, String descripcio, double preuHora) {
        super(idCurs, nomCurs, descripcio, preuHora);
        this.nivellFederacio = nivellFederacio;
    }
    
}