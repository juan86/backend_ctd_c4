package com.backend.digitalhouse.clase15.controller;

import com.backend.digitalhouse.clase15.entity.Entrenador;
import com.backend.digitalhouse.clase15.service.IEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    private IEntrenadorService iEntrenadorService;

    @Autowired
    public EntrenadorController(IEntrenadorService iEntrenadorService) {
        this.iEntrenadorService = iEntrenadorService;
    }

    @GetMapping("/listar")
    public List<Entrenador> listarEntrenadores(){
        return iEntrenadorService.listarEntrenadores();
    }

}
