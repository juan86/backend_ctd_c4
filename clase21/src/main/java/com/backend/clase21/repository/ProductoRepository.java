package com.backend.clase21.repository;

import com.backend.clase21.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    //aqui iria query
    List<Producto> listarProductosPorCantidadMayor(int cantidad);
}
