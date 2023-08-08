package com.backend.integrador.test;


import com.backend.integrador.dao.impl.MedicamentoDaoH2;
import com.backend.integrador.entity.Medicamento;
import com.backend.integrador.service.MedicamentoService;
import org.junit.jupiter.api.Test;


import static org.testng.Assert.assertNotNull;

public class MedicamentoServiceTest {
/*
esta es otra opcion en vez de hacer lo del main
    private static Connection connection = null;

    @BeforeAll
    static void doBefore(){
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/c4clase14;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }*/



    //seteamos la implementacion de la IDao que queremos que se use, sea H2, en memoria, MySql, o la que tengamos implementada

    MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());


    @Test
    void deberiaAgregarUnMedicamento(){
        Medicamento med1 = new Medicamento(35465, "Aspirina", "Bayer", 50, 200);
        Medicamento medicamentoInsertado = medicamentoService.registrarMedicamento(med1);

        assertNotNull(medicamentoInsertado.getId());
    }




}
