package com.backend.digitalhouse;

public class LiquidadorSueldoEfectivo extends LiquidadorSueldo{
    @Override
    protected double calcularSueldo(Empleado empleado) {
        double sueldo = 0;

        if(empleado instanceof EmpleadoEfectivo empleadoEfectivo){
            sueldo = empleadoEfectivo.getSueldoBasico() + empleadoEfectivo.getPremio() - empleadoEfectivo.getDescuento();
        }

        return sueldo;
    }

    @Override
    protected String generarRecibo(Empleado empleado) {
        return "Recibo generado en formato digital";
    }
}
