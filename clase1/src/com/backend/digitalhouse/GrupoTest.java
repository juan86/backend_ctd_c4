package com.backend.digitalhouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
   // Dadas 5 personas (Juan, Pedro, Ana, Luz y Julián) y  una colección vacía de objetos tipo Persona, cuando se intentan agregar estas a la colección, el tamaño de la colección debería ser 2.

    private final Grupo grupo = new Grupo("Camada 4");
    @Test
    void alIntentarAgregar5Personas_deberiaAgregar2_teniendoEnCuentaLetrasDelNombre() {

        //arrange
        Persona persona1 = new Persona("Juan", 20);
        Persona persona2 = new Persona("Pedro", 20);
        Persona persona3 = new Persona("Ana", 20);
        Persona persona4 = new Persona("Luz", 20);
        Persona persona5 = new Persona("Julian", 20);

        //act
        grupo.agregarPersona(persona1);
        grupo.agregarPersona(persona2);
        grupo.agregarPersona(persona3);
        grupo.agregarPersona(persona4);
        grupo.agregarPersona(persona5);

        //assert
        assertEquals(2, grupo.getPersonas().size());

    }

    //Dadas 5 personas (18 años, 17 años, 22 años, 14 años y 32 años), el tamaño de la colección debería ser 3.
    @Test
    void alIntentarAgregar5Personas_deberiaAgregar3_teniendoEnCuentaEdad() {

        //arrange
        Persona persona1 = new Persona("Juan Cruz", 19);
        Persona persona2 = new Persona("Pedro", 17);
        Persona persona3 = new Persona("Anabela", 22);
        Persona persona4 = new Persona("Luz", 14);
        Persona persona5 = new Persona("Julian", 32);

        //act
        grupo.agregarPersona(persona1);
        grupo.agregarPersona(persona2);
        grupo.agregarPersona(persona3);
        grupo.agregarPersona(persona4);
        grupo.agregarPersona(persona5);

        //assert
        assertEquals(3, grupo.getPersonas().size());

    }
}