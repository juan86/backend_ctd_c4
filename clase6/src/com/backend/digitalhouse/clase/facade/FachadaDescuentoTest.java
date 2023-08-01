package com.backend.digitalhouse.clase.facade;

import com.backend.digitalhouse.clase.Producto;
import com.backend.digitalhouse.clase.Tarjeta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FachadaDescuentoTest {
    private FachadaDescuento fachadaDescuento = new FachadaDescuento();

    @Test
    void deberiaCalcular25DeDescuento(){
        //queremos aplicar solo por cantidad y producto
        //arrange
        Producto producto = new Producto("choclo", "lata");
        Tarjeta tarjeta = new Tarjeta("T65465465", "otro bank");

        //act
        int rtaObtenida = fachadaDescuento.calcularDescuento(15, tarjeta, producto);
        //assert
        assertEquals(25, rtaObtenida);

    }


}