package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    private static PacienteEntradaDto paciente;
    private static OdontologoEntradaDto odontologo;


    @BeforeAll
    public static void init() {
        paciente = new PacienteEntradaDto("Lu", "Murga", 65436546, LocalDate.of(2023, 8, 30), new DomicilioEntradaDto("Calle", 1, "Localidad", "Provincia"));
        odontologo = new OdontologoEntradaDto("AD-564656546456", "Patricia", "Lopez");

    }

    @Test
    @Order(1)
    void deberiaRegistrarseUnTurnoAsignadoAOdontologoYPacienteExistentes() throws BadRequestException {
        PacienteSalidaDto pacienteResponseDto = pacienteService.registrarPaciente(paciente);
        OdontologoSalidaDto odontologoResponseDto = odontologoService.registrarOdontologo(odontologo);

        TurnoSalidaDto turnoResponseDto = turnoService.registrarTurno(new TurnoEntradaDto(pacienteResponseDto.getId(), odontologoResponseDto.getId(), LocalDateTime.of(LocalDate.of(2023, 10, 01), LocalTime.of(12, 30))));
        Assertions.assertNotNull(turnoResponseDto);
        Assertions.assertNotNull(turnoResponseDto.getId());
        Assertions.assertEquals("Lu", turnoResponseDto.getPacienteTurnoSalidaDto().getNombre());
    }

    @Test
    @Order(2)
    void cuandoNoExisteElPaciente_noDeberiaInsertarElTurno() {
        OdontologoSalidaDto odontologoResponseDto = odontologoService.registrarOdontologo(odontologo);
        Assertions.assertThrows(Exception.class, () -> turnoService.registrarTurno(new TurnoEntradaDto(2L, odontologoResponseDto.getId(), LocalDateTime.of(LocalDate.of(2023, 07, 01), LocalTime.of(12, 30)))));

    }


    @Test
    @Order(3)
    void deberiaEncontrarTurnoId1() {
        TurnoSalidaDto turnoResponseDto = turnoService.buscarTurnoPorId(1L);
        Assertions.assertNotNull(turnoResponseDto);
        Assertions.assertNotNull(turnoResponseDto.getFechaYHora());

    }

    @Test
    @Order(4)
    void deberiaEliminarTurnoId1() throws ResourceNotFoundException {
        turnoService.eliminarTurno(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> turnoService.eliminarTurno(1L));

    }


    @Test
    @Order(5)
    void deberiaInformarUnaListaDeUnElemento() {
        List<TurnoSalidaDto> turnoResponseDtoList = turnoService.listarTurnos();
        Assertions.assertNotEquals(1, turnoResponseDtoList.size());
    }

}