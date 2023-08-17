package com.backend.digitalhouse.clase16.dao.impl;

import com.backend.digitalhouse.clase16.dao.IDao;
import com.backend.digitalhouse.clase16.dao.JdbcConnection;
import com.backend.digitalhouse.clase16.entity.Domicilio;
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
public class DomicilioDao implements IDao<Domicilio> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DomicilioDao.class);

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;
        Domicilio domicilio1 = null;
        try {
            connection = JdbcConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.execute();


            ResultSet key = ps.getGeneratedKeys();
            while (key.next()) {

                domicilio1 = new Domicilio(key.getInt(1), domicilio.getCalle(), domicilio.getNumero(), domicilio.getLocalidad(), domicilio.getProvincia());

            }
            LOGGER.info("Se ha registrado el domicilio: " + domicilio1);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return domicilio1;
    }

    @Override
    public Domicilio buscar(int id) {
        Domicilio domicilio = null;
        Connection connection = null;
        try {
            connection = JdbcConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM DOMICILIOS WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                domicilio = new Domicilio(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            }
            LOGGER.info("Se ha encontrado el domicilio: " + domicilio);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return domicilio;
    }



    @Override
    public Domicilio buscarPorCriterio(int criterio) {
        return null;
    }



    @Override
    public List<Domicilio> listarTodos() {
        Connection connection = null;
        List<Domicilio> domicilios = new ArrayList<>();
        try {
            connection = JdbcConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM DOMICILIOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Domicilio domicilio = new Domicilio(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                domicilios.add(domicilio);
            }
            LOGGER.info("Listado de todos los domicilios: " + domicilios);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return domicilios;
    }
}
