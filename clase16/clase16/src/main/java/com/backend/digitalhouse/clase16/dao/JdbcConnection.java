package com.backend.digitalhouse.clase16.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase24;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
    }

}