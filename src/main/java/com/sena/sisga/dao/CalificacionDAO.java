package com.sena.sisga.dao;

import com.sena.sisga.conexion.Conexion;
import com.sena.sisga.model.Calificacion;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de la tabla CALIFICACION.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class CalificacionDAO {

    // 1. INSERTAR
    public boolean insertar(Calificacion calificacion) {
        String sql = "INSERT INTO CALIFICACION (id_matricula, nota_parcial_1, nota_parcial_2, nota_final, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, calificacion.getIdMatricula());
            ps.setBigDecimal(2, calificacion.getNotaParcial1());
            ps.setBigDecimal(3, calificacion.getNotaParcial2());
            ps.setBigDecimal(4, calificacion.getNotaFinal());
            ps.setString(5, calificacion.getEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar calificación: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTAR TODOS
    public List<Calificacion> listar() {
        List<Calificacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM CALIFICACION";

        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Calificacion c = new Calificacion();
                c.setIdCalificacion(rs.getInt("id_calificacion"));
                c.setIdMatricula(rs.getInt("id_matricula"));
                c.setNotaParcial1(rs.getBigDecimal("nota_parcial_1"));
                c.setNotaParcial2(rs.getBigDecimal("nota_parcial_2"));
                c.setNotaFinal(rs.getBigDecimal("nota_final"));
                c.setEstado(rs.getString("estado"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar calificaciones: " + e.getMessage());
        }
        return lista;
    }

    // 3. ACTUALIZAR
    public boolean actualizar(Calificacion calificacion) {
        String sql = "UPDATE CALIFICACION SET id_matricula=?, nota_parcial_1=?, nota_parcial_2=?, nota_final=?, estado=? WHERE id_calificacion=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, calificacion.getIdMatricula());
            ps.setBigDecimal(2, calificacion.getNotaParcial1());
            ps.setBigDecimal(3, calificacion.getNotaParcial2());
            ps.setBigDecimal(4, calificacion.getNotaFinal());
            ps.setString(5, calificacion.getEstado());
            ps.setInt(6, calificacion.getIdCalificacion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar calificación: " + e.getMessage());
            return false;
        }
    }

    // 4. ELIMINAR
    public boolean eliminar(int idCalificacion) {
        String sql = "DELETE FROM CALIFICACION WHERE id_calificacion = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCalificacion);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar calificación: " + e.getMessage());
            return false;
        }
    }
}