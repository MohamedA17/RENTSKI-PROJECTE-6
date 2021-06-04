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
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javax.naming.spi.DirStateFactory.Result;
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
    Button btnClients,btnCursos,btnInscriure,btnCursosLlogats;
    Label lblIdCurs,lblDNI,lblDataInici,lblHores;
    TextField txtIdCurs,txtDNI,txtDataInici,txtHores;
    CheckBox chk2,chk3,chk4,chk6;
    TableView<Curs> table;
    TableView<llogarCursos> table2;
   
    
    
    public static void main(String[] args){
        Application.launch(args);
    }
    
    @Override
    public void start(Stage miEscenario) {
        
        //TITOL PROGRAMA

        Pane titolBox = new Pane();
        Label lblTitol = new Label("RentSki");
        lblTitol.setTranslateX(750);
        lblTitol.setTranslateY(50);
        lblTitol.setScaleX(5);
        lblTitol.setScaleY(5);

        titolBox.getChildren().addAll(lblTitol);
        
        //MENÚ DEL PROGRAMA

        HBox HBoxMENU = new HBox();

        btnClients = new Button("Clients");
        btnClients.setTranslateX(100);
        btnClients.setTranslateY(20);
        btnClients.setMinWidth(100);

        btnCursosLlogats = new Button("Cursos Llogats");
        btnCursosLlogats.setTranslateX(300);
        btnCursosLlogats.setTranslateY(20);
        btnCursosLlogats.setMinWidth(100);

        HBoxMENU.getChildren().addAll(btnClients, btnCursosLlogats);
        HBoxMENU.setTranslateY(150);
        HBoxMENU.setTranslateX(550);
        
        
        //LABELS I TEXTFIELDS PER A LLOGAR ELS CURSOS

        Pane inscripcio = new Pane();

        lblDNI = new Label("DNI: ");
        lblDNI.setTranslateX(50);
        lblDNI.setTranslateY(150);

        lblIdCurs = new Label("Id del curs:");
        lblIdCurs.setTranslateX(50);
        lblIdCurs.setTranslateY(220);

        lblHores = new Label("Hores: ");
        lblHores.setTranslateX(50);
        lblHores.setTranslateY(290);

        lblDataInici = new Label("Data d'Inici: ");
        lblDataInici.setTranslateX(50);
        lblDataInici.setTranslateY(360);

        txtDNI = new TextField();
        txtDNI.setTranslateX(50);
        txtDNI.setTranslateY(170);

        txtIdCurs = new TextField();
        txtIdCurs.setTranslateX(50);
        txtIdCurs.setTranslateY(240);

        txtHores = new TextField();
        txtHores.setTranslateX(50);
        txtHores.setTranslateY(310);

        txtDataInici = new TextField();
        txtDataInici.setTranslateX(50);
        txtDataInici.setTranslateY(380);

        btnInscriure = new Button("Inscriure");
        btnInscriure.setTranslateX(50);
        btnInscriure.setTranslateY(500);
        
        //ON ACTION INSCRIURE
        btnInscriure.setOnAction(e -> {
           llogarCurs();
        });
        
        //ON ACTION cursos
        btnCursosLlogats.setOnAction(e -> {
                cursLlog();
        });
        
        //ON ACTION clients
        btnClients.setOnAction(e -> {
            try {
                TaulaClients();
            } catch (SQLException ex) {
                Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        });
        
        //ON ACTION BOTO DE TANCAR
        miEscenario.setOnCloseRequest(event -> {
        });

       
        inscripcio.getChildren().addAll(lblDNI, lblIdCurs, lblHores, lblDataInici, txtDNI, txtIdCurs, txtHores, txtDataInici, btnInscriure);
        inscripcio.setTranslateY(100);

        Pane contenedor = new Pane();

        //TAULA CURSOS DE LA BASE DE DADES
        
        TableColumn<Curs, Integer> idColumn = new TableColumn<>("IdCurs");
        idColumn.setMinWidth(200);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idCurs"));

        TableColumn<Curs, String> nomColumn = new TableColumn<>("NomCurs");
        nomColumn.setMinWidth(200);
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nomCurs"));

        TableColumn<Curs, String> descripcioColumn = new TableColumn<>("Descripcio");
        descripcioColumn.setMinWidth(200);
        descripcioColumn.setCellValueFactory(new PropertyValueFactory<>("descripcio"));

        TableColumn<Curs, Double> preuColumn = new TableColumn<>("PreuHora");
        preuColumn.setMinWidth(200);
        preuColumn.setCellValueFactory(new PropertyValueFactory<>("preuHora"));

        table = new TableView<>();
        table.setItems(getCursos());
        table.getColumns().addAll(idColumn, nomColumn, descripcioColumn, preuColumn);

        Pane paneTaula = new Pane();
        paneTaula.getChildren().addAll(table);
        paneTaula.setTranslateX(500);
        paneTaula.setTranslateY(250);
        
        //MÈTODES PER A AFEGIR TOT EL DE DALT.

        miEscena = new Scene(contenedor);
        miEscenario.setTitle("Rentski");
        miEscenario.setMinWidth(1500);
        miEscenario.setHeight(1000);
        miEscenario.setScene(miEscena);

        contenedor.getChildren().addAll(titolBox, HBoxMENU, inscripcio, paneTaula);
        contenedor.setStyle("-fx-base: #424242");
        miEscenario.show();

    }
    
    
    
    public void llogarCurs() {
        
        Connect conGet = new Connect();
        String IDTriat = txtIdCurs.getText();
        String DNITriat = txtDNI.getText();
        String hores = txtHores.getText();
        String DATA = txtDataInici.getText();
        
        int horas = Integer.parseInt(hores);
        
        conGet.getCurs(IDTriat);
        conGet.getClient(DNITriat);
        conGet.getNivell();
        
        
        //int NivellF = conGet.NivellF;
        int NFederacioS = conGet.NFederacio;
        String Carnet = conGet.carnetFF;
        String carnetFederacio = conGet.carnetFederacio;
        String Denei = conGet.DNI;
        double preuu = conGet.preu;
        int nivellFedeCl = conGet.nivellFederacio;
        int ideCurs = conGet.IDCurs;
        String tipus = conGet.Tipus;
        String IdCurs = Integer.toString(ideCurs);
        
            if(IDTriat.equals(IdCurs) && DNITriat.equals(Denei)){

  
                if(NFederacioS != 0 && nivellFedeCl != 0){
                        //NIVELL FEDERACIO NOT NULL
                    if(NFederacioS <= nivellFedeCl){       
                        System.out.println("pots fer el curs competicio");     
                        llogarCursos llogar = new llogarCompeticio();
                        llogarCompeticio llogarCo = (llogarCompeticio) llogar;
                        llogarCo.setCarnetFederacioC(carnetFederacio);
                        llogarCo.setIdCurs(ideCurs);
                        llogarCo.setDNI(Denei);
                        llogarCo.setData(DATA);
                        llogarCo.setHores(horas);
                        llogarCo.descompteGeneral(horas, preuu);
                        double puede = llogarCo.getPreu();
                        
                        conGet.inserirLloguer(ideCurs, Denei, DATA, horas, puede);
                        
                        System.out.println(llogarCo);
                        
                        txtIdCurs.clear();
                        txtDNI.clear();
                        txtHores.clear();
                        txtDataInici.clear();
                      
                    }else{
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("RENTSKI");
                        alert.setHeaderText("ADVERTENCIA!!");
                        alert.setContentText("Nivell de federació baix");

                        alert.showAndWait();
                        System.out.println("No pots fer el curs");
                    }
    
                }else if(Carnet != null){
                    //VALIDACIONS CARNET I REDUCCIO
                    System.out.println("Pots fer el curs Familiar");
                    llogarCursos llog = new llogarFamiliar();
                    llogarFamiliar llogarFa = (llogarFamiliar) llog;
                    llogarFa.setCarnetFamiliar(Carnet);
                    llogarFa.setIdCurs(ideCurs);
                    llogarFa.setDNI(Denei);
                    llogarFa.setData(DATA);
                    llogarFa.setHores(horas);
                    llogarFa.descompteGeneral(horas, preuu);
                    double puede = llogarFa.getPreu();
                    
                    conGet.inserirLloguer(ideCurs, Denei, DATA, horas, puede);
                        
                        System.out.println(llogarFa);
                        
                        txtIdCurs.clear();
                        txtDNI.clear();
                        txtHores.clear();
                        txtDataInici.clear();
                    
                    
                }else if("General".equals(tipus)){                   
                    System.out.println("sia");
                    
                    llogarCursos lloga = new llogarGeneral();
                    llogarGeneral llogarGe = (llogarGeneral) lloga;
                    llogarGe.setIdCurs(ideCurs);
                    llogarGe.setDNI(Denei);
                    llogarGe.setData(DATA);
                    llogarGe.setHores(horas);
                    llogarGe.descompteGeneral(horas, preuu);
                    double puede = llogarGe.getPreu();
                    
                    conGet.inserirLloguer(ideCurs, Denei, DATA, horas, puede);
                        
                        System.out.println(llogarGe);
                        
                        txtIdCurs.clear();
                        txtDNI.clear();
                        txtHores.clear();
                        txtDataInici.clear();
                         
                }else{
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("RENTSKI");
                    alert.setHeaderText("ADVERTENCIA!!");
                    alert.setContentText("No s'ha pogut llogar el curs");

                alert.showAndWait();
                    System.out.println("no es pot");
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
    
    //Taula cursos
    public void cursLlog() {
        ObservableList<llogarGeneral> list = FXCollections.observableArrayList();       
        
        Connection conn = obtenir_connexio_BD();

        String sql = "select * from lloguer";
        
        Statement stmtCursos;
        ResultSet rs;
        
        DefaultTableModel mod = new DefaultTableModel();
        JTable tabla = new JTable(mod);
        mod.addColumn("ID Curs");
        mod.addColumn("DNI");
        mod.addColumn("DATA");
        mod.addColumn("HORES");
        mod.addColumn("PREU");
            try {
                stmtCursos = conn.createStatement();
                rs = stmtCursos.executeQuery(sql);
                while (rs.next()) {
                    llogarGeneral llogGe = new llogarGeneral();
                    /*llogarGeneral llogGe = new llogarGeneral();
                    llogGe.setIdCurs(rs.getInt("idCurs"));
                    llogGe.setDNI(rs.getString("DNI"));
                    llogGe.setData(rs.getString("data"));
                    llogGe.setHores(rs.getInt("hores"));
                    llogGe.setPreuFi(rs.getDouble("preu"));
    
                    list.add(llogGe);
*/
                Object [] fila = new Object[5];
                    for ( int i = 0; i<5;i++){
                        fila[i] = rs.getObject(i+1);        
                    }
               mod.addRow(fila);
               list.add(llogGe);
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
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
    
    //Mostrar cursos llogats
    public ObservableList<Curs> mostrarLlog(){
        ObservableList<Curs> list = FXCollections.observableArrayList();
        
        DefaultTableModel mod = new DefaultTableModel();
        JTable tabla = new JTable(mod);
        
        mod.addColumn("ID Curs");
        mod.addColumn("DNI");
        mod.addColumn("DATA");
        mod.addColumn("HORES");
        mod.addColumn("PREU");
        
        llogarCompeticio lliog = new llogarCompeticio();
        while(0 == 0){
            int ide = lliog.getIdCurs();
            String llio = lliog.getDNI();
            String lli = lliog.getData();
            int lliodd = lliog.getHores();
            Double lliosd = lliog.getPreu();
            
            
            mod.addRow(list);
               list.add(lliog);
        }
        
        
    }
    
    public ObservableList<llogarCursos> getMostrarLlog(){
        ObservableList<llogarCursos> list = FXCollections.observableArrayList();
        llogarFamiliar cf = (llogarFamiliar) llogarCursos;
        llogarCompeticio cc = (llogarCompeticio) llogarCursos;
        
        list.add(cf);
        list.add(cc);
        
        return list;
    }
    
    //Taula cursos
    public ObservableList<Curs> getCursos() {
        ObservableList<Curs> list = FXCollections.observableArrayList();
        
        Connection conn = obtenir_connexio_BD();

        String sql = "select * from cursos";
        
        Statement stmtCursos;
        ResultSet rs;
            try {
                stmtCursos = conn.createStatement();
                rs = stmtCursos.executeQuery(sql);
                while (rs.next()) {
                    Curs curs = new Curs();
                    curs.setIdCurs(rs.getInt("idCurs"));
                    curs.setNomCurs(rs.getString("nomCurs"));
                    curs.setDescripcio(rs.getString("Tipus"));
                    curs.setPreuHora(rs.getDouble("preuHora"));

                    list.add(curs);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
    }
    
    //Taula clients
    public void TaulaClients() throws SQLException {
        Connection conn= obtenir_connexio_BD();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from persones;");
        
 
        DefaultTableModel mod = new DefaultTableModel();
        
        JTable tabla = new JTable(mod);
        mod.addColumn("DNI");
        mod.addColumn("nom");
        mod.addColumn("cognom");
        mod.addColumn("Carnet Familiar");
        mod.addColumn("Carnet Federacio");
        
        while(rs.next()){

            Object [] fila = new Object[5];
            for ( int i = 0; i<5;i++){
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
}
