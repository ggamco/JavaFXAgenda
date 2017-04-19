/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cice.main;

import com.cice.main.vistas.DetallePersonaControlador;
import com.cice.modelos.Persona;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author formador
 */
public class MainApp extends Application {

    //Declaramos variables Locales
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane personOverview;

    //Listado o colección propia de FX
    private ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    public MainApp() {
        listaPersonas.add(new Persona("Gustavo", "Gamboa Cordero"));
        listaPersonas.add(new Persona("Eva", "Gallego Jimenez"));
        listaPersonas.add(new Persona("Antonia", "Cordero Santos"));
        listaPersonas.add(new Persona("Juan Ramon", "Sanchez Come"));
        listaPersonas.add(new Persona("Gregorio", "Gamboa Sanchez"));
        listaPersonas.add(new Persona("Jose Luis", "Gallego Ripoll"));
        listaPersonas.add(new Persona("Fernando", "Tejero Ramos"));
        listaPersonas.add(new Persona("Florentino", "Perez Garcia"));
    }

    public ObservableList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("App Master-Detail JavaFX");

        //inicializamos la primera escena, es decir, el rootLayout
        initMain();
        //Cargamos la scena de la app, es decir el personOverview
        showPersonOverview();
    }

    public void initMain() {

        try {
            //cargamos el archivo FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("vistas/Principal.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            //cargamos la scena en el stage
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showPersonOverview(){
        try {
            //cargamos el archivo FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("vistas/DetallePersona.fxml"));
            personOverview = (AnchorPane) loader.load();
            
            //cargamos la vista en la scena
            rootLayout.setCenter(personOverview);
            
            //dar acceso al controlador desde MainApp
            DetallePersonaControlador controlador = loader.getController();
            controlador.setMainApp(this);
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
