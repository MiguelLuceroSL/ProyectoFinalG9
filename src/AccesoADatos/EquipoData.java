package AccesoADatos;

import Entidades.Equipo;
import Entidades.EquipoMiembro;
import Entidades.Miembro;
import Entidades.Proyecto;
import Entidades.Tarea;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EquipoData {

    private Connection con = null;
    private Conexion conexion;

    public EquipoData() {

        con = Conexion.getConexion();

    }

    public void guardarEquipo(Equipo equipo) {
        try {
            String sql = "INSERT INTO equipo(idProyecto, nombreE, fechaCreacion, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, equipo.getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, Date.valueOf(equipo.getFechaCreacion()));
            ps.setBoolean(4, equipo.isEstado());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Equipo creado con exitoso");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                equipo.setIdEquipo(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla Equipo " + ex.getMessage());
        }
    }

    public void infoDeEquipo(int idEq) {
        Equipo equipo = new Equipo();
        EquipoMiembro eqm = new EquipoMiembro();
        Miembro miembro = new Miembro();
        Tarea tarea = new Tarea();
        Proyecto proy = new Proyecto();
//       String sql="SELECT M.nombreM AS 'Nombre del Miembro', T.nombreT AS 'Tarea asignada' \n" +
//"FROM equipo AS E \n" +
//"JOIN equipomiembros AS EM ON E.idEquipo = EM.idEquipo \n" +
//"JOIN miembro AS M ON EM.idMiembro = M.idMiembro \n" +
//"JOIN tarea AS T ON EM.idMiembroEq = T.idMiembroEq WHERE E.idEquipo=?;";
        String sql = "SELECT M.nombreM AS 'Nombre del Miembro', M.apellido AS 'Apellido', M.dni AS 'DNI',\n" +
"       GROUP_CONCAT(T.nombreT  SEPARATOR ' -  ') AS 'Tareas asignadas', E.fechaCreacion AS 'Fecha de Creación',\n" +
"       EM.fechaIncorporacion AS 'Fecha de Incorporación'\n" +
"FROM equipo AS E\n" +
"JOIN equipomiembros AS EM ON E.idEquipo = EM.idEquipo\n" +
"JOIN miembro AS M ON EM.idMiembro = M.idMiembro\n" +
"JOIN tarea AS T ON EM.idMiembroEq = T.idMiembroEq\n" +
"WHERE E.idEquipo = ?\n" +
"GROUP BY M.idMiembro;";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEq);
            ResultSet rs = ps.executeQuery();
            int contador = 0;
            while (rs.next()) {
               
                miembro = new Miembro();
                miembro.setNombre(rs.getString("nombreM"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setDni(rs.getInt("dni"));
                tarea = new Tarea();
                tarea.setNombre(rs.getString("Tareas asignadas"));

//                equipo = new Equipo();
//                equipo.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());

                eqm = new EquipoMiembro();
          
                eqm.setFechaIncorporacion(rs.getDate("fechaIncorporacion").toLocalDate());

             

                    contador++;

        System.out.println("Nombre del Miembro:       " + miembro.getNombre());
        System.out.println("Apellido del Miembro:     " + miembro.getApellido());
        System.out.println("DNI del Miembro:          " + miembro.getDni());
        System.out.println("Tareas asignadas:         " + tarea.getNombre());
        System.out.println("Fecha de Incorporación:   " + eqm.getFechaIncorporacion());
                  
                }
            

            rs.close();

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

    }
          public  List<Equipo>listaEquipo(){
         List<Equipo> listaEq = new ArrayList<>();
        try {
            String sql = "SELECT * FROM equipo";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                Equipo equipo = new Equipo();
                equipo.setIdProyecto(rs.getInt("idProyecto"));
                equipo.setIdEquipo(rs.getInt("idEquipo"));
                equipo.setNombre(rs.getString("nombreE"));
                equipo.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
                equipo.setEstado(rs.getBoolean("estado"));
                listaEq.add(equipo);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        return listaEq;
    }
    
}
