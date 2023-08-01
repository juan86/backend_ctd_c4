package com.backend.digitalhouse.clase;

public class Computadora {
    private String id;
    private int ram;
    private int disco;
    private static int contador;

    public Computadora(int ram, int disco){
        this.ram = ram;
        this.disco = disco;
        this.id = "AR"+ram+"-"+disco;
        contador++;
        System.out.println("Existencias: " + contador);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Computadora.contador = contador;
    }
}
