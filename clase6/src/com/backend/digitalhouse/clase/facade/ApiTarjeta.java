package com.backend.digitalhouse.clase.facade;


import com.backend.digitalhouse.clase.Tarjeta;

public class ApiTarjeta {
    public static int calcularDescuentoTarjeta(Tarjeta tarjeta) {

        return tarjeta.getBanco().equalsIgnoreCase("Star Bank") ? 20 : 0;
    }
}
