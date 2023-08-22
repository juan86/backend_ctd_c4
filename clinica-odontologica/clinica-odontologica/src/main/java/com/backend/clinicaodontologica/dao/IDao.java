package com.backend.clinicaodontologica.dao;

import java.util.List;

public interface IDao<T>{
    //alta, buscarlos, eliminarlos y listarlos
    T registrar(T t);
    T buscarPorId(int id);
    void eliminar(int id);
    List<T> listarTodos();

    T modificar(T t);

}
