package com.backend.clase21.service.impl;

import com.backend.clase21.entity.Producto;
import com.backend.clase21.repository.ProductoRepository;
import com.backend.clase21.service.IProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);

    private ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto registrarProducto(Producto producto) {
        Producto productoNuevo = productoRepository.save(producto);
        LOGGER.info("El producto ha sido registrado: {}", productoNuevo);
        return productoNuevo;
    }

    @Override
    public List<Producto> listarProductos() {

        return null;
    }

    @Override
    public Producto buscarProductoPorId(Long id) {
        return null;
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return null;
    }

    @Override
    public void eliminarProducto(Long id) {

    }

    @Override
    public List<Producto> listarProductosPorCantidad(int cantidad) {
        return productoRepository.listarProductosPorCantidadMayor(cantidad);
    }
}
