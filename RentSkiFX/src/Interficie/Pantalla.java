/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte6;

import static projecte6.connexio.obtenir_connexio_BD;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.awt.*;
import java.awt.event.*;
import com.sun.java.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.CheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DAM
 */
public class Pantalla extends Application {
     
    
    Scene miEscena;
    Pane contenedor;
    Button btnClients,btnCursos,btnInscriure;
    Label lblIdCurs,lblDNI;
    TextField txtIdCurs,txtDNI;
    CheckBox chk2,chk3,chk4,chk6;
   
    
    
    public static void main(String[] args){
        Application.launch(args);
        
        
        
    }
    
    @Override
    public void start(Stage miEscenario){
        btnClients = new Button ("Clients");
        btnClients.setTranslateX(100);
        btnClients.setTranslateY(20);
        btnClients.setMinWidth(100);
        
        btnInscriure = new Button ("Inscriure");
        btnInscriure.setTranslateX(50);
        btnInscriure.setTranslateY(310);
        
        
        
       //ON ACTION clients
       btnClients.setOnAction(e -> {
            try {
                TaulaClients();
            } catch (SQLException ex) {
                Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        btnCursos = new Button ("Cursos");
        btnCursos.setTranslateX(400);
        btnCursos.setTranslateY(20);
        btnCursos.setMinWidth(100);
        
        //ON ACTION cursos
        btnCursos.setOnAction(e -> {
            try {
                TaulaCursos();
            } catch (SQLException ex) {
                Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        lblIdCurs = new Label("Id del curs:");
        lblIdCurs.setTranslateX(50);
        lblIdCurs.setTranslateY(150);
        lblDNI= new Label ("DNI: ");
        lblDNI.setTranslateX(50);
        lblDNI.setTranslateY(220);
        
        txtIdCurs = new TextField();
        txtIdCurs.setTranslateX(50);
        txtIdCurs.setTranslateY(170);
        txtDNI = new TextField();
        txtDNI.setTranslateX(50);
        txtDNI.setTranslateY(240);
        
        
        chk2 = new CheckBox("2h");
        chk2.setTranslateX(50);
        chk2.setTranslateY(280);
        chk3 = new CheckBox("3h");
        chk3.setTranslateX(100);
        chk3.setTranslateY(280);
        chk4 = new CheckBox("4h");
        chk4.setTranslateX(150);
        chk4.setTranslateY(280);
        chk6 = new CheckBox("6h");
        chk6.setTranslateX(200);
        chk6.setTranslateY(280);
 
        
        
        Pane contenedor = new Pane ();
        contenedor.getChildren().addAll(btnClients,btnCursos,lblIdCurs,txtIdCurs,txtDNI,
                lblDNI,btnInscriure,chk2,chk3,chk4,chk6);
        
        miEscena = new Scene (contenedor);
        miEscenario.setTitle("Rentski");
        miEscenario.setMinWidth(800);
        miEscenario.setHeight(400);
        miEscenario.setScene(miEscena);
        
        miEscenario.show();
        
    }
    
    public void TaulaClients() throws SQLException{
        
         
        
        Connection conn= obtenir_connexio_BD();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from persones;");
       /*
        String [] cabezera = {"Nom","Cognom","DNI"};
        String [][] datos = {
            
            {"Velizar","Miroslavov","x8922312"},
            {"Velizar","Miroslavov","x8922312"},
            {"Velizar","Miroslavov","x8922312"},
            {"Velizar","Miroslavov","x8922312"},
            {"Velizar","Miroslavov","x8922312"},
            
        };     */   
       
       
       
    
        DefaultTableModel mod = new DefaultTableModel();
        
        JTable tabla = new JTable(mod);
        
        mod.addColumn("DNI");
        mod.addColumn("nom");
        mod.addColumn("cognom");
        mod.addColumn("correu");
        mod.addColumn("numCarnet");
        mod.addColumn("numFederacio");
        mod.addColumn("nivellFederacio");
       
        
        
        while(rs.next()){
            Object [] fila = new Object[4];
            for ( int i = 0; i<3;i++){
                fila[i] = rs.getObject(i+1);
                
                
            }
               mod.addRow(fila); 
        }
        
        
        
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40,40,400,200);
        
        JFrame ventana = new JFrame();
        ventana.setLayout(null);
        ventana.setSize(500,500);
        ventana.setLocationRelativeTo(null);
      //  ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana.add(scroll);
        
        ventana.setVisible(true);
        
        
        
    }
    
    public void TaulaCursos() throws SQLException{
        Connection conn= obtenir_connexio_BD();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from cursos;");
        
     /*   String [] cabezera = {"idCurs","nomCurs","descripcio","preuHora"};
        String [][] datos = {
            
            {"1","curs1","primer curs","20"},
            {"2","curs2","segon curs","18"},
            {"3","curs3","tercer curs","23"},
            {"4","curs4","quart curs","35"},
            {"5","curs5","cinque curs","15"},
            
        };       */
     
     
    
        DefaultTableModel mod = new DefaultTableModel();
        
        JTable tabla = new JTable(mod);
        mod.addColumn("idCurs");
        mod.addColumn("nomCurs");
        mod.addColumn("descripcio");
        mod.addColumn("preuHora");
        
        while(rs.next()){
            Object [] fila = new Object[4];
            for ( int i = 0; i<4;i++){
                fila[i] = rs.getObject(i+1);
                
                
            }
               mod.addRow(fila); 
        }
        
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40,40,400,200);
        
        JFrame ventana = new JFrame();
        ventana.setLayout(null);
        ventana.setSize(500,500);
        ventana.setLocationRelativeTo(null);
      //  ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana.add(scroll);
        
        ventana.setVisible(true);
    }
    
    
    public void llogar(){
        
    }
    
    

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

  
    
}
