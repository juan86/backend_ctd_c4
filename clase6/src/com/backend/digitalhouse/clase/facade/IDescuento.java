package com.backend.digitalhouse.clase.facade;

import com.backend.digitalhouse.clase.Producto;
import com.backend.digitalhouse.clase.Tarjeta;

public interface IDescuento {
    int calcularDescuento(int cantidad, Tarjeta tarjeta, Producto producto);
}
