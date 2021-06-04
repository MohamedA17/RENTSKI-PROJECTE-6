/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentskii;

import java.util.Scanner;
import static rentskii.connection.getBotes;
import static rentskii.connection.getEsqui;
import static rentskii.connection.getPals;


public class voidMain {

    private final int TAMANYARRAY=200;
    
    static Scanner teclat = new Scanner (System.in);
    Bota[] botes = new Bota[TAMANYARRAY];
    Pal[] pals = new Pal[TAMANYARRAY];
    Esqui[] esquis = new Esqui[TAMANYARRAY];
    Kit[] kits = new Kit[TAMANYARRAY];
    
    int numKits=0;

    //static Scanner teclat = new Scanner (System.in);

    /**
     * @param args the command line arguments
     */
 
    

    
       private Bota obtenirBota(String idBota){       
            
            for (int i = 0; i < botes.length && botes[i]!= null; i++){
                if (botes[i].getIdBotes()==idBota)
                return botes[i];
            }
        return null;
        }
        
        private Pal obtenirPal (String idPal){
            
            for (int i = 0; i < pals.length && pals[i]!=null;i++){
                if (pals[i] .getIdPals()==idPal)
                    return pals[i];
            }
        return null;            
        }
        
        private Esqui obtenirEsqui (String idEsqui){
            
            for (int i = 0; i < esquis.length && esquis[i]!=null;i++){
                if (esquis[i] .getIdEsquis()==idEsqui)
                    return esquis[i];
            }
        return null;            
        }
        
         public void mostrarBotes (){
            if (getBotes(botes)) {
                for (int i = 0; i<botes.length && botes[i] != null;i++){
                System.out.println(botes[i]);           
                }                      

            }    
        }
        
        public  void mostrarEsquis (){
            if (getEsqui(esquis)) {
                for (int i = 0; i<esquis.length && esquis[i] != null;i++){
                System.out.println(esquis[i]);           
                }                       

            }    
        }
        
        public void mostrarPals (){
            if (getPals(pals)) {
                for (int i = 0; i<pals.length && pals[i] != null;i++){
                System.out.println(pals[i]);           
                }                       
                
            }    
        }
        
}