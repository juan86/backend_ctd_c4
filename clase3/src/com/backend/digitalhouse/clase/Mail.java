package com.backend.digitalhouse.clase;

public class Mail {
    //https://drive.google.com/file/d/1bBXClBWWSFEoxrDJ-M6IGWC6ddCftZSL/view
    private String asunto;
    private String origen;
    private String destino;

    public Mail(String asunto, String origen, String destino) {
        this.asunto = asunto;
        this.origen = origen;
        this.destino = destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
