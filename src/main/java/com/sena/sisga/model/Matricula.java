package com.sena.sisga.model;

import java.time.LocalDate;

/**
 * Clase que representa una Matrícula en el sistema SISGA.
 * Aplica encapsulamiento (atributos privados).
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class Matricula {

    // Atributos privados (Encapsulamiento)
    private int idMatricula;
    private int idEstudiante;
    private int idAsignatura;
    private String periodo;
    private LocalDate fechaMatricula; // Usamos LocalDate para manejar fechas en Java
    private String estado;

    // Constructor vacío
    public Matricula() {
    }

    // Constructor con parámetros (sin idMatricula porque es AutoIncrement)
    public Matricula(int idEstudiante, int idAsignatura, String periodo, LocalDate fechaMatricula, String estado) {
        this.idEstudiante = idEstudiante;
        this.idAsignatura = idAsignatura;
        this.periodo = periodo;
        this.fechaMatricula = fechaMatricula;
        this.estado = estado;
    }

    // --- Métodos Getters y Setters ---

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + idMatricula +
                ", idEstudiante=" + idEstudiante +
                ", idAsignatura=" + idAsignatura +
                ", periodo='" + periodo + '\'' +
                ", fecha=" + fechaMatricula +
                ", estado='" + estado + '\'' +
                '}';
    }
}