/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interficie;

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Interficie.Cursos;

/**
 *
 * @author DAM
 */
public class Pantalla extends Application {

    Scene miEscena;
    Pane contenedor;
    HBox HBoxMENU;
    Button btnCursosLlogats, btnClients, btnCursos, btnInscriure;
    Label lblIdCurs, lblDNI, lblHores, lblDataInici;
    TextField txtIdCurs, txtDNI, txtHores, txtDataInici;
    RadioButton rb2, rb3, rb4, rb6;
    TableView<Cursos> table;

    public static void main(String[] args) {
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

        //ON ACTION clients
        btnClients.setOnAction(e -> {
            try {
                TaulaClients();
            } catch (SQLException ex) {
                System.out.println("ERROR: QUELCOM ERROR S'HA PRODUIT EN RELACIO A LA BASE DE DADES");;
            }
        });

        btnCursosLlogats = new Button("Cursos Llogats");
        btnCursosLlogats.setTranslateX(300);
        btnCursosLlogats.setTranslateY(20);
        btnCursosLlogats.setMinWidth(100);

        HBoxMENU.getChildren().addAll(btnClients, btnCursosLlogats);
        HBoxMENU.setTranslateY(150);
        HBoxMENU.setTranslateX(550);

        //ON ACTION cursos
        btnCursosLlogats.setOnAction(e -> {
            try {
                TaulaCursos();
            } catch (SQLException ex) {
                System.out.println("No s'ha pogut fer la consulta");
            }
        });
        
        
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

       
        inscripcio.getChildren().addAll(lblDNI, lblIdCurs, lblHores, lblDataInici, txtDNI, txtIdCurs, txtHores, txtDataInici, btnInscriure);
        inscripcio.setTranslateY(100);

        Pane contenedor = new Pane();

        //TAULA CURSOS DE LA BASE DE DADES
        
        TableColumn<Cursos, Integer> idColumn = new TableColumn<>("IdCurs");
        idColumn.setMinWidth(200);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idCurs"));

        TableColumn<Cursos, String> nomColumn = new TableColumn<>("NomCurs");
        nomColumn.setMinWidth(200);
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nomCurs"));

        TableColumn<Cursos, String> descripcioColumn = new TableColumn<>("Descripcio");
        descripcioColumn.setMinWidth(200);
        descripcioColumn.setCellValueFactory(new PropertyValueFactory<>("descripcio"));

        TableColumn<Cursos, Double> preuColumn = new TableColumn<>("PreuHora");
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

    public void TaulaClients() throws SQLException {

        Connection conn = obtenir_connexio_BD();
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

        while (rs.next()) {
            Object[] fila = new Object[4];
            for (int i = 0; i < 3; i++) {
                fila[i] = rs.getObject(i + 1);

            }
            mod.addRow(fila);
        }

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 40, 400, 200);

        JFrame ventana = new JFrame();
        ventana.setLayout(null);
        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
        //  ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.add(scroll);

        ventana.setVisible(true);

    }

    public void TaulaCursos() throws SQLException {
        Connection conn = obtenir_connexio_BD();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from cursos;");

        DefaultTableModel mod = new DefaultTableModel();

        JTable tabla = new JTable(mod);
        mod.addColumn("idCurs");
        mod.addColumn("nomCurs");
        mod.addColumn("descripcio");
        mod.addColumn("preuHora");

        while (rs.next()) {
            Object[] fila = new Object[4];
            for (int i = 0; i < 4; i++) {
                fila[i] = rs.getObject(i + 1);

            }
            mod.addRow(fila);
        }

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 40, 400, 200);

        JFrame ventana = new JFrame();
        ventana.setLayout(null);
        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
        //  ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.add(scroll);

        ventana.setVisible(true);
    }

    public void llogar() {

    }

    public static Connection obtenir_connexio_BD() {

        Connection conn = null;
        String servidor = "jdbc:mysql://localhost:3306/projecte6";
        String bbdd = "";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecte6", "root", "root");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("NO S'HA POGUT COMPLETAR L'ACCIO.\n SEMBLA SER UN ERROR RELACIONAT EN LA BASE DE DADES");
            return conn;
        }
        return conn;
    }

    public ObservableList<Cursos> getCursos() {
        Connection conn = obtenir_connexio_BD();

        ObservableList<Cursos> list = FXCollections.observableArrayList();
        Statement stmtCursos;
        ResultSet rs;
        try {
            String sql = "select * from cursos";
            stmtCursos = conn.createStatement();
            rs = stmtCursos.executeQuery(sql);
            while (rs.next()) {
                Cursos cursos = new Cursos();
                cursos.setIdCurs(rs.getInt("idCurs"));
                cursos.setNomCurs(rs.getString("nomCurs"));
                cursos.setDescripcio(rs.getString("descripcio"));
                cursos.setPreuHora(rs.getDouble("preuHora"));

                list.add(cursos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
