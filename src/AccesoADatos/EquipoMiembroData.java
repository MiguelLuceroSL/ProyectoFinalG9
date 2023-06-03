package AccesoADatos;

import Entidades.Equipo;
import Entidades.EquipoMiembro;
import Entidades.Miembro;
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
            ps.setInt(2, equipoMiembro.getEquipoId().getIdEquipo());
            ps.setInt(3, equipoMiembro.getMiembroId().getIdMiembro());

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

    public EquipoMiembro buscarEquipoMiembroPorId(int idEqM) {
        EquipoMiembro equipoMiembro = new EquipoMiembro();
        Equipo equipo;
        EquipoData equipoD = new EquipoData();
        Miembro miembro;
        MiembroData miembroD = new MiembroData();
        String sql = "SELECT * FROM equipomiembros WHERE idMiembroEq=?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEqM);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                equipo = equipoD.buscarEquipoPorId(rs.getInt("idEquipo"));
                miembro = miembroD.buscarMiembroPorId(rs.getInt("idMiembro"));
                equipoMiembro.setEquipoId(equipo);
                equipoMiembro.setMiembroId(miembro);
                equipoMiembro.setIdMiembroEq(idEqM);
                equipoMiembro.setFechaIncorporacion(rs.getDate("fechaIncorporacion").toLocalDate());
            } else {
                JOptionPane.showMessageDialog(null, "No existe el equipo-miembro");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla Equipo-Miembro" + ex.getMessage());
        }
        
        return equipoMiembro;
    }
}
