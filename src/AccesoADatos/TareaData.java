package AccesoADatos;

import Entidades.Equipo;
import Entidades.EquipoMiembro;
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

public class TareaData {

    private Connection con = null;
    private Conexion conexion;

    public TareaData() {

        con = Conexion.getConexion();

    }

    public void guardarTarea(Tarea tarea) {
        try {
            String sql = "INSERT INTO tarea(nombreT, fechaCreacion, fechaCierre, estado, idMiembroEq) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tarea.getNombre());
            ps.setDate(2, Date.valueOf(tarea.getFechaCreacion()));
            ps.setDate(3, Date.valueOf(tarea.getFechaCierre()));
            ps.setInt(4, tarea.getEstado());
            ps.setInt(5, tarea.getIdMiembroEq());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Tarea cargada con exito.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                tarea.setIdTarea(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla Tarea" + ex.getMessage());
        }
    }

    public void actualizarEstadoTarea(int estado, int id) {
        try {
            String sql = "UPDATE tarea SET estado=? WHERE idTarea=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Estado modificado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el estado.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR " + ex.getMessage());
        }
    }

    public void areasDeproyecto(int id) {

        Equipo equipo = new Equipo();
        EquipoMiembro eqm = new EquipoMiembro();
        Tarea tarea = new Tarea();
        Proyecto proy = new Proyecto();
        try {

//         String sql = "SELECT P.nombre AS 'Proyecto', T.nombre AS 'Tarea', T.estado "
//                 + "AS 'Estado', EM.idMiembro AS 'Miembro del Equipo' FROM Proyecto"
//                 + " AS P JOIN Equipo AS E ON P.idProyecto = E.idProyecto JOIN EquipoMiembros "
//                 + "AS EM ON E.idEquipo = EM.idEquipo JOIN Tarea AS T ON EM.idMiembroEq = T.idMiembroEq WHERE "
//                 + "T.estado = 0 OR T.estado=1 AND EM.idMiembro = 1  and P.idProyecto= ?;";
//            String sql = "SELECT P.nombre AS 'Proyecto', T.nombre AS 'Tarea', T.estado AS 'Estado', EM.idMiembro AS 'Miembro del Equipo'\n"
//                    + "FROM proyecto AS P\n"
//                    + "JOIN equipo AS E ON P.idProyecto = E.idProyecto\n"
//                    + "JOIN equipomiembros AS EM ON E.idEquipo = EM.idEquipo\n"
//                    + "JOIN tarea AS T ON EM.idMiembroEq = T.idMiembroEq\n"
//                    + "WHERE T.estado = 1 AND EM.idMiembro = 1;";
            String sql = "SELECT  P.idProyecto AS 'Proyecto', P.nombreP AS 'Proyecto',T.nombreT AS 'Tarea', T.estado AS 'Estado', EM.idMiembro AS 'Miembro del Equipo', E.nombreE AS 'Equipo'\n"
                    + "                                         FROM proyecto AS P \n"
                    + "                                       JOIN equipo AS E ON P.idProyecto = E.idProyecto \n"
                    + "                                     JOIN equipomiembros AS EM ON E.idEquipo = EM.idEquipo \n"
                    + "                                      JOIN tarea AS T ON EM.idMiembroEq = T.idMiembroEq WHERE P.idProyecto= ? AND  T.estado=0 OR T.estado=1  ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            int contador = 0;
            while (rs.next()) {

                proy = new Proyecto();
                proy.setIdProyecto(rs.getInt("idProyecto"));
                proy.setNombre(rs.getString("nombreP"));

                if (proy.getIdProyecto() == id) {

                    tarea = new Tarea();
                    tarea.setNombre(rs.getString("nombreT"));
                    tarea.setEstado(rs.getInt("estado"));

                    eqm = new EquipoMiembro();
                    eqm.setIdMiembro(rs.getInt("idMiembro"));

                    equipo = new Equipo();
                    equipo.setNombre(rs.getString("nombreE"));
                    contador++;

                    System.out.println("Nombre de Proyecto: " + proy.getNombre());

                    System.out.println("Tarea del Proyecto:   " + tarea.getNombre());
                    System.out.println("Estado de la Tarea:   " + tarea.getEstado());
                    System.out.println("iD de Miembro:          " + eqm.getIdMiembro());

                    System.out.println("Nombre de Equipo:   " + equipo.getNombre());
                }
            }

            rs.close();

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

    }
}
