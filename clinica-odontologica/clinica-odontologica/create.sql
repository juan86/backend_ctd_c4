DROP TABLE IF EXISTS DOMICILIOS;
CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY, CALLE VARCHAR(200) NOT NULL, NUMERO INT NOT NULL, LOCALIDAD VARCHAR(100) NOT NULL, PROVINCIA VARCHAR(100) NOT NULL);

DROP TABLE IF EXISTS PACIENTES;
CREATE TABLE PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(200) NOT NULL, DNI INT NOT NULL, FECHA DATE NOT NULL, DOMICILIO_ID INT);

DROP TABLE IF EXISTS ODONTOLOGOS;
CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(200) NOT NULL, MATRICULA INT NOT NULL);


-- para test --
INSERT INTO DOMICILIOS(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES ('Av Siempre Viva', 135, 'Springfield', 'Massachusetts'), ('Calle Wallaby', 42, 'Sydney', 'Nueva Gales del Sur');

INSERT INTO PACIENTES(NOMBRE, APELLIDO, DNI, FECHA, DOMICILIO_ID) VALUES ('Lu', 'Murga', 'lu@gmail.com', 11111111, '2023-02-01', 2);
INSERT INTO PACIENTES(NOMBRE, APELLIDO, DNI, FECHA, DOMICILIO_ID) VALUES ('Simon', 'Sueldo', 'simon@gmail.com', 22222222, '2023-02-01', 2);
INSERT INTO ODONTOLOGOS(NOMBRE, APELLIDO, MATRICULA) VALUES ('Patricia', 'Damiani', 54343);