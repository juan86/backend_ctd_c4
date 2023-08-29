package com.backend.clase21.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE_PRODUCTO", nullable = false, length = 50)
    private String nombre;

    //si usamos el primitivo, hibernate lo mapeara como NotNull (porque un int no admite null) a menos que indiquemos @Column(nullable = true), si usamos el wrapper (Integer) no, a menos que explicitamente lo indiquemos con @NotNull o @Column(nullable = false)
    private int cantidad;
    private String descripcion;

    //constru vacio

    public Producto() {
    }

    //constru sin id

    public Producto(String nombre, int cantidad, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "- Descripcion: " + descripcion + "- Cantidad: " + cantidad;
    }
}
