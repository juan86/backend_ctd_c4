package com.backend.digitalhouse.clase;

public class Main {
    public static void main(String[] args) {
        Computadora windows1 = ComputadoraFactory.obtenerComputadora(2, 128);
        Computadora mac1 = ComputadoraFactory.obtenerComputadora(16, 500);

        Computadora windows2 = ComputadoraFactory.obtenerComputadora(2, 256);
        Computadora mac2 = ComputadoraFactory.obtenerComputadora(8, 500);

        System.out.println("---------------------------------");
        //System.out.println(windows1);
        //System.out.println(windows2);
        //System.out.println(ComputadoraFactory.getComputadorasLigeras().size());


    }





}
