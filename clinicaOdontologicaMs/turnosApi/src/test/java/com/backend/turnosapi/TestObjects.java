package com.backend.turnosapi;

import com.backend.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.dto.salida.paciente.PacienteSalidaDto;
import com.backend.dto.salida.turno.OdontologoTurnoSalidaDto;
import com.backend.dto.salida.turno.PacienteTurnoSalidaDto;
import com.backend.turnosapi.entity.Odontologo;
import com.backend.turnosapi.entity.Paciente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.File;
import java.io.IOException;

public class TestObjects {
    private static final Jackson2ObjectMapperBuilder jsonBuilder = Jackson2ObjectMapperBuilder.json();
    private static final ObjectMapper mapper = jsonBuilder.build();

    private final PacienteSalidaDto pacienteSalidaDto = (mapper.readValue(new File("src/test/resources/pacienteSalidaDto.json"), new TypeReference<>() {
    }));

    private final OdontologoSalidaDto odontologoSalidaDto = (mapper.readValue(new File("src/test/resources/odontologoSalidaDto.json"), new TypeReference<>() {
    }));

    private final Paciente paciente = (mapper.readValue(new File("src/test/resources/pacienteSalidaDto.json"), new TypeReference<>() {
    }));
    private final Odontologo odontologo = (mapper.readValue(new File("src/test/resources/odontologoSalidaDto.json"), new TypeReference<>() {
    }));

    private final PacienteTurnoSalidaDto pacienteTurnoSalidaDto = (mapper.readValue(new File("src/test/resources/pacienteTurnoSalidaDto.json"), new TypeReference<>() {
    }));
    private final OdontologoTurnoSalidaDto odontologoTurnoSalidaDto = (mapper.readValue(new File("src/test/resources/odontologoTurnoSalidaDto.json"), new TypeReference<>() {
    }));


    public TestObjects() throws IOException {
    }


    public PacienteSalidaDto getPacienteSalidaDto() {
        return pacienteSalidaDto;
    }

    public OdontologoSalidaDto getOdontologoSalidaDto() {
        return odontologoSalidaDto;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public PacienteTurnoSalidaDto getPacienteTurnoSalidaDto() {
        return pacienteTurnoSalidaDto;
    }

    public OdontologoTurnoSalidaDto getOdontologoTurnoSalidaDto() {
        return odontologoTurnoSalidaDto;
    }
}
