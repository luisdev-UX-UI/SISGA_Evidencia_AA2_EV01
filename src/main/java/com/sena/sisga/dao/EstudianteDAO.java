package com.sena.sisga.dao;

import com.sena.sisga.conexion.Conexion;
import com.sena.sisga.model.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de la tabla ESTUDIANTE.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class EstudianteDAO {

    // 1. INSERTAR
    public boolean insertar(Estudiante estudiante) {
        String sql = "INSERT INTO ESTUDIANTE (id_usuario, codigo_estudiante, fecha_ingreso, estado) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, estudiante.getIdUsuario());
            ps.setString(2, estudiante.getCodigoEstudiante());
            ps.setDate(3, Date.valueOf(estudiante.getFechaIngreso()));
            ps.setString(4, estudiante.getEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar estudiante: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTAR TODOS
    public List<Estudiante> listar() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM ESTUDIANTE";

        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Estudiante e = new Estudiante();
                e.setIdEstudiante(rs.getInt("id_estudiante"));
                e.setIdUsuario(rs.getInt("id_usuario"));
                e.setCodigoEstudiante(rs.getString("codigo_estudiante"));
                e.setFechaIngreso(rs.getDate("fecha_ingreso").toLocalDate());
                e.setEstado(rs.getString("estado"));
                lista.add(e);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar estudiantes: " + e.getMessage());
        }
        return lista;
    }

    // 3. ACTUALIZAR
    public boolean actualizar(Estudiante estudiante) {
        String sql = "UPDATE ESTUDIANTE SET id_usuario=?, codigo_estudiante=?, fecha_ingreso=?, estado=? WHERE id_estudiante=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, estudiante.getIdUsuario());
            ps.setString(2, estudiante.getCodigoEstudiante());
            ps.setDate(3, Date.valueOf(estudiante.getFechaIngreso()));
            ps.setString(4, estudiante.getEstado());
            ps.setInt(5, estudiante.getIdEstudiante());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar estudiante: " + e.getMessage());
            return false;
        }
    }

    // 4. ELIMINAR
    public boolean eliminar(int idEstudiante) {
        String sql = "DELETE FROM ESTUDIANTE WHERE id_estudiante = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEstudiante);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar estudiante: " + e.getMessage());
            return false;
        }
    }
}