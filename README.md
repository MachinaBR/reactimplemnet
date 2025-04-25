Este proyecto consta de dos partes:
Backend Java (Servlets + Hibernate + MySQL) empaquetado como WAR
Frontend React (Create React App) con formulario de login

Prerrequisitos

Java JDK 21 (o superior)
Apache Tomcat 9
Maven 3.x
MySQL 8+
Node.js & npm (para la parte React)

Configuración de la Base de Datos

Crea una base de datos (por ejemplo login_table).
CREATE DATABASE login_table;
USE login_table;

CREATE TABLE usuario_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre1 VARCHAR(100) NOT NULL,
    nombre2 VARCHAR(100),
    apellido1 VARCHAR(100) NOT NULL,
    apellido2 VARCHAR(100),
    usuario VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    correo_electronico VARCHAR(150) UNIQUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO usuario_table (nombre1, nombre2, apellido1, apellido2, usuario, contrasena, telefono, correo_electronico) VALUES
('Juan', 'Carlos', 'Pérez', 'Gómez', 'admin', '1234', '3101234567', 'admin@correo.com'),
('Ana', 'María', 'Rodríguez', 'López', 'ana2025', 'clave123', '3114567890', 'ana.lopez@correo.com');

Backend (Java + Tomcat)

Arranca Tomcat
Lanza la aplicación React
npm start
