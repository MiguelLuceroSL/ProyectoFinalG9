/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author edu-1
 */
public class Tarea {

    private int idTarea;
    private int idMiembroEq;
    private String nombre;
    private LocalDate fechaCreacion;
    private LocalDate fechaCierre;

    private int estado;

    public Tarea() {
    }
    
    public Tarea(int idMiembroEq, String nombre, LocalDate fechaCierre, LocalDate fechaCreacion, int estado) {
        this.idMiembroEq = idMiembroEq;
        this.nombre = nombre;
        this.fechaCierre = fechaCierre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Tarea(int idTarea, int idMiembroEq, String nombre, LocalDate fechaCierre, LocalDate fechaCreacion, int estado) {
        this.idTarea = idTarea;
        this.idMiembroEq = idMiembroEq;
        this.nombre = nombre;
        this.fechaCierre = fechaCierre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public int getIdMiembroEq() {
        return idMiembroEq;
    }

    public void setIdMiembroEq(int idMiembroEq) {
        this.idMiembroEq = idMiembroEq;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
