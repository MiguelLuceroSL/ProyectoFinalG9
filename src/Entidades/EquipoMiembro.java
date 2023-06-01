package Entidades;

import java.time.LocalDate;

public class EquipoMiembro {

    private int idMiembroEq;
    private int idEquipo;
    private int idMiembro;
    private LocalDate fechaIncorporacion;

    public EquipoMiembro() {
    }
    
    public EquipoMiembro(int idEquipo, int idMiembro, LocalDate fechaIncorporacion) {
        this.idEquipo = idEquipo;
        this.idMiembro = idMiembro;
        this.fechaIncorporacion = fechaIncorporacion;
    }
    
    public EquipoMiembro(int idMiembroEq, int idEquipo, int idMiembro, LocalDate fechaIncorporacion) {
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

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

}
