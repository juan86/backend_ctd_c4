package com.backend.digitalhouse.clase.test;

import com.backend.digitalhouse.clase.CompruebaMail;
import com.backend.digitalhouse.clase.Mail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompruebaMailTest {

    private final CompruebaMail compruebaMail = new CompruebaMail();

    @Test
    void deberiaPasarASpam() {
        //arrange
        Mail mail = new Mail("slkgfhlskjgh", "lu@gmail.com", "ksjhkj@colmena.com");
        String rtaEsperada = "SPAM";
        //act
        String rtaObtenida = compruebaMail.procesarMail(mail);

        //assert
        assertEquals(rtaEsperada, rtaObtenida);
    }

}