package com.sena.sisga.model;

import java.time.LocalDate;

/**
 * Clase que representa un Estudiante en el sistema SISGA.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class Estudiante {

    private int idEstudiante;
    private int idUsuario;
    private String codigoEstudiante;
    private LocalDate fechaIngreso;
    private String estado;

    public Estudiante() {
    }

    public Estudiante(int idUsuario, String codigoEstudiante, LocalDate fechaIngreso, String estado) {
        this.idUsuario = idUsuario;
        this.codigoEstudiante = codigoEstudiante;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdEstudiante() { return idEstudiante; }
    public void setIdEstudiante(int idEstudiante) { this.idEstudiante = idEstudiante; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getCodigoEstudiante() { return codigoEstudiante; }
    public void setCodigoEstudiante(String codigoEstudiante) { this.codigoEstudiante = codigoEstudiante; }

    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + idEstudiante +
                ", idUsuario=" + idUsuario +
                ", codigo='" + codigoEstudiante + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", estado='" + estado + '\'' +
                '}';
    }
}