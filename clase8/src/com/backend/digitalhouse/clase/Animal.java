package com.backend.digitalhouse.clase;

import org.apache.log4j.Logger;

import java.sql.*;

public class Animal {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Animal.class);

        String create = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(50) NOT NULL, TIPO VARCHAR(50) NOT NULL)";
        String insert = "INSERT INTO ANIMALES (NOMBRE, TIPO) VALUES ('Homero', 'perro'), ('Uber', 'perro'), ('Carlos', 'gato'), ('Spike', 'conejo'), ('Hana', 'gato')";
        String delete = "DELETE FROM ANIMALES WHERE ID = 1";
        String select = "SELECT * FROM ANIMALES";

        Connection connection = null;
        try {
           //me conecto
           connection = getConnection();

           //crear la tabla
            Statement statement = connection.createStatement();
            statement.execute(create);
            //statement.execute("DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(50) NOT NULL, TIPO VARCHAR(50) NOT NULL)");

            //insertar los registros
            statement.execute(insert);

            //hacer un select para consultar que fue insertado
            ResultSet resultSet = statement.executeQuery(select);
            //recorrer el result set
            while (resultSet.next()){
                logger.info(resultSet.getInt("id") + " - " + resultSet.getString(2) + " - " + resultSet.getString(3));
            }

            //eliminar 1 registro
            statement.execute(delete);
            logger.info("-----------------------------------------------------------");

            //volver a ejecutar el select para verificar que se haya eliminado el registro
            resultSet = statement.executeQuery(select);
            //recorrer el result set
            while (resultSet.next()){
                logger.info(resultSet.getInt("id") + " - " + resultSet.getString(2) + " - " + resultSet.getString(3));
            }


        } catch (Exception exception) {
            logger.error(exception.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                logger.error(e.getMessage());
            }
        }


    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //indicar que driver voy usar
        Class.forName("org.h2.Driver");
        //crear la conexion con H2, si no existe la base de datos, la va a crear
        return DriverManager.getConnection("jdbc:h2:~/c4clase8", "sa", "sa");
    }

}
