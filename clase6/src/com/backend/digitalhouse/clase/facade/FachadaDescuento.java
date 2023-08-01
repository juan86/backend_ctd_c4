package com.backend.digitalhouse.clase.facade;

import com.backend.digitalhouse.clase.Producto;
import com.backend.digitalhouse.clase.Tarjeta;

public class FachadaDescuento implements IDescuento {

    //metodo fachada
    @Override
    public int calcularDescuento(int cantidad, Tarjeta tarjeta, Producto producto) {
        int descuento = 0;
        descuento += ApiCantidad.calcularDescuentoCantidad(cantidad);
        descuento += ApiProducto.calcularDescuentoProducto(producto);
        descuento += ApiTarjeta.calcularDescuentoTarjeta(tarjeta);
        System.out.println(descuento);
        return descuento;
    }
}
