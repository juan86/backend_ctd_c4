package com.backend.clase21.service;

import com.backend.clase21.entity.Producto;

import java.util.List;

public interface IProductoService {

    Producto registrarProducto(Producto producto);
    List<Producto> listarProductos();
    Producto buscarProductoPorId(Long id);
    Producto actualizarProducto(Producto producto);
    void eliminarProducto(Long id);
    List<Producto> listarProductosPorCantidad(int cantidad);

}

