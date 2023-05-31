/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Proyecto;
import java.sql.Connection;

/**
 *
 * @author edu-1
 */
public class ProyectoData {
    
    public ProyectoData(){
        
        Connection con = Conexion.getConexion();
        
    }
    
    public  void guardarProyecto(Proyecto proyecto) {
        
        
    }
}
