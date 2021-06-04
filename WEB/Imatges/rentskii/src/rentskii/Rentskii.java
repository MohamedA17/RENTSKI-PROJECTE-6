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
import static rentskii.connection.insertKits;


/**
 *
 * @author DAM
 */
public class Rentskii {
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
 
       
        
        

    public static void main(String[] args) {
        voidMain metodes = new voidMain();
        connection con = new connection();
        
        
        // TODO code application logic here
        boolean sortir = false;
        int opcio;
                
        while(!sortir){
        	
            System.out.println("\n\n");
            //System.out.println("");
            System.out.println("Llogar kit d'Esqui");
            System.out.println("1. Llogar kit d'Esqui");
            System.out.println("2. Consultar kits");          
            System.out.println("3. Consultar el kit més econòmic");
            System.out.println("4. Consultar numero de kits en que ha estat llogat un material determinat");
            System.out.println("5. Sortir");
            if (!teclat.hasNextInt()) {
            	System.out.println("Has d'introduir un numero com a opcio");
            	teclat.next();
            } else {            
                opcio=teclat.nextInt();
                
                switch (opcio) {
                    case 1:
                        System.out.println("Has seleccionat llogar Kits");
                        metodes.mostrarBotes();
                        System.out.println("Selecciona Botes: ");
                        String selBota = teclat.next(); 
                                           
                        metodes.mostrarEsquis();
                        System.out.println("Selecciona Esquis: ");
                        String selEsqui = teclat.next();

                        metodes.mostrarPals();
                        System.out.println("Selecciona Pals: ");
                        String selPal = teclat.next();
                                                                       
                        if (!insertKits(selBota, selEsqui, selPal)){
                            System.out.println("Error manito");
                        }

                        
                        

                        
                    	break;
                    	 
                    case 2:
                        
                        break;
                         
                    case 3:
 
                        break;
                        
                    case 4:
                        
                        break;
                        
                    case 5:
                        System.out.println("Has seleccionat sortir");
                        sortir=true;
                    
                    default:
                        System.out.println("Sol nomeros entre 1 i 4");                             
                }
            }  
        }
    }
        
 
               
}    

