package com.backend.digitalhouse.clase;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nombre;
    private List<Persona> personas;//= new ArrayList<>();

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.personas = new ArrayList<>();
    }

    public void agregarPersona(Persona persona){
        if(esMayor(persona.getEdad()) && cumpleCantidadLetras(persona.getNombre())){
            personas.add(persona);
            System.out.println("Se agrego " + persona.getNombre() + " al grupo");
        } else {
            System.out.println("No es posible agregar a " + persona.getNombre() + " al grupo");
        }

    }

    public boolean esMayor(int edad){
        return edad > 18;
    }

    public boolean cumpleCantidadLetras(String nombre){
        return nombre.length() >= 5;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
