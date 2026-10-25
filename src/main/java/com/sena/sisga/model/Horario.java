package com.sena.sisga.model;

import java.time.LocalTime;

/**
 * Clase que representa un Horario en el sistema SISGA.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class Horario {

    private int idHorario;
    private int idAsignatura;
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String aula;

    public Horario() {
    }

    public Horario(int idAsignatura, String diaSemana, LocalTime horaInicio, LocalTime horaFin, String aula) {
        this.idAsignatura = idAsignatura;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aula = aula;
    }

    // Getters y Setters
    public int getIdHorario() { return idHorario; }
    public void setIdHorario(int idHorario) { this.idHorario = idHorario; }

    public int getIdAsignatura() { return idAsignatura; }
    public void setIdAsignatura(int idAsignatura) { this.idAsignatura = idAsignatura; }

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }

    @Override
    public String toString() {
        return "Horario{" +
                "id=" + idHorario +
                ", idAsignatura=" + idAsignatura +
                ", dia='" + diaSemana + '\'' +
                ", inicio=" + horaInicio +
                ", fin=" + horaFin +
                ", aula='" + aula + '\'' +
                '}';
    }
}
