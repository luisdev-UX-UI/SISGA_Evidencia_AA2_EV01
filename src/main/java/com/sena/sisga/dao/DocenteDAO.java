package com.sena.sisga.dao;

import com.sena.sisga.conexion.Conexion;
import com.sena.sisga.model.Docente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de la tabla DOCENTE.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class DocenteDAO {

    // 1. INSERTAR
    public boolean insertar(Docente docente) {
        String sql = "INSERT INTO DOCENTE (id_usuario, codigo_docente, especialidad, fecha_contratacion) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, docente.getIdUsuario());
            ps.setString(2, docente.getCodigoDocente());
            ps.setString(3, docente.getEspecialidad());
            ps.setDate(4, Date.valueOf(docente.getFechaContratacion()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar docente: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTAR TODOS
    public List<Docente> listar() {
        List<Docente> lista = new ArrayList<>();
        String sql = "SELECT * FROM DOCENTE";

        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Docente d = new Docente();
                d.setIdDocente(rs.getInt("id_docente"));
                d.setIdUsuario(rs.getInt("id_usuario"));
                d.setCodigoDocente(rs.getString("codigo_docente"));
                d.setEspecialidad(rs.getString("especialidad"));
                d.setFechaContratacion(rs.getDate("fecha_contratacion").toLocalDate());
                lista.add(d);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar docentes: " + e.getMessage());
        }
        return lista;
    }

    // 3. ACTUALIZAR
    public boolean actualizar(Docente docente) {
        String sql = "UPDATE DOCENTE SET id_usuario=?, codigo_docente=?, especialidad=?, fecha_contratacion=? WHERE id_docente=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, docente.getIdUsuario());
            ps.setString(2, docente.getCodigoDocente());
            ps.setString(3, docente.getEspecialidad());
            ps.setDate(4, Date.valueOf(docente.getFechaContratacion()));
            ps.setInt(5, docente.getIdDocente());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar docente: " + e.getMessage());
            return false;
        }
    }

    // 4. ELIMINAR
    public boolean eliminar(int idDocente) {
        String sql = "DELETE FROM DOCENTE WHERE id_docente = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idDocente);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar docente: " + e.getMessage());
            return false;
        }
    }
}