package com.backend.digitalhouse.clase.proxy;

import com.backend.digitalhouse.clase.Persona;

import java.time.LocalDate;

public class VacunatorioProxy implements Vacunatorio{

    private VacunatorioService vacunatorioService;


    @Override
    public String vacunar(Persona persona) {
        //controlar fecha
        String mensaje = "La fecha no se corresponde con la fecha asignada";
        if(validarFecha(persona.getFechaAsignada())){
            //si la fecha es valida
            vacunatorioService = new VacunatorioService();
            mensaje = vacunatorioService.vacunar(persona);
        }

        return mensaje;
    }

    private boolean validarFecha(LocalDate fecha){
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(fecha);
    }
}
