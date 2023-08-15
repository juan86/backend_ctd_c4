package service;


import com.backend.digitalhouse.dao.impl.OdontologoDaoH2;
import com.backend.digitalhouse.entity.Odontologo;
import com.backend.digitalhouse.service.OdontologoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class OdontologoServiceTest {

    private final OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeAll
    static void doBefore(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/c4clase13;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    @Test
    public void deberiaAgregarUnOdontologo() {
        Odontologo odontologo = new Odontologo("12345", "Patricia", "Damiani");

        Odontologo odontologoTest = odontologoService.guardarOdontologo(odontologo);

        assertTrue(odontologoTest.getId() != 0);

    }

    @Test
    public void listarTodosLosOdontologos() {
        List<Odontologo> odontologoList = odontologoService.listarOdontologos();
        assertFalse(odontologoList.isEmpty());

    }
}