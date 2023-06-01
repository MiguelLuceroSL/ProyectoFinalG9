package AccesoADatos;

import Entidades.Miembro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MiembroData {

    private Connection con = null;
    private Conexion conexion;

    public MiembroData() {

        con = Conexion.getConexion();

    }

    public void guardarMiembro(Miembro miembro) {
        try {
            String sql = "INSERT INTO miembro(dni, apellido, nombre, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, miembro.getDni());
            ps.setString(2, miembro.getApellido());
            ps.setString(3, miembro.getNombre());
            ps.setBoolean(4, miembro.isEstado());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Miembro cargado con exito.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                miembro.setIdMiembro(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla Miembro" + ex.getMessage());
        }
    }
}
