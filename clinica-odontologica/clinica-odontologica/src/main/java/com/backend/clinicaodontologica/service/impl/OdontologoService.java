package com.backend.clinicaodontologica.service.impl;


import com.backend.clinicaodontologica.dao.IDao;
import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.entity.Odontologo;
import com.backend.clinicaodontologica.service.IOdontologoService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class OdontologoService implements IOdontologoService {
    private final IDao<Odontologo> odontologoIDao;
    private final ModelMapper modelMapper;

    public OdontologoService(IDao<Odontologo> odontologoIDao, ModelMapper modelMapper) {
        this.odontologoIDao = odontologoIDao;
        this.modelMapper = modelMapper;
    }

    public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo) {
        return modelMapper.map(odontologoIDao.registrar(modelMapper.map(odontologo, Odontologo.class)), OdontologoSalidaDto.class);
    }

    public OdontologoSalidaDto buscarOdontologoPorId(int id) {
        return modelMapper.map(odontologoIDao.buscarPorId(id), OdontologoSalidaDto.class);
    }

    public List<OdontologoSalidaDto> listarOdontologos() {
        return odontologoIDao.listarTodos().stream().map(o -> modelMapper.map(o, OdontologoSalidaDto.class)).toList();
    }

    public void eliminarOdontologo(int id) {
        odontologoIDao.eliminar(id);
    }
}
