package com.backend.digitalhouse.clase;

import com.backend.digitalhouse.clase.handlers.*;

public class CompruebaMail {

    //se encarga de iniciar el proceso, por ende la cadena
    private ManejadorMail manejadorMail;

    public CompruebaMail(){
        //definir el orden de la cadena
        //inicio
        manejadorMail = new ManejadorGerencial();

        //segundo eslabon
        ManejadorMail manejadorDos = new ManejadorComercial();
        manejadorMail.setSiguienteManejador(manejadorDos);

        //tercer eslabon
        ManejadorMail manejadorTres = new ManejadorTecnico();
        manejadorDos.setSiguienteManejador(manejadorTres);

        //ultimo
        ManejadorMail spam = new ManejadorSpam();
        manejadorTres.setSiguienteManejador(spam);
    }


    public String procesarMail(Mail mail){
        return manejadorMail.procesarMail(mail);
    }


}
