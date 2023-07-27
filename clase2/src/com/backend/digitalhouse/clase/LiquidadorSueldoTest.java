package com.backend.digitalhouse.clase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorSueldoTest {

    private LiquidadorSueldo liquidadorSueldo;


    @Test
    void unLiquidadorEfectivo_deberiaLiquidarAUnEmpleadoEfectivo(){
        //arrange
        Empleado empleado = new EmpleadoEfectivo("Fredy", "Ospina", "CA-65176878777", 5000, 1000, 500);
        liquidadorSueldo = new LiquidadorSueldoEfectivo();

        //act
        String rtaEsperada = "Recibo generado en formato digital. Sueldo a liquidar: $5500.0";
        String rtaObtenida = liquidadorSueldo.liquidarSueldo(empleado);

        //assert
        assertEquals(rtaEsperada, rtaObtenida);
    }

    @Test
    void unLiquidadorEfectivo_noDeberiaLiquidarAUnEmpleadoContratado(){

    }



}