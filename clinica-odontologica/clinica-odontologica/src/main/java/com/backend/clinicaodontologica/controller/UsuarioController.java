package com.backend.clinicaodontologica.controller;


import com.backend.clinicaodontologica.entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class UsuarioController {

    @GetMapping
    public String home() {
        return "<h1> Bienvenido </h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1> Bienvenido usuario </h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1> Bienvenido admin </h1>";
    }

    @GetMapping("/usuario")
    public ResponseEntity<?> usuario() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = new Usuario();
        usuario.setNombre(userDetails.getUsername());
        return ResponseEntity.ok(usuario);

    }
}
