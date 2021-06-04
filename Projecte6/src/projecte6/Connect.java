/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte6;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author DAM
 */
public class Connect {
    public int nivellFederacio;
    public String carnetFederacio;
    public String carnetFF;
    public String DNI;
    public String Tipus;
    public int IDCurs;
    public int NFederacio;
    public double preu;
    
    //Obtenir connexió amb la BD
    public static Connection obtenir_connexio_BD() {
        
        Connection conn = null;
        String servidor = "jdbc:mysql://localhost:3306/projecte6";
        String bbdd = "";
        String user = "root";
        String password = "";

            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/projecte6","root","");
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
                return conn;
            }
            return conn;
    }
    
    //Obtenir els cursos de la BD
    public void getCurs(String IDTriat){
        Connection conn = obtenir_connexio_BD();

        String conCurs = "SELECT * from cursos WHERE idCurs ='"+IDTriat+"'";

        Statement stmtCurs;
        ResultSet rs;

            try {
                stmtCurs = conn.createStatement();
                rs = stmtCurs.executeQuery(conCurs);
                
                while (rs.next()){
                    IDCurs = rs.getInt("idCurs");
                    Tipus = rs.getString("Tipus");
                    preu =  rs.getDouble("preuHora");  
                }
            } catch (SQLException ex) {
                     java.util.logging.Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    //Inserir lloguer a la BD
    public void inserirLloguer(int IdCurs, String DNI, String data, int hores, double preu){
        Connection conn = obtenir_connexio_BD();

        PreparedStatement ps;
        Statement stmtPals; 
        
        try {
            ps = conn.prepareStatement("INSERT INTO lloguer (idCurs, DNI, data, hores, preu) VALUES (?, ?, ?, ?, ?)");
        
            stmtPals = conn.createStatement();
            
            int idCurs = IdCurs;
            String Dni = DNI;
            String Data = data; 
            int Hores = hores;
            double Preu = preu;

            ps.setInt(1, idCurs);
            ps.setString(2, DNI);
            ps.setString(3, Data);
            ps.setInt(4, Hores);
            ps.setDouble(5, Preu);
            
            ps.executeUpdate();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    //Obtenir informació del client
    public void getClient(String DNITriat){
        Pantalla panta = new Pantalla();
        Connection conn = obtenir_connexio_BD();

        String conCurs = "SELECT * from persones WHERE DNI = '"+DNITriat+"'";

        Statement stmtCurs;
        ResultSet rs;

        try {
            stmtCurs = conn.createStatement();
            rs = stmtCurs.executeQuery(conCurs);
  
            while (rs.next()){
                DNI = rs.getString("DNI");
                nivellFederacio = rs.getInt("nivellFederacio");
                carnetFederacio = rs.getString("numFederacio");
                carnetFF = rs.getString("numCarnet");
                    
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Obtenir el nivell del curs
    public void getNivell(){
        Pantalla panta = new Pantalla();
        Connection conn = obtenir_connexio_BD();

        String conCurs = "SELECT * from competicio WHERE idCursC = '"+IDCurs+"'";

        Statement stmtCurs;
        ResultSet rs;

        try {
            stmtCurs = conn.createStatement();
            rs = stmtCurs.executeQuery(conCurs);

            while (rs.next()){
                
                NFederacio = rs.getInt("nivellFederacioC");         
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
   
    
    public int getNivellFederacio() {
        return nivellFederacio;
    }

    public void setNivellFederacio(int nivellFederacio) {
        this.nivellFederacio = nivellFederacio;
    }

    public String getCarnetFederacio() {
        return carnetFederacio;
    }

    public void setCarnetFederacio(String carnetFederacio) {
        this.carnetFederacio = carnetFederacio;
    }

    public String getCarnetFF() {
        return carnetFF;
    }

    public void setCarnetFF(String carnetFF) {
        this.carnetFF = carnetFF;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTipus() {
        return Tipus;
    }

    public void setTipus(String Tipus) {
        this.Tipus = Tipus;
    }

    public int getIDCurs() {
        return IDCurs;
    }

    public void setIDCurs(int IDCurs) {
        this.IDCurs = IDCurs;
    }

    public int getNFederacio() {
        return NFederacio;
    }

    public void setNFederacio(int NFederacio) {
        this.NFederacio = NFederacio;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
    
}
