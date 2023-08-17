package com.backend.digitalhouse.clase16.dao.impl;


import com.backend.digitalhouse.clase16.dao.IDao;
import com.backend.digitalhouse.clase16.dao.JdbcConnection;
import com.backend.digitalhouse.clase16.entity.Domicilio;
import com.backend.digitalhouse.clase16.entity.Paciente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteDao implements IDao<Paciente> {
    private final Logger LOGGER = LoggerFactory.getLogger(PacienteDao.class);
    private final DomicilioDao domicilioDao;

    @Autowired
    public PacienteDao(DomicilioDao domicilioDao) {
        this.domicilioDao = domicilioDao;
    }

    @Override
    public Paciente buscarPorCriterio(int criterio) {
        Paciente paciente = null;
        Connection connection = null;
        try {
            connection = JdbcConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PACIENTES WHERE DNI = ?");
            ps.setInt(1, criterio);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                paciente = crearObjetoPaciente(rs);
            }

            LOGGER.info("Se ha encontrado el paciente con dni {}: {}", criterio, paciente);

        } catch (SQLException e) {
            //proceder segun esto
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //proceder segun esto otro
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex){
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public List<Paciente> listarTodos() {
        Connection connection = null;
        List<Paciente> pacientes = new ArrayList<>();
        try{
            connection = JdbcConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PACIENTES");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                pacientes.add(crearObjetoPaciente(rs));
            }

            LOGGER.info("Listado de todos los pacientes: " + pacientes);
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex){
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return pacientes;
    }


    private  Paciente crearObjetoPaciente(ResultSet rs) throws SQLException {
        int idPaciente = rs.getInt("id");
        String nombrePaciente = rs.getString("nombre");
        String apellidoPaciente = rs.getString("apellido");
        int dniPaciente = rs.getInt("dni");
        LocalDate fechaIngreso = rs.getDate("fecha").toLocalDate();
        Domicilio domicilioPaciente = domicilioDao.buscar(rs.getInt("domicilio_id"));
        return new Paciente(idPaciente, nombrePaciente, apellidoPaciente,dniPaciente, fechaIngreso, domicilioPaciente);

    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        Paciente paciente1 = null;
        try{
            domicilioDao.guardar(paciente.getDomicilio());

            connection = JdbcConnection.getConnection();


            PreparedStatement ps = connection.prepareStatement("INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA, DOMICILIO_ID) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());

            ps.setInt(4, paciente.getDni());
            ps.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            ps.setInt(6, paciente.getDomicilio().getId());
            ps.execute();
            //forma para obtener info
            ResultSet key = ps.getGeneratedKeys();
            while(key.next()){
                paciente1 = new Paciente(key.getInt(1), paciente.getNombre(), paciente.getApellido(), paciente.getDni(), paciente.getFechaIngreso(), paciente.getDomicilio());
            }
            LOGGER.info("Se ha registrado el paciente: " + paciente1);

        } catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex){
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return paciente1;

    }

    @Override
    public Paciente buscar(int id) {
        Paciente paciente = null;
        Connection connection = null;
        try {
            connection = JdbcConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PACIENTES WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                ;
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getDate(6).toLocalDate(), domicilioDao.buscar(rs.getInt(7)));
            }

            LOGGER.info("Se ha encontrado el paciente " + paciente);

        } catch (SQLException e) {

            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex){
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return paciente;
    }


}
