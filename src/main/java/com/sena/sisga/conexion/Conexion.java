package com.sena.sisga.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión a la base de datos MariaDB.
 * Aplica buenas prácticas de seguridad leyendo credenciales desde variables de entorno.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class Conexion {

    // 1. Leemos las variables de entorno. Si no existen, usamos valores por defecto para desarrollo local.
    // ¡OJO! Aquí ya NO va la contraseña real, solo un texto vacío como respaldo.
    private static final String URL = System.getenv().getOrDefault("DB_URL", "jdbc:mariadb://localhost:3307/sisga_db");
    private static final String USUARIO = System.getenv().getOrDefault("DB_USER", "sisga_user");
    private static final String CONTRASENA = System.getenv().getOrDefault("DB_PASSWORD", ""); // Vacío por seguridad

    private static Connection conexion = null;

    public static Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                // Cargar el driver oficial de MariaDB
                Class.forName("org.mariadb.jdbc.Driver");

                // Establecer la conexión (usando las variables de entorno)
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el driver de MariaDB. " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ Error de conexión a la BD: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("🔒 Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al cerrar la conexión: " + e.getMessage());
        }
    }
}