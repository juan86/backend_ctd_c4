package com.backend.integrador.dao;

public interface IDao<T> {
    T registrar(T t);
    T buscarPorId(int id);

}
