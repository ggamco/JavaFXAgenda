package com.cice.main.vistas;

import com.cice.main.MainApp;
import com.cice.modelos.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DetallePersonaControlador {
    
    //Declaramos las variables para referenciarlas en el fxml
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label street;
    @FXML
    private Label city;
    @FXML
    private Label zipCode;
    @FXML
    private Label phone;
    @FXML
    private TableView<Persona> tablaPersonas;
    @FXML
    private TableColumn<Persona, String> firstNameColumn;
    @FXML
    private TableColumn<Persona, String> lastNameColumn;
    
    //Declaramos un objeto MainApp para vincularlo luego con el controlador
    private MainApp mainApp;
    
    //Vamos a crear el metodo que inicializará el controlador
    @FXML
    private void initialize(){
        firstNameColumn.setCellValueFactory(celData -> celData.getValue().getNombre());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getApellidos());
        
        showDetails(null);
        
        tablaPersonas.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showDetails(newValue));
        
    }
    
    public void showDetails(Persona persona){
        
        if(persona != null){
            firstNameLabel.setText(persona.getNombre().get());
            lastNameLabel.setText(persona.getApellidos().get());
            street.setText(persona.getStreet().get());
            city.setText(persona.getCity().get());
            zipCode.setText(persona.getZipCode().get());
            phone.setText(persona.getPhone().get());
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            street.setText("");
            city.setText("");
            zipCode.setText("");
            phone.setText("");
        }
        
    }
    
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        //añadir datos a la tabla
        tablaPersonas.setItems(mainApp.getListaPersonas());
    }
    
    @FXML
    private void deletePersona(){
        
        int index = tablaPersonas.getSelectionModel().getSelectedIndex();
        
        if(index != -1){
            tablaPersonas.getItems().remove(index);
            
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
