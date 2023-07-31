package com.backend.digitalhouse.mesas;

import com.backend.digitalhouse.mesas.handlers.ControlCalidad;
import com.backend.digitalhouse.mesas.handlers.ControlEnvase;
import com.backend.digitalhouse.mesas.handlers.ControlLote;
import com.backend.digitalhouse.mesas.handlers.ControlPeso;

public class ControladorCalidad {

    //se encarga de iniciar el proceso, por ende la cadena
    private ControlCalidad controlCalidad;

    public ControladorCalidad() {
        //definir el orden de la cadena
        //inicio
        controlCalidad = new ControlEnvase();

        //segundo eslabon
        ControlCalidad controlLote = new ControlLote();
        controlCalidad.setSiguienteControl(controlLote);

        //tercer eslabon
        ControlCalidad controlPeso = new ControlPeso();
        controlLote.setSiguienteControl(controlPeso);
    }


    public void comprobarCalidad(Articulo articulo) {
        controlCalidad.comprobarCalidad(articulo);
    }

}
