package com.backend.digitalhouse.clase16.dao.impl;

import com.backend.digitalhouse.clase16.dao.IDao;
import com.backend.digitalhouse.clase16.dao.JdbcConnection;
import com.backend.digitalhouse.clase16.entity.Odontologo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Component
public class OdontologoDao implements IDao<Odontologo> {
    private static final Logger LOGGER = LoggerFactory.getLogger(OdontologoDao.class);
    private final String CTE_ERROR = "Ha ocurrido un error al intentar cerrar la bdd. {}";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologo1 = null;
        try {
            connection = JdbcConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, odontologo.getNombre());
            ps.setString(2, odontologo.getApellido());
            ps.setInt(3, odontologo.getMatricula());
            ps.execute();

            ResultSet key = ps.getGeneratedKeys();
            while (key.next()) {
                odontologo1 = new Odontologo(key.getInt(1), odontologo.getNombre(), odontologo.getApellido(), odontologo.getMatricula());

            }
            LOGGER.info("Se ha registrado el odontologo: {}", odontologo1);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error(CTE_ERROR, ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologo1;
    }

    @Override
    public Odontologo buscar(int id) {
        Odontologo odontologo = null;
        Connection connection = null;
        try {
            connection = JdbcConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            LOGGER.info("Se ha encontrado el odontologo: {}", odontologo);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error(CTE_ERROR, ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologo;
    }


    @Override
    public Odontologo buscarPorCriterio(int criterio) {
        Odontologo odontologo = null;
        Connection connection = null;
        try {
            connection = JdbcConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE MATRICULA = ?");
            ps.setInt(1, criterio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            LOGGER.info("Se ha encontrado el odontologo: {}", odontologo);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error(CTE_ERROR, ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologo;
    }


    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            connection = JdbcConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                odontologos.add(odontologo);
            }
            LOGGER.info("Listado de todos los odontologos: {}", odontologos);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error(CTE_ERROR, ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologos;
    }
}
