package com.sena.sisga.dao;

import com.sena.sisga.conexion.Conexion;
import com.sena.sisga.model.Horario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de la tabla HORARIO.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class HorarioDAO {

    // 1. INSERTAR
    public boolean insertar(Horario horario) {
        String sql = "INSERT INTO HORARIO (id_asignatura, dia_semana, hora_inicio, hora_fin, aula) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, horario.getIdAsignatura());
            ps.setString(2, horario.getDiaSemana());
            ps.setTime(3, Time.valueOf(horario.getHoraInicio()));
            ps.setTime(4, Time.valueOf(horario.getHoraFin()));
            ps.setString(5, horario.getAula());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar horario: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTAR TODOS
    public List<Horario> listar() {
        List<Horario> lista = new ArrayList<>();
        String sql = "SELECT * FROM HORARIO";

        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Horario h = new Horario();
                h.setIdHorario(rs.getInt("id_horario"));
                h.setIdAsignatura(rs.getInt("id_asignatura"));
                h.setDiaSemana(rs.getString("dia_semana"));
                h.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
                h.setHoraFin(rs.getTime("hora_fin").toLocalTime());
                h.setAula(rs.getString("aula"));
                lista.add(h);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar horarios: " + e.getMessage());
        }
        return lista;
    }

    // 3. ACTUALIZAR
    public boolean actualizar(Horario horario) {
        String sql = "UPDATE HORARIO SET id_asignatura=?, dia_semana=?, hora_inicio=?, hora_fin=?, aula=? WHERE id_horario=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, horario.getIdAsignatura());
            ps.setString(2, horario.getDiaSemana());
            ps.setTime(3, Time.valueOf(horario.getHoraInicio()));
            ps.setTime(4, Time.valueOf(horario.getHoraFin()));
            ps.setString(5, horario.getAula());
            ps.setInt(6, horario.getIdHorario());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar horario: " + e.getMessage());
            return false;
        }
    }

    // 4. ELIMINAR
    public boolean eliminar(int idHorario) {
        String sql = "DELETE FROM HORARIO WHERE id_horario = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idHorario);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar horario: " + e.getMessage());
            return false;
        }
    }
}