package com.backend.digitalhouse.clase.handlers;

import com.backend.digitalhouse.clase.Mail;

public abstract class ManejadorMail {

    private ManejadorMail siguienteManejador;

    public ManejadorMail getSiguienteManejador() {
        return siguienteManejador;
    }

    public void setSiguienteManejador(ManejadorMail siguienteManejador) {
        this.siguienteManejador = siguienteManejador;
    }

    public abstract String procesarMail(Mail mail);
}
