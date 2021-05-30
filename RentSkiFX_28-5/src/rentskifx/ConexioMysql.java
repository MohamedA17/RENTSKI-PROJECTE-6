/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentskifx;

 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class ConexioMysql {

        // Atributs de la connexió
        private static Connection conn = null;
        private String driver;
        private String url;
        private String usuario;
        private String password;

        // Constructor de la connexió per accedir als mètodes
    public ConexioMysql(){

        String url = "jdbc:mysql://localhost:3306/projecte6";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String password = "root";

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
    }
        // Mètode per realitzar la connexió
        public Connection getConnection(){

            if (conn == null){
                new ConexioMysql();
            }

            return conn;
        } // Fin getConnection
        
        
        public static void getCursos(){
            
            String sentenciaSql = "SELECT * FROM cursos";
            PreparedStatement sentencia = null;
            
        }
    }