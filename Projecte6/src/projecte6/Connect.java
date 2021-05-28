/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte6;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author DAM
 */
public class Connect {

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
    
    int IDCurs = 0;
    String Tipus = null;
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
                    
                }
            } catch (SQLException ex) {
                     java.util.logging.Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    String DNI = null;
    int NivellF = 0;
    String Carnet = null;
    public void getClient(String DNITriat){
        Connection conn = obtenir_connexio_BD();

        String conCurs = "SELECT * from persones WHERE DNI = '"+DNITriat+"'";

        Statement stmtCurs;
        ResultSet rs;

        try {
            stmtCurs = conn.createStatement();
            rs = stmtCurs.executeQuery(conCurs);
                
            while (rs.next()){
                DNI = rs.getString("DNI");
                NivellF = rs.getInt("nivellFederacio");
                Carnet = rs.getString("numCarnet");
                    
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    int NFederacio = 0;
    public void getNivell(){
        Connection conn = obtenir_connexio_BD();

        String conCurs = "SELECT * from competicio WHERE nivellFederacioC ='"+NivellF+"'";

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
    
    Double preu = 0.0;
    public void getPreu(String ide){
        Connection conn = obtenir_connexio_BD();

        String conPreu = "SELECT preuHora from cursos WHERE idCurs = '"+ide+"'";

        Statement stmtPreu;
        ResultSet rs;

        try {
            stmtPreu = conn.createStatement();
            rs = stmtPreu.executeQuery(conPreu);
                
            while (rs.next()){
                preu =  rs.getDouble("preuHora");
                    
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
