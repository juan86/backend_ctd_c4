package com.backend.digitalhouse.clase.facade;

import com.backend.digitalhouse.clase.Producto;

public class ApiProducto {

    public static int calcularDescuentoProducto(Producto producto) {

        //condicion a verificar ? lo que debe suceder si se cumple : lo que debe suceder si no se cumple
        return producto.getTipo().equalsIgnoreCase("lata") ? 10 : 0;
    }

}
