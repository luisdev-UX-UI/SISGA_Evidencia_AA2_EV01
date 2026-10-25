package com.sena.sisga.dao;

import com.sena.sisga.conexion.Conexion;
import com.sena.sisga.model.Matricula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para gestionar las operaciones CRUD
 * de la tabla MATRICULA en MySQL.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class MatriculaDAO {

    // 1. INSERTAR (Create)
    public boolean insertar(Matricula matricula) {
        String sql = "INSERT INTO MATRICULA (id_estudiante, id_asignatura, periodo, fecha_matricula, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, matricula.getIdEstudiante());
            ps.setInt(2, matricula.getIdAsignatura());
            ps.setString(3, matricula.getPeriodo());
            ps.setDate(4, Date.valueOf(matricula.getFechaMatricula())); // Convertimos LocalDate a java.sql.Date
            ps.setString(5, matricula.getEstado());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar matrícula: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTAR TODOS (Read)
    public List<Matricula> listar() {
        List<Matricula> lista = new ArrayList<>();
        String sql = "SELECT * FROM MATRICULA";

        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Matricula m = new Matricula();
                m.setIdMatricula(rs.getInt("id_matricula"));
                m.setIdEstudiante(rs.getInt("id_estudiante"));
                m.setIdAsignatura(rs.getInt("id_asignatura"));
                m.setPeriodo(rs.getString("periodo"));
                m.setFechaMatricula(rs.getDate("fecha_matricula").toLocalDate());
                m.setEstado(rs.getString("estado"));
                lista.add(m);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar matrículas: " + e.getMessage());
        }
        return lista;
    }

    // 3. ACTUALIZAR (Update)
    public boolean actualizar(Matricula matricula) {
        String sql = "UPDATE MATRICULA SET id_estudiante=?, id_asignatura=?, periodo=?, fecha_matricula=?, estado=? WHERE id_matricula=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, matricula.getIdEstudiante());
            ps.setInt(2, matricula.getIdAsignatura());
            ps.setString(3, matricula.getPeriodo());
            ps.setDate(4, Date.valueOf(matricula.getFechaMatricula()));
            ps.setString(5, matricula.getEstado());
            ps.setInt(6, matricula.getIdMatricula());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar matrícula: " + e.getMessage());
            return false;
        }
    }

    // 4. ELIMINAR (Delete)
    public boolean eliminar(int idMatricula) {
        String sql = "DELETE FROM MATRICULA WHERE id_matricula = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idMatricula);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar matrícula: " + e.getMessage());
            return false;
        }
    }
}
