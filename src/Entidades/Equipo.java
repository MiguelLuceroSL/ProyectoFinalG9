package Entidades;

import java.time.LocalDate;

public class Equipo {
     private Proyecto idProyecto;
        private int idEquipo;
    private String nombre;
 
    private LocalDate fechaCreacion;
    private boolean estado;

    public Equipo() {
    }
    
    public Equipo(Proyecto idProyecto, String nombre, LocalDate fechaCreacion, boolean estado) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Equipo(Proyecto idProyecto, int idEquipo, String nombre, LocalDate fechaCreacion, boolean estado) {
        this.idProyecto = idProyecto;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  "idProyecto= " + idProyecto + ", idEquipo= " + idEquipo + ", nombre= " + nombre + ", fechaCreacion= " + fechaCreacion + ", estado= " + estado;
    }
    
}
