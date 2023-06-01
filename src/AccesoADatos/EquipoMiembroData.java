package AccesoADatos;

import Entidades.EquipoMiembro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class EquipoMiembroData {

    private Connection con = null;
    private Conexion conexion;

    public EquipoMiembroData() {

        con = Conexion.getConexion();

    }

    public void guardarEquipoMiembro(EquipoMiembro equipoMiembro) {
        try {
            String sql = "INSERT INTO equipomiembros(fechaIncorporacion, idEquipo, idMiembro) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(equipoMiembro.getFechaIncorporacion()));
            ps.setInt(2, equipoMiembro.getIdEquipo());
            ps.setInt(3, equipoMiembro.getIdMiembro());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion de miembro a equipo con exito");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                equipoMiembro.setIdMiembroEq(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla EquipoMiembros" + ex.getMessage());
        }
    }
}
