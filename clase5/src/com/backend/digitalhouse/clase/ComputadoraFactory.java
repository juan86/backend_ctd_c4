package com.backend.digitalhouse.clase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputadoraFactory {
         //tipo de dato de la key, tipo de dato del objeto asociado a esa key
    private static Map<String, Computadora> computadorasLigeras = new HashMap<>();

    public static Computadora obtenerComputadora(int ram, int disco) {
        //definir la key, que no es = al id del objeto computadora
        String key = "key:" + ram + ":" + disco;
        System.out.println(key);
        //verificar si ya existe esa key en la coleccion
        if(!computadorasLigeras.containsKey(key)){
            //crear la compu y la agregar con su key a la coleccion
            Computadora computadora = new Computadora(ram, disco);
            computadorasLigeras.put(key, computadora);
            //computadorasLigeras.put(key, new Computadora(ram, disco));
            System.out.println("Computadora creada");
        } else {
            System.out.println("Computadora encontrada");
        }

        return computadorasLigeras.get(key);

    }

    public static Map<String, Computadora> getComputadorasLigeras() {
        return computadorasLigeras;
    }
}
