package com.backend.digitalhouse.clase16.controller;

import com.backend.digitalhouse.clase16.entity.Odontologo;
import com.backend.digitalhouse.clase16.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller

@RequestMapping("/odontologos")
public class OdontologoController {

    private final IOdontologoService odontologoService;

    @Autowired
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    @GetMapping("odontologo")
    public String odontologoPorId(Model model, @RequestParam int matricula){
        Odontologo odontologo = odontologoService.buscarPorMatricula(matricula);
        model.addAttribute("matricula", odontologo.getMatricula());

        return "odontologo";
    }
}
