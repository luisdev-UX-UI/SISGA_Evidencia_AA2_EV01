package com.sena.sisga.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Clase que representa una Calificación en el sistema SISGA.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class Calificacion {

    private int idCalificacion;
    private int idMatricula;
    private BigDecimal notaParcial1;
    private BigDecimal notaParcial2;
    private BigDecimal notaFinal;
    private String estado;

    public Calificacion() {
    }

    public Calificacion(int idMatricula, BigDecimal notaParcial1, BigDecimal notaParcial2, BigDecimal notaFinal, String estado) {
        this.idMatricula = idMatricula;
        this.notaParcial1 = notaParcial1;
        this.notaParcial2 = notaParcial2;
        this.notaFinal = notaFinal;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdCalificacion() { return idCalificacion; }
    public void setIdCalificacion(int idCalificacion) { this.idCalificacion = idCalificacion; }

    public int getIdMatricula() { return idMatricula; }
    public void setIdMatricula(int idMatricula) { this.idMatricula = idMatricula; }

    public BigDecimal getNotaParcial1() { return notaParcial1; }
    public void setNotaParcial1(BigDecimal notaParcial1) { this.notaParcial1 = notaParcial1; }

    public BigDecimal getNotaParcial2() { return notaParcial2; }
    public void setNotaParcial2(BigDecimal notaParcial2) { this.notaParcial2 = notaParcial2; }

    public BigDecimal getNotaFinal() { return notaFinal; }
    public void setNotaFinal(BigDecimal notaFinal) { this.notaFinal = notaFinal; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Calificacion{" +
                "id=" + idCalificacion +
                ", idMatricula=" + idMatricula +
                ", parcial1=" + notaParcial1 +
                ", parcial2=" + notaParcial2 +
                ", final=" + notaFinal +
                ", estado='" + estado + '\'' +
                '}';
    }
}