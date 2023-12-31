package com.backend.digitalhouse.clase;

import org.apache.log4j.Logger;

import java.sql.*;

public class Transaccion {

    private static final Logger LOGGER = Logger.getLogger(Transaccion.class);

    public static void main(String[] args) {
        Connection connection = null;
        Cuenta cuenta = new Cuenta("Lu", 354364645, 50000);
        try{
            connection = getConnection();
            connection.setAutoCommit(false);

            //creamos la tabla
            Statement st = connection.createStatement();
            st.execute(SqlCtes.CREATE);

            //Insertar un registro en la tabla
            PreparedStatement ps = connection.prepareStatement(SqlCtes.INSERT);
            ps.setString(1, cuenta.getNombre());
            ps.setInt(2, cuenta.getNumeroCuenta());
            ps.setDouble(3, cuenta.getSaldo());
            ps.execute();

            //Agregar 10 a la cuenta
            PreparedStatement psUp = connection.prepareStatement(SqlCtes.UPDATE);
            psUp.setDouble(1, cuenta.getSaldo() + 10);
            psUp.setInt(2, cuenta.getNumeroCuenta());
            psUp.execute();
            cuenta.setSaldo(cuenta.getSaldo() + 10);


            psUp.setDouble(1, cuenta.getSaldo() + 15);
            psUp.setInt(2, cuenta.getNumeroCuenta());
            psUp.execute();

            //int aux = 1/0;

            //mostrar la info
            PreparedStatement psSel = connection.prepareStatement(SqlCtes.SELECT);
            psSel.setInt(1, 1);
            ResultSet rs = psSel.executeQuery();
            while (rs.next()){
                LOGGER.info(rs.getString(2) + " - Saldo $: " + rs.getDouble(4));
            }

            connection.commit();
            //connection.setAutoCommit(true);

        } catch (Exception exception){
            LOGGER.error(exception.getMessage());
            if(connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Tuvimos un problema");
                    LOGGER.error(exception.getMessage());
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }

        } finally {
            try{
                connection.close();
            } catch (Exception exception){
                LOGGER.error(exception.getMessage());
            }
        }





    }


    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c9clase9", "sa", "sa");
    }
}
