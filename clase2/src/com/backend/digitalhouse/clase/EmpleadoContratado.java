package com.backend.digitalhouse.clase;

public class EmpleadoContratado extends Empleado{
    private int cantHorasTrabajadas;
    private double valorHora;

    public EmpleadoContratado(String nombre, String apellido, String numeroCuenta, int cantHorasTrabajadas, double valorHora) {
        super(nombre, apellido, numeroCuenta);
        this.cantHorasTrabajadas = cantHorasTrabajadas;
        this.valorHora = valorHora;
    }

    public int getCantHorasTrabajadas() {
        return cantHorasTrabajadas;
    }

    public void setCantHorasTrabajadas(int cantHorasTrabajadas) {
        this.cantHorasTrabajadas = cantHorasTrabajadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
