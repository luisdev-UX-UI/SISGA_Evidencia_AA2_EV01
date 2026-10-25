package com.sena.sisga.main;

import com.sena.sisga.conexion.Conexion;
import com.sena.sisga.dao.*;
import com.sena.sisga.model.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Clase principal para probar el CRUD completo de las entidades del SISGA.
 *
 * @author Luis Rodrigo Enriquez Olaya
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("  SISTEMA DE GESTIÓN ACADÉMICA - SISGA");
        System.out.println("  Prueba de CRUD Completo (JDBC/MariaDB)");
        System.out.println("=========================================\n");

        Conexion.getConexion();

        // --- 1. PRUEBA CRUD MATRÍCULA ---
        System.out.println("\n>>> CRUD MATRÍCULA <<<");
        MatriculaDAO matriculaDAO = new MatriculaDAO();

        System.out.println("Insertando nueva matrícula...");
        Matricula nuevaMatricula = new Matricula(1, 1, "2026-2", LocalDate.now(), "activa");
        matriculaDAO.insertar(nuevaMatricula);

        System.out.println("\n--- Lista de Matrículas (Antes de Actualizar) ---");
        List<Matricula> listaM = matriculaDAO.listar();
        for (Matricula m : listaM) {
            System.out.println(m.toString());
        }

        if (!listaM.isEmpty()) {
            Matricula mUpdate = listaM.getFirst();
            mUpdate.setEstado("cancelada");
            matriculaDAO.actualizar(mUpdate);
            System.out.println("\n✅ Matrícula actualizada (ID: " + mUpdate.getIdMatricula() + " a estado 'cancelada')");

            Matricula mDelete = listaM.getLast();
            matriculaDAO.eliminar(mDelete.getIdMatricula());
            System.out.println("✅ Matrícula eliminada (ID: " + mDelete.getIdMatricula() + ")");
        }

        // --- 2. PRUEBA CRUD ESTUDIANTE ---
        System.out.println("\n>>> CRUD ESTUDIANTE <<<");
        EstudianteDAO estudianteDAO = new EstudianteDAO();

        System.out.println("Insertando nuevo estudiante...");
        Estudiante nuevoEst = new Estudiante(1, "EST-999", LocalDate.now(), "activo");
        estudianteDAO.insertar(nuevoEst);

        System.out.println("\n--- Lista de Estudiantes (Antes de Actualizar) ---");
        List<Estudiante> listaE = estudianteDAO.listar();
        for (Estudiante e : listaE) {
            System.out.println(e.toString());
        }

        if (!listaE.isEmpty()) {
            Estudiante eUpdate = listaE.get(0);
            eUpdate.setEstado("inactivo");
            estudianteDAO.actualizar(eUpdate);
            System.out.println("\n✅ Estudiante actualizado (ID: " + eUpdate.getIdEstudiante() + " a estado 'inactivo')");

            Estudiante eDelete = listaE.get(listaE.size() - 1);
            estudianteDAO.eliminar(eDelete.getIdEstudiante());
            System.out.println("✅ Estudiante eliminado (ID: " + eDelete.getIdEstudiante() + ")");
        }

        // --- 3. PRUEBA CRUD DOCENTE ---
        System.out.println("\n>>> CRUD DOCENTE <<<");
        DocenteDAO docenteDAO = new DocenteDAO();

        System.out.println("Insertando nuevo docente...");
        Docente nuevoDoc = new Docente(2, "DOC-999", "Sistemas", LocalDate.now());
        docenteDAO.insertar(nuevoDoc);

        System.out.println("\n--- Lista de Docentes (Antes de Actualizar) ---");
        List<Docente> listaD = docenteDAO.listar();
        for (Docente d : listaD) {
            System.out.println(d.toString());
        }

        if (!listaD.isEmpty()) {
            Docente dUpdate = listaD.get(0);
            dUpdate.setEspecialidad("Ingeniería de Software");
            docenteDAO.actualizar(dUpdate);
            System.out.println("\n✅ Docente actualizado (ID: " + dUpdate.getIdDocente() + " a especialidad 'Ingeniería de Software')");

            Docente dDelete = listaD.get(listaD.size() - 1);
            docenteDAO.eliminar(dDelete.getIdDocente());
            System.out.println("✅ Docente eliminado (ID: " + dDelete.getIdDocente() + ")");
        }

        // --- 4. PRUEBA CRUD ASIGNATURA ---
        System.out.println("\n>>> CRUD ASIGNATURA <<<");
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

        System.out.println("Insertando nueva asignatura...");
        Asignatura nuevaAsig = new Asignatura(1, "TEST-999", "Prueba", 3, "Prueba de CRUD");
        asignaturaDAO.insertar(nuevaAsig);

        System.out.println("\n--- Lista de Asignaturas (Antes de Actualizar) ---");
        List<Asignatura> listaA = asignaturaDAO.listar();
        for (Asignatura a : listaA) {
            System.out.println(a.toString());
        }

        if (!listaA.isEmpty()) {
            Asignatura aUpdate = listaA.get(0);
            aUpdate.setCreditos(5);
            asignaturaDAO.actualizar(aUpdate);
            System.out.println("\n✅ Asignatura actualizada (ID: " + aUpdate.getIdAsignatura() + " a 5 créditos)");

            Asignatura aDelete = listaA.get(listaA.size() - 1);
            asignaturaDAO.eliminar(aDelete.getIdAsignatura());
            System.out.println("✅ Asignatura eliminada (ID: " + aDelete.getIdAsignatura() + ")");
        }

        // --- 5. PRUEBA CRUD CALIFICACION ---
        System.out.println("\n>>> CRUD CALIFICACION <<<");
        CalificacionDAO calificacionDAO = new CalificacionDAO();

        System.out.println("Insertando nueva calificación...");
        Calificacion nuevaCal = new Calificacion(2, new BigDecimal("3.0"), new BigDecimal("3.0"), new BigDecimal("3.0"), "reprobado");
        calificacionDAO.insertar(nuevaCal);

        System.out.println("\n--- Lista de Calificaciones (Antes de Actualizar) ---");
        List<Calificacion> listaC = calificacionDAO.listar();
        for (Calificacion c : listaC) {
            System.out.println(c.toString());
        }

        if (!listaC.isEmpty()) {
            Calificacion cUpdate = listaC.get(0);
            cUpdate.setNotaFinal(new BigDecimal("4.8"));
            cUpdate.setEstado("aprobado");
            calificacionDAO.actualizar(cUpdate);
            System.out.println("\n✅ Calificación actualizada (ID: " + cUpdate.getIdCalificacion() + " a nota 4.8)");

            Calificacion cDelete = listaC.get(listaC.size() - 1);
            calificacionDAO.eliminar(cDelete.getIdCalificacion());
            System.out.println("✅ Calificación eliminada (ID: " + cDelete.getIdCalificacion() + ")");
        }

        // --- 6. PRUEBA CRUD HORARIO ---
        System.out.println("\n>>> CRUD HORARIO <<<");
        HorarioDAO horarioDAO = new HorarioDAO();

        System.out.println("Insertando nuevo horario...");
        Horario nuevoHor = new Horario(1, "VIERNES", LocalTime.of(14, 0), LocalTime.of(16, 0), "Aula 404");
        horarioDAO.insertar(nuevoHor);

        System.out.println("\n--- Lista de Horarios (Antes de Actualizar) ---");
        List<Horario> listaH = horarioDAO.listar();
        for (Horario h : listaH) {
            System.out.println(h.toString());
        }

        if (!listaH.isEmpty()) {
            Horario hUpdate = listaH.get(0);
            hUpdate.setAula("Aula 101");
            horarioDAO.actualizar(hUpdate);
            System.out.println("\n✅ Horario actualizado (ID: " + hUpdate.getIdHorario() + " a 'Aula 101')");

            Horario hDelete = listaH.get(listaH.size() - 1);
            horarioDAO.eliminar(hDelete.getIdHorario());
            System.out.println("✅ Horario eliminado (ID: " + hDelete.getIdHorario() + ")");
        }

        // --- FIN DE PRUEBAS ---
        Conexion.cerrarConexion();
        System.out.println("\n=========================================");
        System.out.println("  FIN DE LA PRUEBA");
        System.out.println("=========================================");
    }
}