package AccesoADatos;

import Entidades.Tarea;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class TareaData {

    private Connection con = null;
    private Conexion conexion;

    public TareaData() {

        con = Conexion.getConexion();

    }

    public void guardarTarea(Tarea tarea) {
        try {
            String sql = "INSERT INTO tarea(nombre, fechaCreacion, fechaCierre, estado, idMiembroEq) VALUES (?,?,?,?,?)";
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
    
    public void actualizarEstadoTarea(int estado, int id){
        try{
            String sql = "UPDATE tarea SET estado=? WHERE idTarea=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id);
            int exito = ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Estado modificado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el estado.");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR "+ex.getMessage());
        }
    }
}
