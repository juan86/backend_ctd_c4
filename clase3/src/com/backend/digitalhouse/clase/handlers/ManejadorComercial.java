package com.backend.digitalhouse.clase.handlers;

import com.backend.digitalhouse.clase.Mail;

public class ManejadorComercial extends ManejadorMail{

    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Depto comercial trabajando...");

        if(mail.getAsunto().equalsIgnoreCase("comercial") || mail.getDestino().equals("comercial@colmena.com")){
            return "Depto comercial procesando mail...";
        } else return getSiguienteManejador().procesarMail(mail);
    }
}
