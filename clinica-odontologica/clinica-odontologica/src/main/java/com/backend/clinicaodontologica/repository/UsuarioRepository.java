package com.backend.clinicaodontologica.repository;

import com.backend.clinicaodontologica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //@Query("from Usuario u where u.username =:username")
    Optional<Usuario> findByUsername(String username);

}
