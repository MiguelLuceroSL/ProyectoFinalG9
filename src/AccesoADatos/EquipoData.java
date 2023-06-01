package AccesoADatos;

import Entidades.Equipo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class EquipoData {

    private Connection con = null;
    private Conexion conexion;

    public EquipoData() {

        con = Conexion.getConexion();

    }

    public void guardarEquipo(Equipo equipo) {
        try{
            String sql = "INSERT INTO equipo(idProyecto, nombre, fechaCreacion, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, equipo.getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, Date.valueOf(equipo.getFechaCreacion()));
            ps.setBoolean(4, equipo.isEstado());
            if (ps.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null,"Equipo creado con exitoso");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                equipo.setIdEquipo(rs.getInt(1));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR al acceder a la tabla Equipo "+ex.getMessage());
        }
    }
}
