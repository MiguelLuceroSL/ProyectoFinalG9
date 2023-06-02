package Entidades;

import java.time.LocalDate;

public class EquipoMiembro {

    private int idMiembroEq;
    private Equipo idEquipo;
    private Miembro idMiembro;
    private LocalDate fechaIncorporacion;

    public EquipoMiembro() {
    }
    
    public EquipoMiembro(Equipo idEquipo, Miembro idMiembro, LocalDate fechaIncorporacion) {
        this.idEquipo = idEquipo;
        this.idMiembro = idMiembro;
        this.fechaIncorporacion = fechaIncorporacion;
    }
    
    public EquipoMiembro(int idMiembroEq, Equipo idEquipo, Miembro idMiembro, LocalDate fechaIncorporacion) {
        this.idMiembroEq = idMiembroEq;
        this.idEquipo = idEquipo;
        this.idMiembro = idMiembro;
        this.fechaIncorporacion = fechaIncorporacion;
    }
    
    public int getIdMiembroEq() {
        return idMiembroEq;
    }

    public void setIdMiembroEq(int idMiembroEq) {
        this.idMiembroEq = idMiembroEq;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Miembro getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Miembro idMiembro) {
        this.idMiembro = idMiembro;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        return "idMiembroEq= " + idMiembroEq + ", idEquipo= " + idEquipo + ", idMiembro= " + idMiembro + ", fechaIncorporacion= " + fechaIncorporacion;
    }

}
