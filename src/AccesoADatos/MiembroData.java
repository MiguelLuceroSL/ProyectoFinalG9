package AccesoADatos;

import Entidades.EquipoMiembro;
import Entidades.Miembro;
import java.sql.Connection;
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
            String sql = "INSERT INTO miembro(dni, apellido, nombreM, estado) VALUES (?,?,?,?)";
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

    public Miembro buscarMiembroPorId(int idm) {
        Miembro miembro = new Miembro();
        String sql = "SELECT * FROM miembro WHERE idMiembro=?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, idm);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                miembro.setApellido(rs.getString("apellido"));
                miembro.setDni(rs.getInt("dni"));
                miembro.setEstado(rs.getBoolean("estado"));
                miembro.setIdMiembro(rs.getInt("idMiembro"));
                miembro.setNombre(rs.getString("nombreM"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el miembro");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla Miembro" + ex.getMessage());
        }
        return miembro;
    }
    
    public void activarMiembro(int id){
        try {
            String sql = "UPDATE miembro SET estado = 1 WHERE idMiembro = ? AND estado = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setBoolean(2, false);
            int fila = ps.executeUpdate();
            ps.close();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se activó el miembro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Miembro "+e.getMessage());
        }
    }
    
    public void desactivarMiembro(int id){
        EquipoMiembroData eqMiD = new EquipoMiembroData();
        EquipoMiembro eqMi;
        try {
            String sql = "UPDATE miembro SET estado = 0 WHERE idMiembro = ? AND estado = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setBoolean(2, true);
            int fila = ps.executeUpdate();
            ps.close();
            if (fila == 1) {
                eqMi = eqMiD.buscarEquipoMiembroPorIdMiembro(id);
                eqMiD.borrarMiembroEq(eqMi.getIdMiembroEq());
                JOptionPane.showMessageDialog(null, " Se desactivó el miembro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Miembro "+e.getMessage());
        }
    }
    
    public void activarDesactivar(int id){
        Miembro miembro = buscarMiembroPorId(id);
        if (miembro.isEstado()) {
            desactivarMiembro(id);
        } else {
            activarMiembro(id);
        }
    }
}
