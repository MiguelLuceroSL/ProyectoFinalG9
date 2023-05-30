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
public class Comentario {
    private int idCometario;
    private String comentario;
     private LocalDate fechaAvance;
     private int idTarea;

    public Comentario(int idCometario, String comentario, LocalDate fechaAvance, int idTarea) {
        this.idCometario = idCometario;
        this.comentario = comentario;
        this.fechaAvance = fechaAvance;
        this.idTarea = idTarea;
    }

    public Comentario() {
    }

    public int getIdCometario() {
        return idCometario;
    }

    public void setIdCometario(int idCometario) {
        this.idCometario = idCometario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaAvance() {
        return fechaAvance;
    }

    public void setFechaAvance(LocalDate fechaAvance) {
        this.fechaAvance = fechaAvance;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }
     
}
