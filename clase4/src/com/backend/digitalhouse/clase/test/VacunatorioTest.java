package com.backend.digitalhouse.clase.test;

import com.backend.digitalhouse.clase.Persona;
import com.backend.digitalhouse.clase.proxy.Vacunatorio;
import com.backend.digitalhouse.clase.proxy.VacunatorioProxy;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class VacunatorioTest {

    private Vacunatorio vacunatorio = new VacunatorioProxy();

    @Test
    void noDeberiaVacunarPersona(){

        //arrange
        Persona persona = new Persona("Evangelina", "35436536", "Gripal", LocalDate.of(2023, 07, 28));

        String rtaEsperada = "La fecha no se corresponde con la fecha asignada";
        String rtaObtenida = vacunatorio.vacunar(persona);

        assertEquals(rtaEsperada, rtaObtenida);

    }

}
