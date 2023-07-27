package com.backend.digitalhouse.clase.handlers;

import com.backend.digitalhouse.clase.Mail;

public class ManejadorGerencial extends ManejadorMail{
    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Gerencia trabajando...");

        if(mail.getAsunto().equalsIgnoreCase("gerencia") || mail.getDestino().equals("gerencia@colmena.com")){
            return "Gerencia procesando mail...";
        } else return getSiguienteManejador().procesarMail(mail);
    }
}
