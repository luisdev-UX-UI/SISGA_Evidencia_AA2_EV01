package com.sena.sisga.model;

import java.time.LocalDate;

/**
 * Clase que representa un Docente en el sistema SISGA.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class Docente {

    private int idDocente;
    private int idUsuario;
    private String codigoDocente;
    private String especialidad;
    private LocalDate fechaContratacion;

    public Docente() {
    }

    public Docente(int idUsuario, String codigoDocente, String especialidad, LocalDate fechaContratacion) {
        this.idUsuario = idUsuario;
        this.codigoDocente = codigoDocente;
        this.especialidad = especialidad;
        this.fechaContratacion = fechaContratacion;
    }

    // Getters y Setters
    public int getIdDocente() { return idDocente; }
    public void setIdDocente(int idDocente) { this.idDocente = idDocente; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getCodigoDocente() { return codigoDocente; }
    public void setCodigoDocente(String codigoDocente) { this.codigoDocente = codigoDocente; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    @Override
    public String toString() {
        return "Docente{" +
                "id=" + idDocente +
                ", idUsuario=" + idUsuario +
                ", codigo='" + codigoDocente + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                '}';
    }
}