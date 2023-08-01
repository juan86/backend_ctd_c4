package com.backend.digitalhouse.clase.facade;

public class ApiCantidad {
    public static int calcularDescuentoCantidad(int cantidad) {

        return cantidad > 12 ? 15 : 0;
    }
}
