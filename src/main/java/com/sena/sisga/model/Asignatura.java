package com.sena.sisga.model;

/**
 * Clase que representa una Asignatura en el sistema SISGA.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class Asignatura {

    private int idAsignatura;
    private int idDocente;
    private String codigoAsignatura;
    private String nombre;
    private int creditos;
    private String descripcion;

    public Asignatura() {
    }

    public Asignatura(int idDocente, String codigoAsignatura, String nombre, int creditos, String descripcion) {
        this.idDocente = idDocente;
        this.codigoAsignatura = codigoAsignatura;
        this.nombre = nombre;
        this.creditos = creditos;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdAsignatura() { return idAsignatura; }
    public void setIdAsignatura(int idAsignatura) { this.idAsignatura = idAsignatura; }

    public int getIdDocente() { return idDocente; }
    public void setIdDocente(int idDocente) { this.idDocente = idDocente; }

    public String getCodigoAsignatura() { return codigoAsignatura; }
    public void setCodigoAsignatura(String codigoAsignatura) { this.codigoAsignatura = codigoAsignatura; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + idAsignatura +
                ", idDocente=" + idDocente +
                ", codigo='" + codigoAsignatura + '\'' +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}