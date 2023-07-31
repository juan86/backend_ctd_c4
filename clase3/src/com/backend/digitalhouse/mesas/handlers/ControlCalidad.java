package com.backend.digitalhouse.mesas.handlers;


import com.backend.digitalhouse.mesas.Articulo;

public abstract class ControlCalidad {
    private Articulo articulo;
    private ControlCalidad siguienteControl;

    public ControlCalidad() {
    }

    public abstract void comprobarCalidad(Articulo articulo);

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public ControlCalidad getSiguienteControl() {
        return siguienteControl;
    }

    public void setSiguienteControl(ControlCalidad siguienteControl) {
        this.siguienteControl = siguienteControl;
    }
}
