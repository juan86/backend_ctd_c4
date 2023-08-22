package com.backend.clinicaodontologica.service;


import com.backend.clinicaodontologica.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    List<Odontologo> listarOdontologos();


    Odontologo registrarOdontologo(Odontologo odontologo);

    Odontologo buscarOdontologoPorId(int id);

    void eliminarOdontologo(int id);

}
