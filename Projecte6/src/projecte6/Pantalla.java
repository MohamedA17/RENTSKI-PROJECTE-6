/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte6;

import static projecte6.Connect.obtenir_connexio_BD;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    Label lblIdCurs,lblDNI,lblData,lblProva,lblHores;
    TextField txtIdCurs,txtDNI,txtData,txtHores;
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
        //ON ACTION INSCRIURE
       btnInscriure.setOnAction(e -> {
           llogar();
        });
        
        lblIdCurs = new Label("Id del curs:");
        lblIdCurs.setTranslateX(50);
        lblIdCurs.setTranslateY(150);
        lblDNI= new Label ("DNI: ");
        lblDNI.setTranslateX(50);
        lblDNI.setTranslateY(220);
        lblData= new Label ("Data Inici:");
        lblData.setTranslateX(50);
        lblData.setTranslateY(200);
        lblProva= new Label ();
        lblProva.setTranslateX(250);
        lblProva.setTranslateY(200);
        lblHores = new Label("Hores");
        lblHores.setTranslateX(300);
        lblHores.setTranslateY(300);
        
        txtIdCurs = new TextField();
        txtIdCurs.setTranslateX(50);
        txtIdCurs.setTranslateY(170);
        txtDNI = new TextField();
        txtDNI.setTranslateX(50);
        txtDNI.setTranslateY(240);
        txtData = new TextField();
        txtData.setTranslateX(50);
        txtData.setTranslateY(210);
        txtHores = new TextField();
        txtHores.setTranslateX(300);
        txtHores.setTranslateY(300);
        
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
        contenedor.getChildren().addAll(btnClients,btnCursos,lblIdCurs,txtIdCurs,txtDNI,lblData,txtData,
                lblDNI,btnInscriure,chk2,chk3,chk4,chk6,lblProva,lblHores,txtHores);
        
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
    
    
    public void llogar() {
     //   llogarCursos vectod = new llogarCursos();
        Connect conGet = new Connect();
        String IDTriat = txtIdCurs.getText();
        String DNITriat = txtDNI.getText();
        
        conGet.getCurs(IDTriat);
        conGet.getClient(DNITriat);
        conGet.getNivell();
        
        int NivellF = conGet.NivellF;
        int NFederacio = conGet.NFederacio;
        String Carnet = conGet.Carnet;
        String Denei = conGet.DNI;
        int ideCurs = conGet.IDCurs;
        String tipus = conGet.Tipus;
        String si = Integer.toString(ideCurs);
        
            if(IDTriat.equals(si) && DNITriat.equals(Denei)){
            
              /*  Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("RENTSKI");
                alert.setHeaderText("¡CURS LLOGAT CORRECTAMENT!");
                alert.setContentText("Felicitats! El curs s'ha llogat correctament");

                alert.showAndWait();*/
  
                if(NivellF != 0){
                    //NIVELL FEDERACIO NOT NULL
                  if(NivellF <= NFederacio){
                      System.out.println("pots fer el curs");

    
                  }else{
                      System.out.println("No pots fer el curs");
                  }
    
                }else if(Carnet != null){
                    //VALIDACIONS CARNET I REDUCCIO
                    System.out.println("a");
                }else if("General".equals(tipus)){
                    System.out.println("sia");
                }else{
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("RENTSKI");
                    alert.setHeaderText("ADVERTENCIA!!");
                    alert.setContentText("No s'ha pogut llogar el curs");

                alert.showAndWait();
                    System.out.println("no ce puede");
                }
                
               // break;
               
            }else{
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("RENTSKI");
                    alert.setHeaderText("ADVERTENCIA!!");
                    alert.setContentText("No existeix aquest curs o persona");

                alert.showAndWait();
                
            }
         
    } 
    
    public void descompte() {
        Connect conGet = new Connect();
        Connection conn= obtenir_connexio_BD();
        
        String ide = txtIdCurs.getText();
        String variable = txtHores.getText();
        conGet.getCurs(ide);
        int numero = Integer.parseInt(variable);
        Double Preu = conGet.preu;
        
        
        double resultat = Preu*numero;
        
      if(numero <= 2){
         // 20%
         
        Double preuFinal = resultat - 20;
    
      }else if(numero >=3 && numero <=5){
          // 30%
       Double preuFinal = resultat - 30;
          
      }else if (numero >= 6){
          // 50 %
       Double preuFinal = resultat - 50;   
          
      }
                
       
        
    }
    
    public void validarLloguer(){
        Connect conGet = new Connect();
        String IDTriat = txtIdCurs.getText();
        String DNITriat = txtDNI.getText();
        if(IDTriat.equals(conGet.IDCurs) && DNITriat.equals(conGet.DNI)){
            
              /*  Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("RENTSKI");
                alert.setHeaderText("¡CURS LLOGAT CORRECTAMENT!");
                alert.setContentText("Felicitats! El curs s'ha llogat correctament");

                alert.showAndWait();*/
  
                if(conGet.NivellF  != 0){
                    //NIVELL FEDERACIO NOT NULL
                    System.out.println("A");
                
                    
                  if(conGet.NivellF <= conGet.NFederacio){
                      System.out.println("pots fer el curs");
    
                  }else{
                      System.out.println("No pots fer el curs");
                  }
    
                }else if(conGet.Carnet != null){
                    //VALIDACIONS CARNET I REDUCCIO
                    
                }else if("general".equals(conGet.Tipus)){
                    System.out.println("si");
                }else{
                    System.out.println("");
                }
        
    }

  
    }
}
