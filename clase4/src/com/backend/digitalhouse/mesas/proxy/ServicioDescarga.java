package com.backend.digitalhouse.mesas.proxy;

import com.backend.digitalhouse.mesas.Usuario;
import com.backend.digitalhouse.mesas.proxy.Descarga;

public class ServicioDescarga implements Descarga {
    @Override
    public String descargarCancion(Usuario usuario) {
        return "Iniciando descarga para el usuario " + usuario.getId();
    }
}
