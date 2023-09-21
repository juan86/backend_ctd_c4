package com.backend.clinicaodontologica.security;


import com.backend.clinicaodontologica.entity.Rol;
import com.backend.clinicaodontologica.entity.Usuario;
import com.backend.clinicaodontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
//para inyectar datos en la base de datos apenas levanta la app
public class DataLoader implements ApplicationRunner {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordAdmin = bCryptPasswordEncoder.encode("admin");
        String passwordUser = bCryptPasswordEncoder.encode("user");
        usuarioRepository.save(new Usuario("Administrador", "admin", "admin@clinica.com", passwordAdmin, Rol.ADMIN));
        usuarioRepository.save(new Usuario("Usuario", "user", "user@clinica.com", passwordUser, Rol.USER));
    }
}
