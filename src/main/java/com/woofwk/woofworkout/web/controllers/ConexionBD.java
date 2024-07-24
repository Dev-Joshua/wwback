package com.woofwk.woofworkout.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ConexionBD {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Conexion a la Base de Datos
    public void connect() {
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}

