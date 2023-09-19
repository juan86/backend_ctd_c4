package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.DomicilioSalidaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.OdontologoTurnoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.PacienteTurnoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.entity.Domicilio;
import com.backend.clinicaodontologica.entity.Odontologo;
import com.backend.clinicaodontologica.entity.Paciente;
import com.backend.clinicaodontologica.entity.Turno;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.repository.TurnoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TurnoServiceTestMockito {

    private final TurnoRepository turnoRepository = mock(TurnoRepository.class);
    private final OdontologoService odontologoService = mock(OdontologoService.class);
    private final PacienteService pacienteService = mock(PacienteService.class);
    private final ModelMapper modelMapper = mock(ModelMapper.class);

    private final TurnoService turnoService = new TurnoService(turnoRepository, modelMapper, odontologoService, pacienteService);

    @Test
    @Order(1)
    void deberiaInsertarUnTurno() throws BadRequestException {
        when(odontologoService.buscarOdontologoPorId(1L)).thenReturn(new OdontologoSalidaDto(1L, "AD-5415643", "P.", "Sherman"));
        when(pacienteService.buscarPacientePorId(1L)).thenReturn(new PacienteSalidaDto(1L, "Darla", "O.", 252525, LocalDate.of(2023, 11, 2), new DomicilioSalidaDto(1L, "Wallaby", 42, "Sydney", "Nueva Gales del Sur")));
        Odontologo odontologo = new Odontologo("AD-5415643", "P.", "Sherman");
        odontologo.setId(1L);
        Domicilio domicilio = new Domicilio("Wallaby", 42, "Sydney", "Nueva Gales del Sur");
        domicilio.setId(1L);
        Paciente paciente = new Paciente("Darla", "O.", 252525, LocalDate.of(2023, 11, 2), domicilio);
        paciente.setId(1L);
        LocalDateTime fechaYHora = LocalDateTime.of(LocalDate.of(2023, 12, 10), LocalTime.of(10, 30));
        Turno turno = new Turno(odontologo, paciente, fechaYHora);
        Turno turnoGuardado = new Turno(1L, odontologo, paciente, fechaYHora);
        when(turnoRepository.save(turno)).thenReturn(turnoGuardado);

        when(turnoService.entidadADto(turnoGuardado)).thenReturn(new TurnoSalidaDto(1L, new PacienteTurnoSalidaDto(1L, "Darla", "O."), new OdontologoTurnoSalidaDto(1L, "P.", "Sherman"), fechaYHora));

        TurnoSalidaDto turnoSalidaDto = turnoService.registrarTurno(new TurnoEntradaDto(1L, 1L, fechaYHora));

        Assertions.assertNotNull(turnoSalidaDto.getId());

    }

}
