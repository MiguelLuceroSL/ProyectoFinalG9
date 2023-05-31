package proyectofinalg9;

import AccesoADatos.Conexion;
import AccesoADatos.ProyectoData;
import Entidades.Proyecto;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProyectoFinalG9 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Conexion.getConexion();
        LocalDate fecha = LocalDate.now();
        Proyecto proy = new Proyecto("App Moviles", "Proyectos donde se realizaran app moviles", fecha, true);
        ProyectoData proyD = new ProyectoData();
        try{
        proyD.guardarProyecto(proy);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ex.getMessage());
        }
    }
}
