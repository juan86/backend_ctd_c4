package com.backend.digitalhouse.clase16.dao;

import java.util.List;

public interface IDao <T> {

    T guardar(T t);
    T buscar(int id);

    List<T> listarTodos();
    T buscarPorCriterio(int criterio);

}
