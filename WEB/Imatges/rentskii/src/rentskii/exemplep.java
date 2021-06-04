/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentskii;

import java.sql.Connection;
import java.util.Scanner;
import static rentskii.connection.getBotes;
import static rentskii.connection.getEsqui;
import static rentskii.connection.obtenir_connexio_BD;

/**
 *
 * @author Dam12021
 */
public class exemplep {

    /**
     * @param args the command line arguments
     */
    private final int TAMANYARRAY=200;
    
    Scanner teclat = new Scanner(System.in);
    Bota[] botes = new Bota[TAMANYARRAY];
    Pal[] pals = new Pal[TAMANYARRAY];
    Esqui[] esquis = new Esqui[TAMANYARRAY];
    Kit[] kits = new Kit[TAMANYARRAY];
    
    int numKits=0;
    
    Connection conn = obtenir_connexio_BD();
        
        
    public void main(String[] args) {
    Esqui esqui = new Esqui();
    
    
        exemplep tenda = new exemplep();
        tenda.llogarKits();
    }
    
    private void llogarKits(){

        if (getBotes(botes)) {
            for (int i = 0; i<botes.length && botes[i] != null;i++){
            System.out.println(botes[i]);
            
            }          
        }        
    }



}

/*int[] aInt = {32,89,11,96,32,12,31,73,83,91};
        
        int[] aInt2;
        
        aInt2 = aInt;
        
        double[] aDouble = {96.96,12.43,34.43,23.04,11.23,23.12,02.32,73.23};
        
        boolean[] aBoolean;
        
        String[] aString={"hola", "que", "si", "para", "tres"};
        
        char[] aChar= {'H', 'o', 'l', 'a'};
        
        Esqui[] aEsqui = new Esqui[4];
        
        //aEsqui[0]=new Esqui();
        
        //Calculem mimin
        int minInt= aInt[0];
        
        //Calculem màxim
        int maxInt = aInt[0];
        
        //Calculem suma
        int sumaInt = 0;
        
        //Calculem producte
        long prodInt=1;
        
        //Calculem num mes
        //int numMas = teclat.nextInt();

        for (int i=0; i < aInt.length; i++){
            //System.out.println("aInt: " +aInt[i]);
            
            if (aInt[i] < minInt) minInt=aInt[i];
            if (aInt[i] > maxInt) maxInt=aInt[i];
            
            System.out.print(" Minim: "+minInt);
            
            System.out.print(" Màxim: "+maxInt);
            
            sumaInt = sumaInt + aInt[i];
            System.out.print(" suma: " +sumaInt);
            
            prodInt=prodInt*aInt[i];
            System.out.println(" producte: "+prodInt);
        }
        
        System.out.println("Minim: "+minInt);
        System.out.println("Màxim: "+maxInt);
        System.out.println("Suma: " +sumaInt);
        System.out.println("Producte: "+prodInt);
        
        
        
        
        System.out.println("Quin numero vols contar: ");
        double num= teclat.nextDouble();
        int cont=0;
        
        //for (int i=0; i < aDouble.length; i++){
        for (int i= aString.length-1; i >=0; i--){
            System.out.print("aDouble["+i+"];" +aDouble[i]);
            
            if (num==aDouble[i]) cont++;
            System.out.println("cont: " +cont);
        }
        
        
        for (int i=0; i < aString.length; i++){
            System.out.println("aString["+i+"]: " + aString[i].toUpperCase());
            
        }
        
        for (int i=0; i < aChar.length; i++){
            System.out.println("aChar["+i+"]: " + aChar[i]);
        }*/
