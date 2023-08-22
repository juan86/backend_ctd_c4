package com.backend.digitalhouse.clase16.service;



import com.backend.digitalhouse.clase16.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    List<Odontologo> listarOdontologos();

    Odontologo buscarPorMatricula(int matricula);

}
