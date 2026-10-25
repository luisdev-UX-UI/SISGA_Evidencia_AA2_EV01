package com.sena.sisga.dao;

import com.sena.sisga.conexion.Conexion;
import com.sena.sisga.model.Asignatura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de la tabla ASIGNATURA.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class AsignaturaDAO {

    // 1. INSERTAR
    public boolean insertar(Asignatura asignatura) {
        String sql = "INSERT INTO ASIGNATURA (id_docente, codigo_asignatura, nombre, creditos, descripcion) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, asignatura.getIdDocente());
            ps.setString(2, asignatura.getCodigoAsignatura());
            ps.setString(3, asignatura.getNombre());
            ps.setInt(4, asignatura.getCreditos());
            ps.setString(5, asignatura.getDescripcion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar asignatura: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTAR TODOS
    public List<Asignatura> listar() {
        List<Asignatura> lista = new ArrayList<>();
        String sql = "SELECT * FROM ASIGNATURA";

        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Asignatura a = new Asignatura();
                a.setIdAsignatura(rs.getInt("id_asignatura"));
                a.setIdDocente(rs.getInt("id_docente"));
                a.setCodigoAsignatura(rs.getString("codigo_asignatura"));
                a.setNombre(rs.getString("nombre"));
                a.setCreditos(rs.getInt("creditos"));
                a.setDescripcion(rs.getString("descripcion"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar asignaturas: " + e.getMessage());
        }
        return lista;
    }

    // 3. ACTUALIZAR
    public boolean actualizar(Asignatura asignatura) {
        String sql = "UPDATE ASIGNATURA SET id_docente=?, codigo_asignatura=?, nombre=?, creditos=?, descripcion=? WHERE id_asignatura=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, asignatura.getIdDocente());
            ps.setString(2, asignatura.getCodigoAsignatura());
            ps.setString(3, asignatura.getNombre());
            ps.setInt(4, asignatura.getCreditos());
            ps.setString(5, asignatura.getDescripcion());
            ps.setInt(6, asignatura.getIdAsignatura());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar asignatura: " + e.getMessage());
            return false;
        }
    }

    // 4. ELIMINAR
    public boolean eliminar(int idAsignatura) {
        String sql = "DELETE FROM ASIGNATURA WHERE id_asignatura = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idAsignatura);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar asignatura: " + e.getMessage());
            return false;
        }
    }
}