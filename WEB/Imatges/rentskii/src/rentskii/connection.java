/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentskii;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dam12021
 */
public class connection {
    static Scanner teclat = new Scanner (System.in);
    
    public static Connection obtenir_connexio_BD() {
        
        Connection conn = null;
        String servidor = "jdbc:mysql://localhost:3306/projecte5";
        String bbdd = "";
        String user = "root";
        String password = "";
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn= DriverManager.getConnection(servidor + bbdd, user, password);
        } catch (Exception e){
            e.printStackTrace();
            return conn;
        }
        return conn;
    }
    
        public static boolean insertKits(String selBota, String selEsqui, String selPal){
        Connection conn = obtenir_connexio_BD();

        PreparedStatement ps = null;
        Statement stmtPals = null; 
        try {
            ps = conn.prepareStatement("INSERT INTO kits (idEsqui, idPals, idBotes) VALUES (?, ?, ?)");
            stmtPals = conn.createStatement();
            
            String idEsqui = selEsqui;
            String idPals = selPal;
            String idBota = selBota;            

            ps.setString(1, idEsqui);
            ps.setString(2,idPals);
            ps.setString(3, idBota);
            
            int res = ps.executeUpdate();
            System.out.println("S'ha inserit el kit corectament");
            
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                        
        return true;                
    }
    
    public static boolean getKits(){
        
        Connection conn = obtenir_connexio_BD();
        String conKits = "SELECT * FROM kits";
        
        Statement stmtPals;
        ResultSet rs;
        try {
            stmtPals = conn.createStatement();
            rs = stmtPals.executeQuery(conKits);
            while (rs.next()){
                
 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                        
        return true;                
    }
    
    public static boolean getPals(Pal[] pals){
        
        Connection conn = obtenir_connexio_BD();
        String conPals = "SELECT * FROM pals";
        
        Statement stmtPals;
        ResultSet cs;
        try {
            stmtPals = conn.createStatement();
            cs = stmtPals.executeQuery(conPals);
            
            int i = 0;
            while(cs.next()){
                Pal pal = new Pal();
                pal.setIdPals(cs.getString("idPals"));
                pal.setMarcaPals(cs.getString("marca"));
                pal.setTallaPals(cs.getString("talla"));
                pal.setPreuPals(cs.getDouble("preu"));

                pals[i] = pal;
                
                i++;    
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                        
        return true;                
    }
    
    public static boolean getBotes(Bota[] botes){
        
        Connection conn = obtenir_connexio_BD();
        String conBota = "SELECT * FROM botes";
        
        Statement stmtPals;
        ResultSet ts;
        try {
            stmtPals = conn.createStatement();
            ts = stmtPals.executeQuery(conBota);
            
            int i = 0;
            while(ts.next()){
                Bota bota = new Bota();
                bota.setIdBotes(ts.getString("idBotes"));
                bota.setMarcaBotes(ts.getString("marca"));
                bota.setTallaBotes(ts.getString("talla"));
                bota.setPreuBotes(ts.getDouble("preu"));

                botes[i] = bota;
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                        
        return true;                
    }
    
    public static boolean getEsqui(Esqui[] esquis){
        
        Connection conn = obtenir_connexio_BD();
        String conEsqui = "SELECT * FROM esqui";
        
        Statement stmtPals;
        ResultSet ls;
        try {
            stmtPals = conn.createStatement();
            ls = stmtPals.executeQuery(conEsqui);
            
            int i=0;
            while(ls.next()){
                Esqui esqui = new Esqui();
                esqui.setIdEsquis(ls.getString("idEsqui"));
                esqui.setMarcaEsqui(ls.getString("marca"));
                esqui.setTallaEsqui(ls.getString("talla"));
                esqui.setPreuEsqui(ls.getDouble("preu"));

                esquis[i] = esqui;
                
                i++;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                        
        return true;                
    }
}




