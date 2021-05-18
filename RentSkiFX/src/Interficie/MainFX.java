/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

//IMPORTS
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainFX extends Application {

    ModulFX modul;

    public static void main(String[] args) {
        Application.launch(args);

    }

    //INTERFICIE
    Scene escenaPRI;
    BorderPane borderpane;
    Pane menuVBOX, centrePane;
    HBox horitzontalBox;
    Label lblTitol, lblText;
    Button btnLlogarCursos, btnCursosLlogats;



    @Override
    public void start(Stage escenaPRI) {

        //CREEM LA FINESTRA PRINCIPAL QUE SERÀ EL BORDER PANE
        BorderPane border = new BorderPane();
        border.setMinWidth(1200);
        border.setMinHeight(960);
        border.setStyle("-fx-base: #424242");

        Scene escena = new Scene(border);

        //ASSIGNEM UN CONTENEDOR A LA DRETA QUE TINDRÀ ELS BOTONS
        Pane menu = addVBOX();
        border.setLeft(menu);

        //ASSIGNEM EL TITOL EN UN ALTRE PANE
        Pane titolBox = addTitolPane();
        border.setTop(titolBox);

        //ASSIGNEM AL MIG EL CONTINGUT QUE VOLGUEM
        Pane Centre = addCentre();
        border.setCenter(Centre);

        //ASSIGNEM A LA PART POSTERIOR EL CONTENIDOR CORRESPONENT
        Pane Baix = Baix();
        border.setBottom(Baix);

        escenaPRI.setTitle("RentSki");

        escenaPRI.setScene(escena);
       

        escenaPRI.show();

    }

    public Pane addVBOX() {

        Button btnLlogarCursos = new Button("Llogar cursos");
        Label lblText = new Label();
        lblText.setTranslateX(20);
        lblText.setTranslateY(200);
        btnLlogarCursos.setOnAction(event -> lblText.setText("Has clicat a llogar cursos"));

        btnLlogarCursos.setTranslateX(20);
        btnLlogarCursos.setTranslateY(60);

        Pane menu = new Pane();
        menu.setMinWidth(40);
        menu.setTranslateY(100);

        menu.getChildren().addAll(btnLlogarCursos, lblText);

        return menu;
    }

    public Pane addTitolPane() {
        Pane titolBox = new Pane();
        Label lblTitol = new Label("RentSki");
        lblTitol.setTranslateX(565);
        lblTitol.setTranslateY(50);
        lblTitol.setScaleX(5);
        lblTitol.setScaleY(5);

        titolBox.getChildren().addAll(lblTitol);
        return titolBox;
    }

    public Pane addCentre() {
        Pane Centre = new Pane();
        Button btnCursosLlogats = new Button("Mostrar els cursos llogats");
        Label lblShowCursos = new Label();
        lblShowCursos.setTranslateX(100);
        lblShowCursos.setTranslateY(480);
        btnCursosLlogats.setOnAction(event -> lblShowCursos.setText("EN UN MOMENT TINDREM ELS CURSOS QUE S'HAN LLOGAT AVUI"));
        btnCursosLlogats.setTranslateX(400);
        btnCursosLlogats.setTranslateY(160);

        Centre.getChildren().addAll(btnCursosLlogats, lblShowCursos);
        return Centre;
    }

    public Pane Baix() {
        Pane Baix = new Pane();
        Button btnTancar = new Button("Tancar");
        btnTancar.setOnAction(z -> tancar());
        Baix.getChildren().addAll(btnTancar);
        return Baix;
    }

    public void Seleccionat() {

//        Label lblText = new Label();
//        lblText.setText("FUNCIONAAAAA!!!!!");
    }

    private void tancar() {

    }

    private void showCursos() {
        Label lblShowCursos = new Label();

    }
    


}
