package com.cice.modelos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
    
    private final StringProperty nombre;
    private final StringProperty apellidos;
    private final StringProperty street;
    private final StringProperty city;
    private final StringProperty zipCode;
    private final StringProperty phone;
    
    public Persona(){
        this(null, null);
    }
    
    public Persona(String nombre, String apellidos){
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        
        this.street = new SimpleStringProperty("direccion de prueba");
        this.city = new SimpleStringProperty("ciudad de prueba");
        this.zipCode = new SimpleStringProperty("28000");
        this.phone = new SimpleStringProperty("+34 666 444 555");
    }

    public StringProperty getNombre() {
        return nombre;
    }

    public StringProperty getApellidos() {
        return apellidos;
    }

    public StringProperty getStreet() {
        return street;
    }

    public StringProperty getCity() {
        return city;
    }

    public StringProperty getZipCode() {
        return zipCode;
    }

    public StringProperty getPhone() {
        return phone;
    }
    
}
