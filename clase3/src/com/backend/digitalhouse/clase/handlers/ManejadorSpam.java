package com.backend.digitalhouse.clase.handlers;

import com.backend.digitalhouse.clase.Mail;

public class ManejadorSpam extends ManejadorMail {
    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Spameando...");
        return "SPAM";
    }
}
