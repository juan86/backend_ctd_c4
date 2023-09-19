package com.backend.odontologosapi.service.impl;

import com.backend.odontologosapi.dto.OdontologoDto;
import com.backend.odontologosapi.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void deberiaInsertarUnOdontologo() {
        Odontologo odontologoAInsertar = new Odontologo("AD-564656546456", "Patricia", "Lopez");
        OdontologoDto odontologoDto = odontologoService.registrarOdontologo(odontologoAInsertar);

        Assertions.assertNotNull(odontologoDto);
        Assertions.assertNotNull(odontologoDto.getId());

    }

    @Test
    @Order(2)
    void cuandoNoSeCumplaElFormatoDeMatricula_noDeberiaInsertarOdontologo() {
        Odontologo odontologo = new Odontologo("564656546456", "Patricia", "Lopez");
        Assertions.assertThrows(ConstraintViolationException.class, () -> odontologoService.registrarOdontologo(odontologo));
    }

    @Test
    @Order(3)
    void deberiaListarUnSoloOdontologo() {
        List<OdontologoDto> odontologoDtos = odontologoService.listarOdontologos();
        assertEquals(1, odontologoDtos.size());
    }

    @Test
    @Order(4)
    void deberiaEliminarElOdontologoId1() throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(1L));
    }

    @Test
    @Order(5)
    void deberiaRetornarUnaListaVacia() {
        List<OdontologoDto> odontologoDtos = odontologoService.listarOdontologos();
        Assertions.assertTrue(odontologoDtos.isEmpty());
    }

}