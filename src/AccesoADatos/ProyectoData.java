package AccesoADatos;

import Entidades.Proyecto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ProyectoData {

    private Connection con = null;
    private Conexion conexion;

    public ProyectoData() {
        con = Conexion.getConexion();
    }

    public void guardarProyecto(Proyecto proyecto) {
        try {
            String sql = "INSERT INTO proyecto(nombre, descripcion, fechaInicio, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            ps.setDate(3, Date.valueOf(proyecto.getFechaInicio()));
            ps.setBoolean(4, proyecto.isEstado());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Proyecto creado con exito.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                proyecto.setIdProyecto(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla Proyecto" + ex.getMessage());
        }
    }
}
