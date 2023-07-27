package com.backend.digitalhouse.clase;

public class LiquidadorSueldoContratado extends LiquidadorSueldo{
    @Override
    protected double calcularSueldo(Empleado empleado) {
        double sueldo = 0;
        if(empleado instanceof EmpleadoContratado empleadoContratado){
            sueldo = empleadoContratado.getCantHorasTrabajadas() * empleadoContratado.getValorHora();
        }


        return sueldo;
    }

    @Override
    protected String generarRecibo(Empleado empleado) {
        return "Recibo impreso";
    }
}
