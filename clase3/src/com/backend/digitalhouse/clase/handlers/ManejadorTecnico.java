package com.backend.digitalhouse.clase.handlers;

import com.backend.digitalhouse.clase.Mail;

public class ManejadorTecnico extends ManejadorMail{

    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Area tecnica trabajando...");
        if (mail.getAsunto().equalsIgnoreCase("tecnica") || mail.getDestino().equals("tecnica@colmena.com")){
            return "Area tecnica procesando el mail...";
        } else {
            return getSiguienteManejador().procesarMail(mail);
        }
    }
}
