/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionjavaexmplfx;

/**
 *
 * @author Dam12021
 */
//Realizanod los import necessarios
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class AplicacionJavaExmplFX extends Application{
    Scene miEscena;
    Pane contenedor;
    //Label lblNombre, lblApellidos;
    Label lblMensaje;
    //TextField txtNombre, txtApellidos;
    Button btnNuevo, btnGuardar, btnCancelar;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Application.launch(args);
    }
    
    @Override
    /*public void start(Stage miEscenario){
        //Creamos un nodo tipo texto
        Text miTexto = new Text("Bienvenido manito");
        //Creamos el contenedor
        VBox contenedor = new VBox();
        //Agregamos el nodo de tipo texto al contenedor
        contenedor.getChildren().add(miTexto);
        //Asoganmos tamaño de contenedor
        contenedor.setMinSize(350, 250);
        //Creamos una Escena y le asignamos el contenedor
        Scene miEscena = new Scene(contenedor);
        //Asignamos propiedades al Escenario
        miEscenario.setTitle("Mi Primera Aplicacion JavaFX");
        miEscenario.setMinHeight(500);
        miEscenario.setMinWidth(500);
        //Asignamos la Escena al Escenario
        miEscenario.setScene(miEscena);
        //Motramos el Escenario
        miEscenario.show();
        
    }*/
    /*public void start(Stage miEscenario){
        lblNombre = new Label("Nombre");
        lblNombre.setTranslateX(20);
        lblNombre.setTranslateY(20);
        txtNombre= new TextField();
        txtNombre.setTranslateX(90);
        txtNombre.setTranslateY(20);
        lblApellidos = new Label("Apellidos:");
        lblApellidos.setTranslateX(20);
        lblApellidos.setTranslateY(60);
        txtApellidos = new TextField();
        txtApellidos.setTranslateX(90);
        txtApellidos.setTranslateY(60);
        contenedor = new Pane();
        contenedor.getChildren().addAll(lblNombre, lblApellidos, txtNombre, txtApellidos);
        miEscena = new Scene(contenedor);
        
        miEscenario.setTitle("Mi Primera Aplicacion JavaFX");        
        miEscenario.setMinWidth(300);
        miEscenario.setMinHeight(150);
        
        miEscenario.setScene(miEscena);
        
        miEscenario.show();
    }*/
    public void start(Stage miEscenario){
        btnNuevo = new Button("Nuevo");
        btnNuevo.setMinWidth(80);
        btnNuevo.setTranslateX(20);
        btnNuevo.setTranslateY(20);
        btnGuardar = new Button("Guardar");
        btnGuardar.setMinWidth(80);
        btnGuardar.setTranslateX(120);
        btnGuardar.setTranslateY(20);
        btnCancelar = new Button("Cancelar");
        btnCancelar.setMinWidth(80);
        btnCancelar.setTranslateX(220);
        btnCancelar.setTranslateY(20);
        lblMensaje = new Label("Mensaje");
        lblMensaje.setMinWidth(80);
        lblMensaje.setTranslateX(120);
        lblMensaje.setTranslateY(70);
        contenedor = new Pane();
        contenedor.getChildren().addAll(btnNuevo, btnGuardar, btnCancelar,lblMensaje);
        miEscena = new Scene(contenedor);
        btnNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                lblMensaje.setText("Pulsaste el Boton Nuevo");
            }
        });
              
        //Utilizando expresion lamba
        btnGuardar.setOnAction(e -> lblMensaje.setText("Pulsaste el boton Guardar"));
        btnCancelar.setOnAction(e -> cancelar());
        
        miEscenario.setTitle("Ejemplo con button");
        miEscenario.setMinWidth(350);
        miEscenario.setMinHeight(150);
        miEscenario.setScene(miEscena);
        miEscenario.show();
    }
    public void cancelar(){
        lblMensaje.setText("Pulsaste el Botón Cancelar");
    }
    
    
}
