package service;

import com.backend.digitalhouse.dao.impl.PacienteDaoH2;
import com.backend.digitalhouse.entity.Domicilio;
import com.backend.digitalhouse.entity.Paciente;
import com.backend.digitalhouse.service.PacienteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

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
    public void deberiaAgregarUnPaciente() {
        Paciente pacTest = new Paciente("Nombre", "Apellido", 123456, LocalDate.of(2023, 05, 02), new Domicilio("Calle", 13, "Localidad", "Provincia"));

        Paciente pacienteResult = pacienteService.registrarPaciente(pacTest);

        assertNotNull(pacTest.getId());
        assertEquals(123456, pacienteResult.getDni());

    }


    @Test
    public void listarTodosLosPacientes() {
        List<Paciente> pacientesTest = pacienteService.listarPacientes();
        assertFalse(pacientesTest.isEmpty());
        assertTrue(pacientesTest.size() >= 2);

    }


}