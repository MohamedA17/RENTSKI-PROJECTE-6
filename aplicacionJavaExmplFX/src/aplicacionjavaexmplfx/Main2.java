/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionjavaexmplfx;
import static aplicacionjavaexmplfx.conexio.obtenir_connexio_BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Dam12021
 */
public class Main2 extends Application {

    /**
     * @param args the command line arguments
     */
    Stage window;
    TableView<Cursos> table;
    
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston - JavaFX");
        
        //Columna Id
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
        
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);
        
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
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
